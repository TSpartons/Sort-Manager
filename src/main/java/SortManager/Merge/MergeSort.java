package SortManager.Merge;

public class MergeSort {

    void Compare(int[] arr, int start, int end, int mid)
    {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for(int i = 0; i < left.length; ++i)
            left[i] = arr[start + i];
        for(int i = 0; i < right.length; ++i)
            right[i] = arr[i + mid + 1];

        //printArray(left); // quick-debug
        //printArray(right);// quick-debug

        //Compare and swap

        int indexMain = start;
        int indexLeft = 0, indexRight = 0;

        while (indexLeft < left.length && indexRight < right.length)
        {
            if(left[indexLeft] <= right[indexRight]) {
                arr[indexMain] = left[indexLeft];
                ++indexLeft;
            }
            else {
                arr[indexMain] = right[indexRight];
                ++indexRight;
            }
                ++indexMain;
        }

        while (indexLeft < left.length) {
            arr[indexMain] = left[indexLeft];
            ++indexMain;
            ++indexLeft;
        }

        while (indexRight < right.length) {
            arr[indexMain] = right[indexRight];
            ++indexMain;
            ++indexRight;
        }

    }

    //Break down array into
    public void Sort(int[] array, int start, int end){

        if(start == end)
            return; //run the next line of code in the else statement
        else
        {
            int mid = start + (end - start)/2;
           // System.out.print(mid); //quick debug;
            Sort(array,start,mid);
            //System.out.print(mid); // quick debug
            Sort(array,mid+1,end);
            Compare(array,start,end,mid);
        }
    }

    public static void main(String[] args) {
        int[] anArray = {5,2,1,7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.Sort(anArray, 0, anArray.length-1);

        mergeSort.printArray(anArray);

    }

    public void printArray(int[] array) {
        for (int i =0; i < array.length; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

}
