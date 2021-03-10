package queue;

import java.util.Arrays;

public class QueueClass {

    private String [] arrayQueue;
    private int queueSize;
    private int front;
    private int back;
    private int numberOfItems;

    public QueueClass(int queueSize) {
        this.queueSize = queueSize;
        arrayQueue =  new String[queueSize];
        Arrays.fill(arrayQueue, "-1");
    }

    public void insert(String input){
        if(numberOfItems+1 <= queueSize){
            arrayQueue[back] = input;
            back++;
            numberOfItems++;
            System.out.println("INSERT " + input + "");
        } else {
            System.out.println("Queue is full");
        }
    }

    public String remove(){
        String returnValue = null;
        if(numberOfItems>0){
            returnValue = arrayQueue[front];
            arrayQueue[front] = "-1";
            front++;
            System.out.println("REMOVE " + returnValue);
        } else {
            System.out.println("Queue is empty");
        }
        return returnValue;
    }

    public void peek(){
        if(numberOfItems>0) {
            System.out.println("The first element is " + arrayQueue[front]);
        } else {
            System.out.println("Queue is empty");
        }
    }

    public void priorityInsert(String input){
        int i = 0;

        if(numberOfItems == 0){
            insert(input);
        } else {
            for(i = numberOfItems-1; i >=0; i--){
                if(Integer.parseInt(input)> Integer.parseInt(arrayQueue[i])){
                    arrayQueue[i+1] = arrayQueue[i];
                } else break;
            }

            arrayQueue[i+1] = input;
            back++;
            numberOfItems++;
        }
    }

    private void displayQueue() {
        System.out.println("Stack:");
        for (int i = 0; i < queueSize; i++) {
            System.out.print(" |" + i + "| ");
            System.out.println(arrayQueue[i]);
        }
    }

    public static void main(String[] args) {
        QueueClass queueClass = new QueueClass(10);
        queueClass.insert("10");
        queueClass.insert("15");
        queueClass.insert("11");
        queueClass.displayQueue();
        queueClass.peek();
        queueClass.remove();
        queueClass.peek();
        queueClass.displayQueue();
    }

}
