import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int REPEATS = 10;
        Main myMain = new Main();

        int[] unSortedArry = myMain.createArray(1000_000);
        int[] regSortedArry = unSortedArry;
        int[] parSortedArry = unSortedArry;

        //myMain.printArray(unSortedArry);

        /*The regular merge sort*/
        RegularSort regMergeSort = new RegularSort();
        regMergeSort.sort(regSortedArry, 0, unSortedArry.length - 1);

        final long seqStartTime = System.currentTimeMillis();
        for (int r = 0; r < REPEATS; r++) {
            regMergeSort.sort(unSortedArry, 0, unSortedArry.length - 1);
        }

        final long seqEndTime = System.currentTimeMillis();
        final long seqTime = (seqEndTime - seqStartTime) / REPEATS;

        myMain.printArray(regSortedArry);
        System.out.println("Regular merge sort took: " + seqTime + " ms");



    /*The parallel version */
       /* //int numTasks=Runtime.getRuntime().availableProcessors();
        int numTasks=100;
        double parallelSum = new ParallelSort(arry,0,arry.length,numTasks).compute();

        final long parStartTime = System.currentTimeMillis();
        for (int r=0; r<REPEATS; r++){
            new ParallelSumArray(arry,0,arry.length,numTasks).compute();;
        }
        final long parEndTime = System.currentTimeMillis();
        final long parTime = (parEndTime - parStartTime) / REPEATS;

        System.out.println("The parallel sum is: " + parallelSum + ", It took: " + parTime + " ms");

        *//* Overall SpeedUp*//*
        double speedup = (double)seqTime / (double)parTime;
        System.out.println("The overall Speedup: "+speedup);
*/
    }

    private int[] createArray(int n) {
        final int[] input = new int[n];
        final Random rand = new Random(314);
        for (int i = 0; i < n; i++) {
            input[i] = rand.nextInt(100);
            // Don't allow zero values in the input array
            if (input[i] == 0.0) {
                i--;
            }
        }
        return input;
    }

    private void printArray(int[] arry) {
        System.out.println();
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i] + " ");
        }
        System.out.println();
    }


}

