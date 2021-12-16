package SortManager;

import java.util.Random;

public class TestingFunctions {

    public String arrToString(int[] arr)
    {
        String nums = "";
        for (int i = 0; i < arr.length; ++i)
            nums += String.valueOf(arr[i]) + ",";
        return nums;
    }

    public int GenerateNumber() {
        Random random = new Random();
        return random.nextInt( 50);
    }

    public void FillArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i)
            arr[i] = GenerateNumber();
    }

}
