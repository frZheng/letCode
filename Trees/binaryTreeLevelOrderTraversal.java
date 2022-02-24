package Trees;//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Trees.Tree.TreeNode;

public class binaryTreeLevelOrderTraversal {


    private static class Solution {

        public Solution() {
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
//            System.out.println("hello word");
            if(root == null)
                return new ArrayList<>();

            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);

            while(!que.isEmpty()) {
                int size = que.size();
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    TreeNode poll = que.poll();
                    list.add(poll.val);
                    if(poll.left != null )
                        que.add(poll.left);
                    if(poll.right != null)
                        que.add(poll.right);

                }

//                while(size > 0){
//                    TreeNode poll = que.poll();
//                    list.add(poll.val);
//                    if(poll.left != null )
//                        que.add(poll.left);
//                    if(poll.right != null)
//                        que.add(poll.right);
//                    size--;
//                }
                res.add(list);
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
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        System.out.println(lists);


    }

}
