package Model.Merge;

import Model.Sorter;

public class MergeSort implements Sorter {

    private long speed;
    private long start;
    private long end;

    @Override
    public long getSpeed() {
        return speed;
    }

    private void setSpeed() {
        speed = end - start;
    }

    @Override
    public int[] Sort(int[] array) {
        start = System.nanoTime();
        array = Breakdown(array, 0, array.length-1);
        end = System.nanoTime();
        setSpeed();

        return array;
    }

    //Splits the array up and uses the compare function
    public int[] Breakdown(int[] array, int start, int end){

        if(start == end)
            return null; //run the next line of code in the else statement
        else
        {
            int mid = start + (end - start)/2;
           // System.out.print(mid); //quick debug;
            Breakdown(array,start,mid);
            //System.out.print(mid); // quick debug
            Breakdown(array,mid+1,end);
            Compare(array,start,end,mid);
        }

        return array;
    }

    //Creates temp arrays and compares them to put them in ascending order
    private void Compare(int[] arr, int start, int end, int mid)
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

}
