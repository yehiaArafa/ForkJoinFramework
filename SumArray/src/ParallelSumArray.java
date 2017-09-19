import java.util.concurrent.RecursiveTask;

public class ParallelSumArray extends RecursiveTask<Double> {

    final int taskThreshold;
    double arry[];
    int startIndex, endIndex;
    double sum = 0;

    public ParallelSumArray(double arry[], int low, int high, int numTask) {
        this.arry = arry;
        this.startIndex = low;
        this.endIndex = high;
        this.taskThreshold = numTask;
    }

    @Override
    protected Double compute() {
        if ( (this.endIndex - this.startIndex) <= this.taskThreshold) { //problem is small enough --> solve the problem seq.
            for (int i = this.startIndex; i < this.endIndex; i++) {
                sum += this.arry[i];
            }
            return sum;
        } else { // divide the problem into parallel tasks
            int mid = this.startIndex + ((this.endIndex - this.startIndex) / 2);
            ParallelSumArray left = new ParallelSumArray(this.arry, this.startIndex, mid, this.taskThreshold);
            ParallelSumArray right = new ParallelSumArray(this.arry, mid, this.endIndex, this.taskThreshold);
            left.fork();
            double righAns = right.compute();
            double leftAns = left.join();
            sum = leftAns + righAns;
            return sum;
        }

    }
}
