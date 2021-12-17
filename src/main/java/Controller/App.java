package Controller;

import Model.TestingFunctions;

import java.util.Scanner;

//User facing stuff
public class App {

    private static SorterManager sorterManager;
    private static myScan scanner;
    private static TestingFunctions testingFunctions;
    private boolean quit;
    private boolean sameNumbers;

    public App() {
        sorterManager = new SorterManager();
        scanner = new myScan();
        testingFunctions = new TestingFunctions();
        quit = false;
        sameNumbers = false;
    }

    int[] arr;

    //If I managed my time better I would have broken this into functions
    public static void main(String[] args) {
        App app = new App();
        System.out.println("Would you like to order some numbers: ");
        System.out.println("Y/N");

        if(!scanner.takeInput("N")) {

            while (!app.quit) {

                System.out.println("How many numbers would you like to order?");
                app.arr = new int[scanner.takeInput()];
                System.out.println("Please enter numbers, pressing enter after each entry");
                for(int i = 0; i < app.arr.length; ++i) {
                    app.arr[i] = app.scanner.takeInput();
                }
                app.sameNumbers = true;

                while(app.sameNumbers) {
                    System.out.println("Your numbers: " + app.testingFunctions.arrToString(app.arr));
                    System.out.println("Select an Algorithm");
                    System.out.println("1: Bubble, 2: Merge, 3: Tree");
                    while (sorterManager.getSorterSelected() == null)
                        sorterManager.select(app.scanner.takeInput());


                    System.out.println(app.testingFunctions.arrToString(sorterManager.currentSorter.Sort(app.arr)));
                    System.out.println("Time taken: " + sorterManager.currentSorter.getSpeed() + " nano seconds");

                    System.out.println("Would you like to order the same numbers with a different algorithm");
                    System.out.println("Y/N");
                    if (scanner.takeInput("N"))
                         app.sameNumbers = false;
                    app.sorterManager.select(0);
                }
                System.out.println("Would you like to order some numbers: ");
                System.out.println("Y/N");
                if(scanner.takeInput("N"))
                    app.quit = true;
            }
        }
        scanner.close();
    }

}
