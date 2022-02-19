//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;

public class averageOfLevelsInBinaryTree {


    private static class Solution {

        public Solution() {
        }


        public List<Double> averageOfLevels(TreeNode root) {

            if (root == null)
                return new LinkedList<>();

            LinkedList<Double> res = new LinkedList<>();
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);

            while (!que.isEmpty()) {
                int size = que.size();
                Double sum = 0.;
                for (int i = 0; i < size; i++) {

                    TreeNode poll = que.poll();
                    sum += poll.val;

                    if (poll.left != null)
                        que.add(poll.left);

                    if (poll.right != null)
                        que.add(poll.right);

                }
                res.add(sum /= size);
            }

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
        List<Double> lists = solution.averageOfLevels(treeNode);
        System.out.println(lists);


    }

}
