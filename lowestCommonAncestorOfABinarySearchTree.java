//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;

import javax.print.attribute.standard.PresentationDirection;

public class lowestCommonAncestorOfABinarySearchTree {


    private static class Solution {

        public Solution() {
        }

        TreeNode res;
        void inorder(TreeNode root, TreeNode p, TreeNode q){
            if ((root.val - p.val) * (root.val - q.val) <= 0)
                res = root;
            else if (root.val < p.val && root.val < q.val)
                inorder(root.right, p, q);
            else
                inorder(root.left, p, q);
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            inorder(root, p, q);
            return res;
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
