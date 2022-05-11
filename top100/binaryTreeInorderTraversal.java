package top100;

//web https://leetcode.cn/problems/binary-tree-inorder-traversal


import Trees.Tree.TreeNode;

import java.util.*;

import static Trees.Tree.TreeNode.*;

public class  binaryTreeInorderTraversal {
    private static class Solution {

        public Solution() {
        }

        void inorder(TreeNode root, List<Integer> res) {
            if (root.left!=null) {
                inorder(root.left,res);
            }
            res.add(root.val);
            if (root.right!=null) {
                inorder(root.right,res);
            }
        }
        public List<Integer> inorderTraversal(TreeNode root) {

            ArrayList<Integer> res = new ArrayList<>();
            if (root != null)
                inorder(root,res);
            return res;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        TreeNode root = String2Tree("1,null,2,3");
        List<Integer> list = solution.inorderTraversal(root);
        for (int i : list){
            System.out.println(i);
        }
    }
}
