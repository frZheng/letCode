package codeContest;

import Trees.Tree.TreeNode;

import static Trees.Tree.TreeNode.String2Tree;

// 题目要求
public class postOrderBTree {
    private static class Solution {
        public String postOrder(TreeNode root){
            return postOrder(root,"");
        }
        public String postOrder(TreeNode root, String res){
            if (root.right != null)
                res += postOrder(root.right, res);
            if (root.left != null)
                res += postOrder(root.left, res);
            res += root.val;
            return res;
        }
    }
    public static void main(String[] Args) {

        Solution solution = new Solution();
        TreeNode root = String2Tree("3,9,20,null,null,15,7");
        String res = solution.postOrder(root);
        System.out.println(res);

    }
}
