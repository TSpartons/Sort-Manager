package SortManager.Bubble;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.*;

import java.util.Random;

public class BubbleSortTests{

    BubbleSort bubbleSort = new BubbleSort();
    int[] numbers = {5,7,3,2,1};
    int[] orderedNumbers = {1,2,3,5,7};

    Logger logger = Logger.getLogger("myLogger");

    @Test
    public void AssertEqualsTest()
    {
        Logger logger = Logger.getLogger("myLogger");
        try {
            Handler fileHandler = new FileHandler("src/test/java/SortManager/Bubble/BubbleLog.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "Bubble Sort Assertion Test: " + arrToString(numbers));
        Assertions.assertArrayEquals(orderedNumbers, bubbleSort.sort(numbers));
        logger.log(Level.INFO, "Success!!! \n Post Sort: " + arrToString(bubbleSort.sort(numbers)));
    }

    @Test
    public void RandTest()
    {
        //Generate Random Array
        int[] arr = new int[GenerateNumber()];
        FillArray(arr);

        Logger logger = Logger.getLogger("myLogger");
        try {
            Handler fileHandler = new FileHandler("src/test/java/SortManager/Bubble/BubbleLog.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.log(Level.INFO, "Bubble Sort Random Test - Numbers In: " + arrToString(arr));
        logger.log(Level.WARNING, "Post Sort: " + arrToString(bubbleSort.sort(arr)));
    }

    int GenerateNumber() {
        Random random = new Random();
        return random.nextInt( 50);
    }

    void FillArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i)
            arr[i] = GenerateNumber();
    }

    String arrToString(int[] arr)
    {
        String nums = "";
        for (int i = 0; i < arr.length; ++i)
            nums += String.valueOf(arr[i]) + ",";
        return nums;
    }
}
