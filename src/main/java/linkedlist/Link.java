package linkedlist;

import lombok.Data;

@Data
public class Link {

    private String bookName;
    private int edition;
    private Link next;

    public Link(String bookName, int edition) {
        this.bookName = bookName;
        this.edition = edition;
    }

    public void display(){
        System.out.println("Book name: " + bookName +  ", edition: " + edition);
    }

    public String toString(){
        return  bookName;
    }
}
