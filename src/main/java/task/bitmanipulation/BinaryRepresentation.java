package task.bitmanipulation;

public class BinaryRepresentation {

    public static void main(String[] args) {
        System.out.println(findBinaryRepresentationSolution1(5L));
        System.out.println(findBinaryRepresentationSolution1(7L));
        System.out.println(findBinaryRepresentationSolution1(100L));

        findBinaryRepresentationSolution2(5L);
        findBinaryRepresentationSolution2(7L);
        findBinaryRepresentationSolution2(100L);


        System.out.println(String.format("%32s", findBinaryRepresentationSolution3(5L, new StringBuilder()).toString()).replaceAll(" ", "0"));
        System.out.println(String.format("%32s", findBinaryRepresentationSolution3(7L, new StringBuilder()).toString()).replaceAll(" ", "0"));
        System.out.println(String.format("%32s", findBinaryRepresentationSolution3(100L, new StringBuilder()).toString()).replaceAll(" ", "0"));


        System.out.println(String.format("%32s", findBinaryRepresentationSolution4(5, new StringBuilder()).toString()).replaceAll(" ", "0"));
        System.out.println(String.format("%32s", findBinaryRepresentationSolution4(7, new StringBuilder()).toString()).replaceAll(" ", "0"));
        System.out.println(String.format("%32s", findBinaryRepresentationSolution4(100, new StringBuilder()).toString()).replaceAll(" ", "0"));


    }

    private static String findBinaryRepresentationSolution1(long number) {
        StringBuilder result = new StringBuilder();

        for (int i = 31; i >= 0; i--) {

            if ((number & (1 << i)) == 0) {
                result.append("0");
            } else {
                result.append("1");
            }
        }

        return result.toString();
    }

    private static void findBinaryRepresentationSolution2(long number) {
        long i;
        System.out.print("0");
        for (i = 1 << 30; i > 0; i = i / 2) {
            if ((number & i) != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }

        System.out.println();
    }

    private static StringBuilder findBinaryRepresentationSolution3(long number, StringBuilder result) {

        if(number >1){
            findBinaryRepresentationSolution3(number/2, result);
        }

        return result.append(number % 2);
    }


    private static StringBuilder findBinaryRepresentationSolution4(int n, StringBuilder result)
    {
        if (n > 1)
            findBinaryRepresentationSolution4(n >> 1, result);

       return  result.append( n & 1);
    }
}
