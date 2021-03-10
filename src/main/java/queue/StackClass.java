package queue;

import java.util.Arrays;

public class StackClass {

    private String[] stackArray;
    private int stackSize;
    private int topOfStack = -1;

    public StackClass(int stackSize) {
        this.stackSize = stackSize;
        stackArray = new String[stackSize];

        Arrays.fill(stackArray, "-1");
    }

    public void push(String input) {
        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            stackArray[topOfStack] = input;
            System.out.println("PUSH - " + input + " was added to the Stack");
        } else {
            System.out.println("Stack is full");
        }

        displayStack();
    }

    public String pop() {
        String popValue = null;
        if (topOfStack >= 0) {
            popValue = stackArray[topOfStack];
            stackArray[topOfStack] = "-1";
            topOfStack--;
            System.out.println("POP - " + popValue + " was removed from the Stack");
        } else {
            System.out.println("Stack is empty");
        }
        displayStack();
        return popValue;
    }

    public String peek() {
        String peekValue = null;
        if (topOfStack >= 0) {
            System.out.println("PEEK - " + stackArray[topOfStack] + " from the Stack");
            peekValue = stackArray[topOfStack];
        } else {
            System.out.println("Stack is empty");
        }
        displayStack();
        return peekValue;
    }

    public void pushMany(String multipleValue){
        String[] tempString = multipleValue.split(" ");
        for (String s : tempString) {
            push(s);
        }
    }

    private void popAll(){
        for(int i = topOfStack; i>=0; i--){
            pop();
        }
    }

    public void popDisplayAll(){
        String theReverse = "";
        for(int i = topOfStack; i >= 0; i--){
            theReverse = theReverse.concat(stackArray[i]).concat(" ");
        }
        System.out.println("The Reverse: " + theReverse);
        popAll();
    }

    private void displayStack() {
        System.out.println("Stack:");
        for (int i = 0; i < stackSize; i++) {
            System.out.print(" |" + i + "| ");
            System.out.println(stackArray[i]);
        }
    }

    public static void main(String[] args) {
        StackClass stackClass = new StackClass(10);
        stackClass.push("19");
        stackClass.push("18");
        stackClass.push("17");
        stackClass.push("16");
        stackClass.peek();
        stackClass.pop();
        stackClass.peek();
        stackClass.pushMany("20 21 22");
        stackClass.popDisplayAll();
        stackClass.popAll();
    }
}
