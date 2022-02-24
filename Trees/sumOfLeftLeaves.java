package Trees;//import javax.swing.tree.TreeNode;

import Trees.Tree.TreeNode;

public class sumOfLeftLeaves {


    private static class Solution {

        public Solution() {
        }


        public int sumOfLeftLeaves(TreeNode root) {

            if (root == null)
                return 0;
//            int lefVal = sumOfLeftLeaves(root.left);
//            int rightVal = sumOfLeftLeaves(root.right);
//            int midVal = 0;
//            if(root.left != null && root.left.left == null && root.left.right == null)
//                midVal = root.left.val;
//            return midVal + lefVal + rightVal;
            int midVal = 0;
            if(root.left != null && root.left.left == null && root.left.right == null)
                midVal = root.left.val;
            return midVal + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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
        int res = solution.sumOfLeftLeaves(treeNode);
        System.out.println(res);


    }

}
