package Trees;//import javax.swing.tree.TreeNode;

import Trees.Tree.TreeNode;

public class insertIntoABinarySearchTree {


    private static class Solution {

        public Solution() {
        }


        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null)
                return new TreeNode(val);
            if(root.val < val)
                root.right = insertIntoBST(root.right, val);
            else
                root.left = insertIntoBST(root.left, val);
            return root;
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
        TreeNode treeNode5 = solution.insertIntoBST(treeNode, 1);
        System.out.println(treeNode5);


    }

}
