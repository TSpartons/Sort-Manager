package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class myScan {

    private Scanner myScanner;

    public myScan() {
        myScanner = new Scanner(System.in);
    }

    public boolean takeInput(String desired) {

        if(myScanner.next().equals(desired))
            return true;
        else
            return false;
    }

    private boolean correctInput = false;
    public int takeInput() {

        int input = 0;

        while(correctInput == false) {

            try {
                input = myScanner.nextInt();
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a NUMBER");
                myScanner.nextLine();
            }
        }
        correctInput = false;
        return input;
    }

    public void close() {
        myScanner.close();
    }

}
