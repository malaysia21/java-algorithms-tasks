package linkedlist;

import lombok.Data;

@Data
public class DoubleEndedLinkedList {

    private Neighbour firstLink;
    private Neighbour lastLink;

    public void insertInFirstPosition(String ownerName, int houseNumber) {
        Neighbour newFirst = new Neighbour(ownerName, houseNumber);

        if (isEmpty()) {
            lastLink = newFirst;
        } else {
            firstLink.setPrevious(newFirst);
        }
        newFirst.setNext(firstLink);
        firstLink = newFirst;
    }

    public void insertInLastPosition(String ownerName, int houseNumber) {
        Neighbour newLast = new Neighbour(ownerName, houseNumber);
        if (isEmpty()) {
            firstLink = newLast;
        } else {
            lastLink.setNext(newLast);
            newLast.setPrevious(lastLink);
        }
        lastLink = newLast;
    }

    public boolean insertAfterKey(String ownerName, int houseNumber, int key) {
        Neighbour newLink = new Neighbour(ownerName, houseNumber);
        Neighbour current = firstLink;

        while (current.getHouseNumber() != key) {
            current = current.getNext();

            if (current == null) {
                return false;
            }
        }

        if (current == lastLink) {
            newLink.setNext(null);
            lastLink = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
        }

        newLink.setPrevious(current);
        current.setNext(newLink);
        return true;
    }


    public void insertInOrder(String ownerName, int houseNumber) {
        Neighbour newLink = new Neighbour(ownerName, houseNumber);
        Neighbour previous = null;
        Neighbour current = firstLink;

        while (current != null && houseNumber > current.getHouseNumber()) {
            previous = current;
            current = current.getNext();
        }

        if (current == null && previous == null) {
            firstLink = newLink;
            lastLink = newLink;
        } else if (previous == null) {
            newLink.setNext(current);
            current.setPrevious(newLink);
            firstLink = newLink;
        } else if (current == null) {
            previous.setNext(newLink);
            newLink.setPrevious(previous);
            lastLink = newLink;
        } else {
            previous.setNext(newLink);
            newLink.setPrevious(previous);
            newLink.setNext(current);
            current.setPrevious(newLink);
        }
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public void display() {
        Neighbour currentLink = firstLink;
        while (currentLink != null) {
            currentLink.display();
            currentLink = currentLink.getNext();
        }
    }

    public void displayWithDetails() {
        Neighbour currentLink = firstLink;
        while (currentLink != null) {
            currentLink.display();
            System.out.println("--Next Link: " + currentLink.getNext());
            System.out.println("--Previous Link: " + currentLink.getPrevious());
            currentLink = currentLink.getNext();
        }
    }

    public static void main(String[] args) {
        System.out.println("LinkedList");
        DoubleEndedLinkedList linkedList = new DoubleEndedLinkedList();
        linkedList.insertInFirstPosition("Smith", 7);
        linkedList.insertInLastPosition("Mark", 16);
        linkedList.insertInFirstPosition("Jones", 22);
        linkedList.insertInLastPosition("Adams", 38);
        linkedList.insertAfterKey("Tomas", 50, 22);
        linkedList.displayWithDetails();

        System.out.println("LinkedList in order");
        DoubleEndedLinkedList linkedListInOrder = new DoubleEndedLinkedList();
        linkedListInOrder.insertInOrder("Jones", 22);
        linkedListInOrder.insertInOrder("Smith", 7);
        linkedListInOrder.insertInOrder("Mark", 16);
        linkedListInOrder.insertInOrder("Adams", 38);
        linkedListInOrder.displayWithDetails();

        System.out.println("ListIterator");
        NeighborIterator neighborIterator = new NeighborIterator(linkedList);
        System.out.println(neighborIterator.hasNext());

        System.out.println("Current:");
        neighborIterator.getCurrent().display(); //Jones

        System.out.println("Remove");
        neighborIterator.remove(); //Remove-Jones

        System.out.println("Current:");
        neighborIterator.getCurrent().display(); //Thomas

        System.out.println("Next");
        neighborIterator.next();

        System.out.println("Current:");
        neighborIterator.getCurrent().display(); //Smith

        System.out.println("Next");
        neighborIterator.next();

        System.out.println("Remove");
        neighborIterator.remove();  //remove Mark

        System.out.println("Remove");
        neighborIterator.remove();  //remove Adams

        linkedList.displayWithDetails();

    }
}
