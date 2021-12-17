package Controller;

import Model.Bubble.BubbleSort;
import Model.Merge.MergeSort;
import Model.Sorter;
import Model.Tree.TreeSort;

public class SorterManager {

    private static BubbleSort bubbleSort = new BubbleSort();
    private static MergeSort mergeSort = new MergeSort();
    private static TreeSort treeSort = new TreeSort();
    private String sorterSelected;
    public Sorter currentSorter;

    public String getSorterSelected() {
        return sorterSelected;
    }

    public void select(int algorithm) {
        switch (algorithm) {
            case 1:
                System.out.println("Bubble Selected");
                currentSorter = bubbleSort;
                sorterSelected = "Bubble";
                break;
            case 2:
                System.out.println("Merge Selected");
                currentSorter = mergeSort;
                sorterSelected = "Merge";
                break;
            case 3:
                System.out.println("Tree Selected");
                currentSorter = treeSort;
                sorterSelected = "Tree";
                break;
            case default:
                sorterSelected = null;
        }
    }

}
