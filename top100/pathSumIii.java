package top100;

//web https://leetcode.cn/problems/path-sum-iii/


import Trees.Tree.TreeNode;

import java.util.*;

import static Trees.Tree.TreeNode.*;

public class  pathSumIii {
    private static class Solution {

        public Solution() {
        }

        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> prefix = new HashMap<>();
            prefix.put(0L, 1);
            return dfs(root, prefix, 0, targetSum);
        }
        public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
            if (root == null) {
                return 0;
            }

            int ret;
            curr += root.val;

            ret = prefix.getOrDefault(curr - targetSum, 0);
            prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
            ret += dfs(root.left, prefix, curr, targetSum);
            ret += dfs(root.right, prefix, curr, targetSum);
            // 上面填入后这里再减,但是可以在中间会还有修改
            prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

            return ret;
        }
    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        TreeNode root = String2Tree("10,5,-3,3,2,null,11,3,-2,null,1");
//        TreeNode.inOrder(root);
        int list = solution.pathSum(root,8);
        System.out.println(list);
    }
}
