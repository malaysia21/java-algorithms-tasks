package linkedlist;

import lombok.Data;

@Data
public class Neighbour {
    private String ownerName;
    private int houseNumber;
    private Neighbour next;
    private Neighbour previous;

    public Neighbour(String ownerName, int houseNumber) {
        this.ownerName = ownerName;
        this.houseNumber = houseNumber;
    }

    public void display(){
        System.out.println("Owner name: " + ownerName + ", house number: " + houseNumber);
    }

    public String toString(){
        return ownerName;
    }
}
