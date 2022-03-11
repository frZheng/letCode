package offer;

//web https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class erChaShuDeJingXiangLcof {
    private static class Solution {

        public Solution() {
        }
        public TreeNode mirrorTree(TreeNode root) {
            if (root==null) return null;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(root.left);
            return root;
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

        String str = "4,2,7,1,3,6,9";
        root = array2Tree(str);


        TreeNode lists = solution.mirrorTree(root);


//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
