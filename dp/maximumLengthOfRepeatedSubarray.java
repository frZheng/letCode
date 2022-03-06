package dp;

//web https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
public class  maximumLengthOfRepeatedSubarray {
    private static class Solution {

        public Solution() {
        }

        public int findLength(int[] nums1, int[] nums2) {
//            int result = 0;
//            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
//
//            for (int i = 1; i < nums1.length + 1; i++) {
//                for (int j = 1; j < nums2.length + 1; j++) {
//                    if (nums1[i - 1] == nums2[j - 1]) {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
//                        result = Math.max(result, dp[i][j]);
//                    }
//                }
//            }
//
//            return result;
            int[] dp = new int[nums2.length + 1];
            int result = 0;

            for (int i = 1; i <= nums1.length; i++) {
                for (int j = nums2.length; j > 0; j--) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        dp[j] = 0;
                    }
                    result = Math.max(result, dp[j]);
                }
            }
            return result;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        int fib = solution.findLength(nums1, nums2);
        System.out.println(fib);
    }
}
