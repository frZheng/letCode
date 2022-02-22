//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;

public class searchInABinarySearchTree {


    private static class Solution {

        public Solution() {
        }


        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null)
                return null;
            if(root.val > val)
                return searchBST(root.left, val);
            if(root.val < val)
                return searchBST(root.right, val);
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
        TreeNode lists = solution.searchBST(treeNode, 1);
        System.out.println(lists);


    }

}
