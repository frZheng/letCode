package Trees;//import javax.swing.tree.TreeNode;

import Trees.Tree.TreeNode;

// 没能写出来
public class  validateBinarySearchTree {


    private static class Solution {

        public Solution() {
        }

        boolean validation(TreeNode root, long min, long max){
            if(root == null)
                return true;
            if(root.val <= min || root.val >= max){
                return false;
            }
            return validation(root.left, min, root.val) && validation(root.right, root.val, max);
        }
        public boolean isValidBST(TreeNode root) {
            return validation(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }

    public static void main(String Args[]) {
//        System.out.println("hello word");
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);


        treeNode.setLeft(treeNode1);
        treeNode.setRight(treeNode2);
        treeNode2.setLeft(treeNode3);
        treeNode2.setRight(treeNode4);

        Solution solution = new Solution();
        boolean root = solution.isValidBST(treeNode);
        System.out.println(root);


    }

}
