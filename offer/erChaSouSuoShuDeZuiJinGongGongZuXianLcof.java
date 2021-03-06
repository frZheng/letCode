package offer;

//web https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class erChaSouSuoShuDeZuiJinGongGongZuXianLcof {
    private static class Solution {

        public Solution() {
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                // p q 一个在左，一个在右
                return root;
            }
            if (left != null) {
                // p q 都在左子树
                return left;
            }
            if (right != null) {
                // p q 都在右子树
                return right;
            }
            return null;
        }
    }

    public static TreeNode[] array2Tree(String str,int p, int q) {
        String[] split = str.split(",");
        TreeNode[] returns = new TreeNode[3];
        TreeNode[] treeNodes = new TreeNode[split.length];
        for (int i = 0; i < split.length; ++i) {
//            System.out.println(split[i]);
            if (split[i].equals("null"))
                treeNodes[i] = null;
            else {
                Integer integer = Integer.valueOf(split[i]);

                treeNodes[i] = new TreeNode(integer);

                if (integer == p)
                    returns[1] = treeNodes[i];
                if (integer == q)
                    returns[2] = treeNodes[i];
            }

        }
        for (int i = 0; i < split.length/2; ++i) {
            treeNodes[i].left = treeNodes[i * 2 + 1];
            treeNodes[i].right = treeNodes[i * 2 + 2];
        }
        returns[0] = treeNodes[0];
        return returns;
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        TreeNode root = null;

//        String str = "3,4,5,1,2,null,null";

        String str = "3,5,1,6,2,0,8,null,null,7,4";
        TreeNode[] roots = array2Tree(str, 5, 1);
        root = roots[0];
        TreeNode p = roots[1];
        TreeNode q = roots[2];


        TreeNode lists = solution.lowestCommonAncestor(root,p,q);
        System.out.println(lists.val);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }

}
