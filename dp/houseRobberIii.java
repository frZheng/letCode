package dp;

import Trees.Tree.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//web https://leetcode-cn.com/problems/house-robber-iii
public class houseRobberIii {
    private static class Solution {

        public Solution() {
        }
        int[] dfs(TreeNode root){
            if(root == null) return new int[]{0,0};
            int[] cur = new int[2];
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            cur[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            cur[1] = root.val + left[0] + right[0];
            return cur;
        }
        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }
    }
    public static void main(String Args[]) {

        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(1);


        treeNode.setLeft(treeNode1);
        treeNode.setRight(treeNode2);
//        treeNode1.setLeft(treeNode3);
        treeNode1.setRight(treeNode3);

        Solution solution = new Solution();
//        int[] nums = {2,1,1,2};
        int fib = solution.rob(treeNode);
        System.out.println(fib);
    }
}
