package offer;

//web https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class erChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    private static class Solution {

        public Solution() {
        }

        private List<List<Integer>> res;
        // 二叉树中和为某一值的路径
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            res = new ArrayList<>();
            backtrack(root, target, new ArrayList<>());
            return res;
        }

        private void backtrack(TreeNode node, int target, List<Integer> collector) {
            if (node == null) {
                return;
            }
            collector.add(node.val);
            target -= node.val;
            if (target == 0 && node.left == null && node.right == null) {
                res.add(new ArrayList<>(collector));
            } else {
                backtrack(node.left, target, collector);
                backtrack(node.right, target, collector);
            }
            collector.remove(collector.size() - 1); //这句相当于LinkedList.removeLast
        }
    }
    public static TreeNode array2Tree(String str) {
        String[] split = str.split(",");
        TreeNode[] treeNodes = new TreeNode[split.length];
        System.out.println(split.length);
        for (int i = 0; i < split.length; ++i) {
//            System.out.println(split[i]);
            if (split[i].equals("null"))
                treeNodes[i] = null;
            else
                treeNodes[i] = new TreeNode(Integer.valueOf(split[i]));
        }
        for (int i = 0; i < split.length/2; ++i) {
            if (treeNodes[i]!=null) {
                treeNodes[i].left = treeNodes[i * 2 + 1];
                treeNodes[i].right = treeNodes[i * 2 + 2];
            }
        }

        return treeNodes[0];
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        TreeNode root = null;

//        String str = "3,4,5,1,2,null,null";

        String str = "5,4,8,11,null,13,4,7,2,null,null,null,null,5,1";
        root = array2Tree(str);


        List<List<Integer>> lists = solution.pathSum(root, 22);
        for (List i : lists) {
            System.out.println("result: ");
            for (Object j : i) {
                System.out.println(j);
            }
        }

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
