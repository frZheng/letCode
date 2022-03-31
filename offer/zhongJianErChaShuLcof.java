package offer;

  //web https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof


import Trees.Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;


public class  zhongJianErChaShuLcof {
    private static class Solution {

        public Solution() {
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            if (n == 0)
                return null;
            int rootVal = preorder[0], rootIndex = 0;
            for (int i = 0; i < n; i++) {
                if (inorder[i] == rootVal) {
                    rootIndex = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
            root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(inorder, rootIndex + 1, n));

            return root;
        }
    }
    public static void inorder(TreeNode root){
        if(root.left != null)
            inorder(root.left);
        System.out.println(root.val);
        if(root.right != null)
            inorder(root.right);
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = solution.buildTree(preorder,inorder);
        System.out.println("inordr");
        inorder(root);
//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
