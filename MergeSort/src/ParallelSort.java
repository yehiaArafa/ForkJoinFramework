import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ParallelSort extends RecursiveAction {

    int[] arry;
    int startIndex, endIndex;
    int taskThreshold;

    public ParallelSort(int arry[], int startIndex, int endIndex, int numTask) {
        this.arry = arry;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.taskThreshold = numTask;
    }

    @Override
    protected void compute() {

        if ((endIndex - startIndex) <= taskThreshold) {
            Arrays.sort(arry);
            return;
        }

        int mid = startIndex + ((endIndex - startIndex) / 2);
        invokeAll(new ParallelSort(arry, startIndex, mid, this.taskThreshold), new ParallelSort(arry, (mid+1), endIndex, this.taskThreshold));
        merge(arry, startIndex, mid, endIndex);

    }


    private void merge(int[] arry, int lowerIndex, int middle, int higherIndex) {

        int[] tempMergArr = new int[arry.length];

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = arry[i];
        }

        int leftPtr = lowerIndex;
        int rightPtr = middle + 1;
        int index = lowerIndex;
        while (leftPtr <= middle && rightPtr <= higherIndex) {
            if (tempMergArr[leftPtr] <= tempMergArr[rightPtr]) {
                arry[index] = tempMergArr[leftPtr];
                leftPtr++;
            } else {
                arry[index] = tempMergArr[rightPtr];
                rightPtr++;
            }
            index++;
        }
        while (leftPtr <= middle) {
            arry[index] = tempMergArr[leftPtr];
            index++;
            leftPtr++;
        }
    }
}
