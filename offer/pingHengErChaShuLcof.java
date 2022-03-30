package offer;

// https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/


import Trees.Tree.TreeNode;

import java.util.*;


public class pingHengErChaShuLcof {
    private static class Solution {

        public Solution() {
        }
        public boolean isBalanced(TreeNode root) {
            if(root==null) return true;
            if(Math.abs(getHigh(root.left)-getHigh(root.right))<=1){
                return isBalanced(root.left)&&isBalanced(root.right);
            }
            return false;
        }
        private int getHigh(TreeNode root){
            if(root==null) return 0;
            return Math.max(getHigh(root.left),getHigh(root.right))+1;
        }
    }
    public static TreeNode array2Tree(String str) {
        String[] split = str.split(",");
        TreeNode[] treeNodes = new TreeNode[split.length];
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

        String str = "3,9,20,null,null,15,7";
        root = array2Tree(str);


        boolean lists = solution.isBalanced(root);
        System.out.println(lists);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
