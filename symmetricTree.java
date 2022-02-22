//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

public class  symmetricTree {


    private static class Solution {

        public Solution() {
        }

        boolean isMirror(TreeNode left, TreeNode right) {
            if (left == null && right==null)
                return true;
            if (left == null || right == null || left.val != right.val)
                return false;
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        public boolean isSymmetric(TreeNode root) {
            if(root==null)
                return true;
            return isMirror(root.left, root.right);
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
        boolean root = solution.isSymmetric(treeNode);
        System.out.println(root);


    }

}
