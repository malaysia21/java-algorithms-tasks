package linkedlist;

import lombok.Data;

@Data
public class LinkList {

    public Link firstLink;

    public boolean isEmpty() {
        return firstLink == null;
    }

    public void insertFirstLink(String bookName, int edition) {
        Link newLink = new Link(bookName, edition);
        newLink.setNext(firstLink);
        firstLink = newLink;
    }

    public Link removeFirstLink() {
        Link referenceLink = firstLink;
        if (!isEmpty()) {
            firstLink = firstLink.getNext();
        } else {
            System.out.println("Empty linkedList");
        }
        return referenceLink;
    }

    public void display() {
        Link theLink = firstLink;
        while (theLink != null) {
            theLink.display();
            theLink = theLink.getNext();
        }
    }

    public Link find(String bookName) {
        Link theLink = firstLink;

        if (!isEmpty()) {

            while (!theLink.getBookName().equals(bookName)) {

                if(theLink.getNext() == null){
                    return null;
                } else {
                    theLink =  theLink.getNext();
                }
            }
        } else {
            System.out.println("Empty LinkedList");
        }
        return theLink;
    }

    public Link removeLink(String bookName){
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while(!currentLink.getBookName().equals(bookName)){

            if(currentLink.getNext() == null){
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.getNext();
            }
        }

        if(currentLink == firstLink){
            firstLink = currentLink.getNext();
        } else {
            previousLink.setNext(currentLink.getNext());
        }

        return currentLink;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirstLink("Book1", 100);
        linkList.insertFirstLink("Book2", 100);
        linkList.insertFirstLink("Book3", 100);
        linkList.insertFirstLink("Book4", 100);
        linkList.display();

        System.out.println("Find Book2: "  +  linkList.find("Book2"));

        linkList.removeFirstLink();
        System.out.println("List after removing first element:");
        linkList.display();

        linkList.removeLink("Book2");
        System.out.println("List after removing Book2");
        linkList.display();
    }
}