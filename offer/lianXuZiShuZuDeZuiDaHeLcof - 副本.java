package offer;

 //web https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof

public class lianXuZiShuZuDeZuiDaHeLcof {
    private static class Solution {

        public Solution() {
        }


        public int maxSubArray(int[] nums) {
            int[] dp = new int[2];
            int max = nums[0];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                dp[1] = Math.max(dp[0] + nums[i], nums[i]);
                dp[0] = dp[1];
                max = Math.max(max, dp[1]);
            }
            return max;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] price = {1,2};
        int lists = solution.maxSubArray(price);
        System.out.println(lists);

    }

}
