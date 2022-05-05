package top100;

//web https://leetcode-cn.com/problems/sort-colors


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class  sortColors {
    private static class Solution {

        public Solution() {
        }


        public void sortColors(int[] nums) {
//            Arrays.sort(nums);
            int n =nums.length;
            int[] copy = new int[n];
            for (int i = 0; i < n; ++i) {
                copy[i] = nums[i];
                nums[i] = 1;
            }
            int left = 0;
            int right = n-1;

            for (int j = 0 ; j < n; ++j) {
                if(copy[j] == 0) {
                    nums[left++] = copy[j];
                }
                else if(copy[j] == 2) {
                    nums[right--] = copy[j];
                }
            }

        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        int[] nums = {2,0,2,1,1,0};
        solution.sortColors(nums);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : nums) {
            stringBuilder.append(i).append(",");
        }
        System.out.println(stringBuilder.toString());


    }
}
