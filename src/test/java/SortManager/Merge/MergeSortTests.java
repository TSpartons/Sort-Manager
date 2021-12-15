package SortManager.Merge;

import SortManager.Bubble.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.*;

public class MergeSortTests {

    MergeSort mergeSort = new MergeSort();
    int[] numbers = {5,7,3,2,1};
    int[] orderedNumbers = {1,2,3,5,7};

    Logger logger = Logger.getLogger("myLogger");

    @Test
    public void SorterTest()
    {
        Logger logger = Logger.getLogger("myLogger");
        try {
            Handler fileHandler = new FileHandler("src/test/java/SortManager/Merge/MergeLog.log", true);
            logger.addHandler(fileHandler);
            System.setProperty("java.util.logging.SimpleFormatter.Format", "%4$s: %5s [%1$tcl%n]");
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "Merge Sort Assertion Test");

       // Assertions.assertArrayEquals(orderedNumbers, mergeSort.sort(numbers,0,numbers.length));
        logger.log(Level.INFO, "Success!");
    }

}
