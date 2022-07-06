package top100;

//web https://leetcode.cn/problems/diameter-of-binary-tree


import Trees.Tree.TreeNode;

import java.util.*;

import static Trees.Tree.TreeNode.*;

public class  diameterOfBinaryTree {
    private static class Solution {

        public Solution() {
        }

        int diameter=0;
        int getDepth(TreeNode root) {
            if (root==null)
                return 0;
            int left = 0, right = 0;
            if (root.left != null)
                left = getDepth(root.left);
            if (root.right != null)
                right = getDepth(root.right);
            diameter = Math.max(diameter,left+right);
            return Math.max(left,right)+1;
        }
        public int diameterOfBinaryTree(TreeNode root) {
            getDepth(root);
            return diameter;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        TreeNode root = String2Tree("-10,9,20,null,null,15,7");
//        TreeNode.inOrder(root);
        int list = solution.diameterOfBinaryTree(root);
        System.out.println(list);
    }
}
