package dp;

//web https://leetcode-cn.com/problems/partition-equal-subset-sum/
public class partitionEqualSubsetSum {
    private static class Solution {

        public Solution() {
        }

        public boolean canPartition(int[] nums) {
            int sum = 0;
            int len = nums.length;
            for (int i = 0; i < len; ++i) {
                sum += nums[i];
            }
//            System.out.println(sum);
            if ((sum & 0x01) == 1) return false;
            int target = sum >> 1;
            int[] dp = new int[target + 1];
            for (int i = 0; i < len; ++i) {
                for (int j = target; j >= nums[i]; --j) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            if (dp[target] == target) return true;
            return false;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {1,5,11,5};
        boolean fib = solution.canPartition(nums);
        System.out.println(fib);
    }
}
