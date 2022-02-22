//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;

// 没能写出来
public class minimumDepthOfBinaryTree {


    private static class Solution {

        public Solution() {
        }


        public int minDepth(TreeNode root) {
            if(root == null)
                return 0;
            if(root.left != null && root.right == null)
                return 1 + minDepth(root.left);
            if(root.left == null && root.right != null)
                return 1 + minDepth(root.right);

            return 1 + Math.min(minDepth(root.left),minDepth(root.right));
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
        int res = solution.minDepth(treeNode);
        System.out.println(res);


    }

}
