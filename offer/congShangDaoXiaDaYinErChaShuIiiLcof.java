package offer;

 //web https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class congShangDaoXiaDaYinErChaShuIiiLcof {
    private static class Solution {

        public Solution() {
        }
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            int level = 0;
            while (!que.isEmpty()){
                int size = que.size();
                ArrayList<Integer> levelRes = new ArrayList<Integer>();
                for (int i = 0; i < size; ++i) {
                    TreeNode node = que.poll();
                    levelRes.add(node.val);
                    if (node.left != null)
                        que.add(node.left);
                    if (node.right != null)
                        que.add(node.right);
                }
                if ((level & 0x01) == 0x01)
                    Collections.reverse(levelRes);
                res.add(levelRes);
                level++;
            }
            return res;
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
        List<List<Integer>> lists = solution.levelOrder(root);
        for (int i = 0; i < lists.size(); ++i) {
            List<Integer> integers = lists.get(i);
            for (int j = 0; j < integers.size(); ++j) {
                System.out.println(i + ", " + j + ": " + integers.get(j));
            }
        }

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }
		
}
