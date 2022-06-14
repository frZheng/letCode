package top100;

//web https://leetcode.cn/problems/burst-balloons


import list.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class  burstBalloons {
    private static class Solution {

        public Solution() {
        }

        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n + 2][n + 2];
            int[] val = new int[n + 2];
            val[0] = val[n + 1] = 1;

//            for (int i = 1; i <= n; i++) {
//                val[i] = nums[i - 1];
//            }
            System.arraycopy(nums, 0, val, 1, n);

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 2; j <= n + 1; j++) {
                    for (int k = i + 1; k < j; k++) {
                        int sum = val[i] * val[k] * val[j];
                        sum += dp[i][k] + dp[k][j];
                        dp[i][j] = Math.max(dp[i][j], sum);
                    }
                }
            }
            return dp[0][n + 1];
        }

    }



    public static void main(String Args[]) {
        Solution solution = new Solution();


        int res = solution.maxCoins(new int[] {3,1,5,8});
        System.out.println(res);
    }

}
