//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;


// 没能写出来
public class balancedBinaryTree {


    private static class Solution {

        public Solution() {
        }

        int getDepth(TreeNode root) {
            if(root == null)
                return 0;
            int leftDepth = getDepth(root.left);
            if(leftDepth == -1) return -1;
            int rightDepth = getDepth(root.right);
            if(rightDepth == -1) return -1;
            return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
        }
        public boolean isBalanced(TreeNode root) {
//            if(root == null)
//                return true;
//            if(getDepth(root) == -1)
//                return false;
//            else
//                return true;
            return getDepth(root) == -1 ? false : true;
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
        boolean res = solution.isBalanced(treeNode);
        System.out.println(res);


    }

}
