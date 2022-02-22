//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

// 没能写出来
public class  minimumAbsoluteDifferenceInBst {


    private static class Solution {

        public Solution() {
        }

        int res = Integer.MAX_VALUE;
        int preVal = -1;
        void inorder(TreeNode root) {
            if(root == null)
                return;
            inorder(root.left);

            if(preVal < 0) {
                preVal = root.val;
            }
            else {
                int tmp = Math.abs(root.val - preVal);
                res = Math.min(tmp, res);
                preVal = root.val;
            }


            inorder(root.right);
        }
        public int getMinimumDifference(TreeNode root) {

            inorder(root);
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
        int res = solution.getMinimumDifference(treeNode);
        System.out.println(res);


    }

}
