package offer;

//web https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class erChaShuDeShenDuLcof {
    private static class Solution {

        public Solution() {
        }
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            Queue<TreeNode> que= new LinkedList<>();

            int depth = 0;
            que.add(root);
            while (!que.isEmpty()) {
                int size = que.size();

                for (int i = 0; i < size; ++i) {
                    TreeNode poll = que.poll();
                    if (poll.left != null) que.add(poll.left);
                    if (poll.right != null) que.add(poll.right);
                }
                depth++;
            }
            return depth;
        }
    }
    public static TreeNode array2Tree(String str) {
        String[] split = str.split(",");
        TreeNode[] treeNodes = new TreeNode[split.length];
        for (int i = 0; i < split.length; ++i) {
//            System.out.println(split[i]);
            if (split[i].equals("null"))
                treeNodes[i] = null;
            else
                treeNodes[i] = new TreeNode(Integer.valueOf(split[i]));
        }
        for (int i = 0; i < split.length/2; ++i) {
            treeNodes[i].left = treeNodes[i * 2 + 1];
            treeNodes[i].right = treeNodes[i * 2 + 2];
        }

        return treeNodes[0];
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        TreeNode root = null;

//        String str = "3,4,5,1,2,null,null";

        String str = "3,9,20,null,null,15,7";
        root = array2Tree(str);


        int lists = solution.maxDepth(root);
        System.out.println(lists);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
