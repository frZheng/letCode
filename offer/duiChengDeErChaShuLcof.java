package offer;

//web https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class duiChengDeErChaShuLcof {
    private static class Solution {

        public Solution() {
        }
        public boolean compare(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left != null && right == null || left == null && right != null) return false;
            if(left.val != right.val)
                return false;
            return compare(left.left, right.right) & compare(left.right, right.left);
        }
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return compare(root.left,root.right);
        }
    }
    public static TreeNode array2Tree(String str) {
        String[] split = str.split(",");
        TreeNode[] treeNodes = new TreeNode[split.length];
        System.out.println("len " + treeNodes.length);
        for (int i = 0; i < split.length; ++i) {
//            System.out.println(split[i]);
            if (split[i].equals("null"))
                treeNodes[i] = null;
            else
                treeNodes[i] = new TreeNode(Integer.valueOf(split[i]));
        }
        for (int i = 0; i < split.length/2; ++i) {
            treeNodes[i].left = treeNodes[i * 2 + 1];
            treeNodes[i].right = treeNodes[i * 2 + 2];
        }

        return treeNodes[0];
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        TreeNode root = null;

//        String str = "3,4,5,1,2,null,null";

        String str = "1,2,2,null,3,null,3";

        root = array2Tree(str);


        boolean lists = solution.isSymmetric(root);
        System.out.println(lists);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
