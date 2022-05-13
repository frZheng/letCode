package top100;

//web  https://leetcode.cn/problems/maximum-product-subarray


import Trees.Tree.TreeNode;
import list.ListNode;

import java.util.*;

import static Trees.Tree.TreeNode.*;

public class  maximumProductSubarray {
    private static class Solution {

        public Solution() {
        }

        public int maxProduct(int[] nums) {
            int maxF = nums[0], minF = nums[0], ans = nums[0];
            int length = nums.length;
            for (int i = 1; i < length; ++i) {
                int mx = maxF, mn = minF;
                maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
                minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
                ans = Math.max(maxF, ans);
            }
            return ans;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int i = solution.maxProduct(new int[]{2,3,-2,4});
        System.out.println(i);

    }
}
