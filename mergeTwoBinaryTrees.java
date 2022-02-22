//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;

// 简单题都不会!!!
public class mergeTwoBinaryTrees {


    private static class Solution {

        public Solution() {
        }


        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1 == null)
                return root2;
            if(root2 == null)
                return root1;
            root1.val += root2.val;

            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);

            return root1;
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
        TreeNode res = solution.mergeTrees(treeNode,treeNode);
        System.out.println(res);


    }

}
