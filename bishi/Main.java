package bishi;
//import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    break;
                }
                System.out.println(i + " " +j);
            }
        }
        return new int[2];
    }
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        twoSum(arr, 9);
    }
}
