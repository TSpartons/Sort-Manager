package Model.Bubble;

import Model.TestingFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.*;

public class BubbleSortTests{

    BubbleSort bubbleSort = new BubbleSort();
    int[] numbers = {5,7,35,2,1};
    int[] orderedNumbers = {1,2,5,7,35};
    TestingFunctions testingFunctions = new TestingFunctions();

    Logger logger = Logger.getLogger("Controller.myLogger");

    public BubbleSortTests(){
        try {
            Handler fileHandler = new FileHandler("src/test/java/Model/Bubble/BubbleLog.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AssertEqualsTest()
    {
        logger.log(Level.INFO, "Numbers in: " + testingFunctions.arrToString(numbers));
        Assertions.assertArrayEquals(orderedNumbers,  bubbleSort.Sort(numbers));
        logger.log(Level.INFO, "Success!!!");
    }

    @Test
    public void RandTest()
    {
        //Generate Random Array
        int[] arr = new int[testingFunctions.GenerateNumberArr()];
        testingFunctions.FillArray(arr);

        logger.log(Level.INFO, "Bubble Sort Random Test - Numbers In: " + testingFunctions.arrToString(arr));
        logger.log(Level.WARNING, "Post Sort: " + testingFunctions.arrToString(bubbleSort.Sort(arr)));
    }

}
