package recursion;

public class Recursion {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println("Triangular number: " + recursion.getTriangularNumber(6));
        System.out.println("Triangular number recursion: " + recursion.getTriangularNumberWithRecursion(6));
        System.out.println("Factorial: " + recursion.getFactorial(6));
    }

    //without recursion
    private int getTriangularNumber(int number) {
        int triangularNumber = 0;

        while (number > 0) {
            triangularNumber += number;
            number--;
        }

        return triangularNumber;
    }

    private int getTriangularNumberWithRecursion(int number) {

        if (number == 1) {
            return 1;
        } else {
            return number + getTriangularNumberWithRecursion(--number);
        }
    }

    private int getFactorial(int factorial){

        if(factorial ==1){
            return 1;
        } else {
            return factorial * getFactorial(--factorial);
        }
    }
}
