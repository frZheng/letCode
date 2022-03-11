package offer;

//web https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class shuDeZiJieGouLcof {
    private static class Solution {

        public Solution() {
        }
        public boolean compare(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null) return false;
            return A.val == B.val && compare(A.left, B.left) && compare(A.right, B.right);
        }
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            return compare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
//        public boolean isSubStructure(TreeNode A, TreeNode B) {
//            if (A == null && B == null) return true;
//            if (A != null && B != null) {
//                if (A.val == B.val) {
//                    boolean leftRes = isSubStructure(A.left, B);
//                    boolean rightRes = isSubStructure(A.right, B);
//                    if (leftRes | rightRes) return true;
//
//                    if (B.left != null && B.right != null)
//                        return isSubStructure(A.left, B.left) & isSubStructure(A.right, B.right);
//                    if (B.left != null && B.right == null)
//                        return isSubStructure(A.left, B.left);
//                    if (B.left == null && B.right != null)
//                        return isSubStructure(A.right, B.right);
//                    return true;
//                }
//            }
//            else
//                return false;
//            boolean leftRes = isSubStructure(A.left, B);
//            boolean rightRes = isSubStructure(A.right, B);
//
//            return leftRes | rightRes;
//        }
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

        String str = "1,0,1,-4,-3,null,null";
        root = array2Tree(str);
//        String str2 = "4,1,null";
        String str2 = "1,-4,null";
        TreeNode subRoot = array2Tree(str2);

        boolean lists = solution.isSubStructure(root,subRoot);
        System.out.println(lists);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
