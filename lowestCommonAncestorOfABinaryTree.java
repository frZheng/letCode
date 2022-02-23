//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;

public class lowestCommonAncestorOfABinaryTree {


    private static class Solution {

        public Solution() {
        }


        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null)
                return root;
            if(root == p || root == q)
                return root;
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
            if(leftNode != null && rightNode != null)
                return root;
            else if (leftNode != null)
                return leftNode;
            else if (rightNode != null)
                return rightNode;
            return null;
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
        TreeNode treeNode5 = solution.lowestCommonAncestor(treeNode, treeNode4, treeNode2);
        System.out.println(treeNode5);


    }

}
