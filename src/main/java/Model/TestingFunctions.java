package Model;

import java.util.Random;

//This class contains functionality used in testing. Maybe renamed something else
public class TestingFunctions {

    private Random random = new Random();

    //Returns and int[] as a string
    public String arrToString(int[] arr)
    {
        String nums = "";
        if(arr.length > 1)
            for (int i = 0; i < arr.length; ++i)
                nums += String.valueOf(arr[i]) + ",";
        else if(arr.length == 1)
                nums += String.valueOf(arr[0]) + ",";

        return nums;
    }

    public int GenerateNumber() {
        return random.nextInt(-50,50);
    }

    //Cannot generate negative array size
    public int GenerateNumberArr() {
        return random.nextInt(50);
    }

    public void FillArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i)
            arr[i] = GenerateNumber();
    }

}
