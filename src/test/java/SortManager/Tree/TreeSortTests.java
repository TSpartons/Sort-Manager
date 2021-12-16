package SortManager.Tree;

import SortManager.Merge.MergeSort;
import SortManager.TestingFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.*;

public class TreeSortTests {

    TreeSort treeSort = new TreeSort();
    int[] numbers = {5,7,3,2,1};
    int[] orderedNumbers = {1,2,3,5,7};
    TestingFunctions testingFunctions = new TestingFunctions();

    Logger logger = Logger.getLogger("myLogger");

    public TreeSortTests() {

        try {
            Handler fileHandler = new FileHandler("src/test/java/SortManager/Tree/TreeLog.log", true);
            logger.addHandler(fileHandler);
            System.setProperty("java.util.logging.SimpleFormatter.Format", "%4$s: %5s [%1$tcl%n]");
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AssertEqualsTest()
    {
        logger.log(Level.INFO, "Tree Sort Assertion Test: " + testingFunctions.arrToString(numbers));
        Assertions.assertArrayEquals(orderedNumbers, treeSort.Sort(numbers));
        logger.log(Level.INFO, "Success!");
    }

    @Test
    public void RandTest()
    {
        //Generate Random Array
        int[] arr = new int[testingFunctions.GenerateNumber()];
        testingFunctions.FillArray(arr);

        logger.log(Level.INFO, "Tree Sort Random Test - Numbers In: " + testingFunctions.arrToString(arr));
        logger.log(Level.WARNING, "Post Sort: " + testingFunctions.arrToString(treeSort.Sort(arr)));
    }
}
