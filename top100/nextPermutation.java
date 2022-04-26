package top100;

//web https://leetcode-cn.com/problems/next-permutation




public class nextPermutation {
    private static class Solution {

        public Solution() {
        }
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }


    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] nums = {1,2,3};
        solution.nextPermutation(nums);
        for (int i : nums)
            System.out.println(i);
        }
}
