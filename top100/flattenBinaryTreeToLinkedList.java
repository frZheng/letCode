package top100;

//web https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list


import Trees.Tree.TreeNode;

import java.util.*;

import static Trees.Tree.TreeNode.*;

public class  flattenBinaryTreeToLinkedList {
    private static class Solution {

        public Solution() {
        }

        public void flatten(TreeNode root) {
            TreeNode curr = root;
//            System.out.println();
//            preOrder(root);
//            System.out.println();
//            inOrder(root);
//            System.out.println("\n");

            while (curr != null) {
                preOrder(root);
                System.out.println();
                inOrder(root);
                System.out.println("\n");
                if (curr.left != null) {
                    TreeNode next = curr.left;
                    TreeNode predecessor = next;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                    predecessor.right = curr.right;
                    curr.left = null;
                    curr.right = next;
                }
                curr = curr.right;

            }
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        TreeNode root = String2Tree("1,2,5,3,4,null,6");
        solution.flatten(root);


    }
}
