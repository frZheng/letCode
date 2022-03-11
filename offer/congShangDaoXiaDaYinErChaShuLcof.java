package offer;

//web https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof


import Trees.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class congShangDaoXiaDaYinErChaShuLcof {
    private static class Solution {

        public Solution() {
        }
        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[]{};
            ArrayList<Integer> res = new ArrayList<Integer>();

            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            TreeNode node = null;
            int size = 0;
            while (!que.isEmpty()){
                size = que.size();
                for (int i = 0; i < size; ++i) {
                    node = que.poll();
//                    System.out.println(node.val);
                    res.add(node.val);
                    if (node.left != null)
                        que.add(node.left);
                    if (node.right != null)
                        que.add(node.right);
                }
            }
            int[] ans = new int[res.size()];
            for (int i = 0 ;i < res.size(); ++i)
                ans[i] = res.get(i);

            return ans;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        TreeNode root = null;
        String str = "3,9,20,null,null,15,7";
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
        root = treeNodes[0];
//        System.out.println(root.val);
//        System.out.println(root.left.val);
//        System.out.println(root.right.right.val);
//        System.out.println(root.left.left.val);
        int[] ints = solution.levelOrder(root);
        System.out.println("result");
        for (int i : ints)
            System.out.println(i);
    }
		
}
