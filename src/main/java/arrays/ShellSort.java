package arrays;

public class ShellSort {

    public static void shellSort(int [] array, int arraySize){
        System.out.println("Shell sort");
        int inner, outer, temp;
        int interval = 1;

        while(interval <= arraySize/ 3) {
            interval = interval * 3 + 1;
        }

            while(interval >0){

                for(outer = interval; outer< arraySize; outer++){
                    temp = array[outer];
                    inner = outer;

                    while(inner > interval -1 && array[inner-interval]>=temp){

                        array[inner] = array[inner-interval];
                        inner-=interval;
                    }

                    array[inner] = temp;
                }
                interval = (interval -1)/3;
            }

        ArrayPrinter.printArray(array, arraySize);
    }
}
