package SortManager.Bubble;

import SortManager.SortManager;
import SortManager.TestingFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.*;

public class BubbleSortTests{

    BubbleSort bubbleSort = new BubbleSort();
    int[] numbers = {5,7,35,2,1};
    int[] orderedNumbers = {1,2,35,5,7};
    TestingFunctions testParent= new TestingFunctions();

    Logger logger = Logger.getLogger("myLogger");

    public BubbleSortTests(){
        try {
            Handler fileHandler = new FileHandler("src/test/java/SortManager/Bubble/BubbleLog.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AssertEqualsTest()
    {
        logger.log(Level.INFO, "Numbers in: " + testParent.arrToString(numbers));
        Assertions.assertArrayEquals(orderedNumbers,  (numbers));
        logger.log(Level.INFO, "Success!!!");
    }

    @Test
    public void RandTest()
    {
        //Generate Random Array
        int[] arr = new int[testParent.GenerateNumber()];
        testParent.FillArray(arr);

        logger.log(Level.INFO, "Bubble Sort Random Test - Numbers In: " + testParent.arrToString(arr));
        logger.log(Level.WARNING, "Post Sort: " + testParent.arrToString(bubbleSort.Sort(arr)));
    }

}
