public class RegularSort {


    public void sort(int [] unsortedArry, int [] temp, int startIndex, int endIndex){
        if (startIndex>=endIndex)
            return;
        int mid = startIndex + ((endIndex-startIndex)/2);
        sort(unsortedArry,temp,startIndex,mid);
        sort(unsortedArry,temp,mid,endIndex);
        merge(unsortedArry,temp,startIndex,endIndex);
    }

    private void merge(int [] arry, int [] temp, int leftHalf, int rightHalf){


    }

}
