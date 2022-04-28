package top100;

//web https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array


import java.util.HashMap;

public class findFirstAndLastPositionOfElementInSortedArray {
    private static class Solution {

        public Solution() {
        }
        public int[] searchRange(int[] nums, int target) {
            int[] ints = {-1,-1};
            int left = 0, right = nums.length-1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    int index = mid;
                    while(index >= 0 && nums[index]==target){
                        ints[0] = index;
                        index--;
                    }
                    index = mid;
                    while(index < nums.length && nums[index]==target){
                        ints[1] = index;
                        index++;
                    }
                    return ints;
                }
            }
            return ints;
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 5;
        int[] lists = solution.searchRange(nums, target);
        for (int i : lists)
            System.out.println(i);
    }

}
