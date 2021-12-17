package Model.Merge;

import Model.TestingFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.*;

public class MergeSortTests {

    MergeSort mergeSort = new MergeSort();
    int[] numbers = {5,7,3,27,1};
    int[] orderedNumbers = {1,3,5,7,27};
    TestingFunctions testingFunctions = new TestingFunctions();

    Logger logger = Logger.getLogger("Controller.myLogger");

    public MergeSortTests(){
        try {
            Handler fileHandler = new FileHandler("src/test/java/Model/Merge/MergeLog.log", true);
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
        logger.log(Level.INFO, "Merge Sort Assertion Test: " + testingFunctions.arrToString(numbers));
       Assertions.assertArrayEquals(orderedNumbers, mergeSort.Sort(numbers));
        logger.log(Level.INFO, "Success!");
    }

    @Test
    public void RandTest()
    {
        //Generate Random Array
        int[] arr = new int[testingFunctions.GenerateNumberArr()];
        testingFunctions.FillArray(arr);

        logger.log(Level.INFO, "Bubble Sort Random Test - Numbers In: " + testingFunctions.arrToString(arr));
        logger.log(Level.WARNING, "Post Sort: " + testingFunctions.arrToString(mergeSort.Sort(arr)));
    }

}
