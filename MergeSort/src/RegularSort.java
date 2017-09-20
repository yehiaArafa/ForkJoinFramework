public class RegularSort {


    public void sort(int[] unsortedArry, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int mid = startIndex + ((endIndex - startIndex) / 2);
        sort(unsortedArry, startIndex, mid);
        sort(unsortedArry, mid + 1, endIndex);
        merge(unsortedArry, startIndex, mid, endIndex);
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
