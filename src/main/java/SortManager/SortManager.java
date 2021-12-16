package SortManager;

import SortManager.Bubble.BubbleSort;
import SortManager.Merge.MergeSort;
import SortManager.Tree.TreeSort;

public class SortManager {

    private BubbleSort bubbleSort = new BubbleSort();
    private MergeSort mergeSort = new MergeSort();
    private TreeSort treeSort = new TreeSort();
    public Sorter currentSorter;

    public void select(int algorithm) {
        switch (algorithm) {
            case 1:
                currentSorter = bubbleSort;
                break;
            case 2:
                currentSorter = mergeSort;
                break;
            case 3:
                currentSorter = treeSort;
                break;
            case default:
                System.out.println("Please choose: 1,2, or 3");
        }
    }

}
