package SortManager.Bubble;

public class BubbleSort {

    public int[] sort(int[] toSort)
    {
        int swaps = 0;

        for (int i = 0; i < toSort.length-1; ++i) //For all numbers
            for (int j = 0; j < toSort.length-i-1; ++j) //Go through all numbers other than the last
                if (toSort[j] > toSort[j+1]) //If next number lower
                {
                    int temp = toSort[j]; //Store this number
                    toSort[j] = toSort[j+1]; //Make current position the lower number
                    toSort[j+1] = temp;//Make next position higher number
                    ++swaps;
                }
        System.out.println(swaps);
        return toSort;
    }
}
