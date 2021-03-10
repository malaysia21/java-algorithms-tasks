package linkedlist;

import lombok.Data;

@Data
public class NeighborIterator {

    private Neighbour current;
    private Neighbour previous;

    private DoubleEndedLinkedList list;

    public NeighborIterator(DoubleEndedLinkedList list) {
        this.list = list;
        current = list.getFirstLink();
    }

    public boolean hasNext() {
       return current.getNext()!= null;
    }

    public Neighbour next() {
        if(hasNext()) {
            previous = current;
            current = current.getNext();

            return current;
        }
        return null;
    }


    public void remove(){
        if(previous == null){
            list.setFirstLink(current.getNext());
            current = current.getNext();
            current.setPrevious(null);
        } else {
            previous.setNext(current.getNext());

            if(current.getNext() == null){
                current = list.getFirstLink();
                previous = null;
            } else {
                current = current.getNext();
                current.setPrevious(previous);
            }
        }
    }
}
