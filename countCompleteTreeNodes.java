//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;

public class countCompleteTreeNodes {


    private static class Solution {

        public Solution() {
        }


        public int countNodes(TreeNode root) {
//            if(root == null)
//                return 0;
//            int leftCount = countNodes(root.left);
//            int rightCount = countNodes(root.right);
//            return leftCount + rightCount + 1;
            return root == null? 0: 1 + countNodes(root.left) + countNodes(root.right);
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
        int res = solution.countNodes(treeNode);
        System.out.println(res);


    }

}
