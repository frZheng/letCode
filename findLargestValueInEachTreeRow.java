//import javax.swing.tree.TreeNode;
import java.util.*;

import Tree.TreeNode;

public class findLargestValueInEachTreeRow {


    private static class Solution {

        public Solution() {
        }


        public List<Integer> largestValues(TreeNode root) {

            if (root == null)
                return new LinkedList<>();

            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);

            while (!que.isEmpty()) {
                int size = que.size();
                ArrayList<Integer> list = new ArrayList<>();
                int maxVal = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = que.poll();
                    if(maxVal<poll.val) maxVal = poll.val;
//                    list.add(poll.val);
                    if (poll.left != null)
                        que.add(poll.left);
                    if (poll.right != null)
                        que.add(poll.right);

                }
                res.add(maxVal);
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
        List<Integer> lists = solution.largestValues(treeNode);
        System.out.println(lists);


    }

}
