
package top100;

//web https://leetcode.cn/problems/find-the-duplicate-number


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class   findTheDuplicateNumber {
    private static class Solution {

        public Solution() {
        }


        public int findDuplicate(int[] nums) {
//            for (int i = 0; i < nums.length - 1; ++i) {
//                for (int j = i + 1; j < nums.length; ++j) {
//                    if (nums[i] == nums[j])
//                        return nums[i];
//                }
//            }
//            return 0;

            int slow = 0, fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        int[] nums = {1,3,4,2,2};

        int duplicate = solution.findDuplicate(nums);
        System.out.println(duplicate);


    }
}
