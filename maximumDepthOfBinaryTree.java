//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

//import static java.lang.Math.max;


public class  maximumDepthOfBinaryTree {


    private static class Solution {

        public Solution() {
        }


        public int maxDepth(TreeNode root) {
//            if(root==null)
//                return 0;
//            return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
            return root==null? 0: 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
        int root = solution.maxDepth(treeNode);
        System.out.println(root);


    }

}
