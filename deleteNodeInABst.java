//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import javax.print.attribute.standard.PresentationDirection;

public class  deleteNodeInABst {


    private static class Solution {

        public Solution() {
        }


        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;
            if (key < root.val){
                TreeNode leftNode = deleteNode(root.left, key);
                return leftNode;
            }
            else if (key > root.val) {
                TreeNode rightNode = deleteNode(root.right, key);
                return rightNode;
            } else {
                TreeNode left = root.left;
                TreeNode right = root.right;
                while (right != null && right.left != null){
                    right = right.left;
                }
                if (right != null){
                    right.left = left;
                    return root.right;
                } else {
                    return left;
                }
            }
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
        TreeNode treeNode5 = solution.deleteNode(treeNode, 1);
        System.out.println(treeNode5);


    }

}
