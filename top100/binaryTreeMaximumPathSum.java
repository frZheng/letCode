package top100;

//web https://leetcode.cn/problems/binary-tree-maximum-path-sum


import Trees.Tree.TreeNode;

import java.util.*;

import static Trees.Tree.TreeNode.*;

public class  binaryTreeMaximumPathSum {
    private static class Solution {

        public Solution() {
        }

        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);

            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            int priceNewpath = node.val + leftGain + rightGain;

            // 更新答案
            maxSum = Math.max(maxSum, priceNewpath);

            // 返回节点的最大贡献值
            return node.val + Math.max(leftGain, rightGain);
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        TreeNode root = String2Tree("-10,9,20,null,null,15,7");
//        TreeNode.inOrder(root);
        int list = solution.maxPathSum(root);
        System.out.println(list);
    }
}
