import java.util.Random;

public class Main {


    public static void main(String[] args) {

        int REPEATS =10;
        Main myMain = new Main();

        double[] arry = myMain.createArray(1000_000_00);
        //myMain.printArray(arry);

     /*Computing the sum sequentialy*/
        double sequentialSum = myMain.computeSquentialSum(arry);

        final long seqStartTime = System.currentTimeMillis();
        for (int r=0; r<REPEATS; r++){
            myMain.computeSquentialSum(arry);
        }
        final long seqEndTime = System.currentTimeMillis();
        final long seqTime = (seqEndTime - seqStartTime) / REPEATS;

        System.out.println("The sequential sum is: " + sequentialSum + ", It took: " + seqTime + " ms");



    /* compute the sum parallely*/
        //int numTasks=Runtime.getRuntime().availableProcessors();
        int numTasks=100;
        double parallelSum = new ParallelSumArray(arry,0,arry.length,numTasks).compute();

        final long parStartTime = System.currentTimeMillis();
        for (int r=0; r<REPEATS; r++){
            new ParallelSumArray(arry,0,arry.length,numTasks).compute();;
        }
        final long parEndTime = System.currentTimeMillis();
        final long parTime = (parEndTime - parStartTime) / REPEATS;

        System.out.println("The parallel sum is: " + parallelSum + ", It took: " + parTime + " ms");

        /* Overall SpeedUp*/
        double speedup = (double)seqTime / (double)parTime;
        System.out.println("The overall Speedup: "+speedup);

    }

    private double[] createArray(int n) {
        final double[] input = new double[n];
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

    private void printArray(double[] arry) {
        System.out.println();
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i] + " ");
        }
        System.out.println();
    }

    private double computeSquentialSum(double[] arry) {
        double sum = 0;
        for (int i = 0; i < arry.length; i++) {
            sum += arry[i];
        }
        return sum;
    }

}
