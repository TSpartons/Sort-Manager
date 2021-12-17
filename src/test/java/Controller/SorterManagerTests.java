package Controller;

import Model.Merge.MergeSort;
import Model.TestingFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

//This testing class can be used for all sort algorithms
public class SorterManagerTests {


        private SorterManager sorterManager = new SorterManager();
        Logger logger = Logger.getLogger("myLogger");
        TestingFunctions testingFunctions = new TestingFunctions();

        //CHANGE TO RUN TESTS FOR A DIFFERENT ALGORITHM
        private int algorithm = 1;  //1 - bubble | 2 - merge | 3 - Tree


        public void assertionTemplate(int[] arr, int[] orderedArr){
                logger.log(Level.INFO, "Numbers in: " + testingFunctions.arrToString(arr));
                Assertions.assertArrayEquals(orderedArr,  sorterManager.currentSorter.Sort(arr));
                logger.log(Level.INFO, "Success!!!");
        }

        public SorterManagerTests() {
                try {
                        Handler fileHandler = new FileHandler("src/test/java/Controller/SorterManagerTestLog.log", true);
                        logger.addHandler(fileHandler);
                        System.setProperty("java.util.logging.SimpleFormatter.Format", "%4$s: %5s [%1$tcl%n]");
                        fileHandler.setFormatter(new SimpleFormatter());
                } catch (IOException e) {
                        e.printStackTrace();
                }
                sorterManager.select(algorithm);
        }


        @BeforeEach
        private void stateAlgorithm() {
                logger.log(Level.INFO, "Running " + sorterManager.getSorterSelected() + " sorting algorithm");
        }


        @Test
        public void standardTest()
        {
                int[] arr = {8,12,2,54,9};
                int[] orderedArr = {2,8,9,12,54};
                assertionTemplate(arr,orderedArr);
        }

        @Test
        public void  negativesTest() {
                int[] arr = {-8, -12, -16, -5};
                int[] orderedArr = {-16, -12, -8, -5};

                assertionTemplate(arr,orderedArr);
        }

        @Test
        public void singleDigitTest() {
                int[] arr = {6};
                int[] orderedArr = {6};

                assertionTemplate(arr,orderedArr);
        }

        @Test
        public void randTest()
        {
                //Array size upperBound = 50;
                int[] arr = new int[testingFunctions.GenerateNumberArr()];
                //Array is filled with random numbers. Bounds {-50,50}
                testingFunctions.FillArray(arr);

                logger.log(Level.INFO, sorterManager.getSorterSelected() + " sorter randomised test - Numbers In: " + testingFunctions.arrToString(arr));
                logger.log(Level.INFO, "Post Sort: " + testingFunctions.arrToString(sorterManager.currentSorter.Sort(arr)));
        }


        //Manually stopped after 10 minutes. No reason why this shouldn't work. Uncomment at your own peril
//        @Test
//        public void theTwoTrillionTest() {
//                int[] arr = new int[200000000];
//                testingFunctions.FillArray(arr);
//                logger.log(Level.INFO, testingFunctions.arrToString(sorterManager.currentSorter.Sort(arr)));
//        }

}
