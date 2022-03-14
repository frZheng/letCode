package offer;

//web https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class erChaSouSuoShuDeDiKdaJieDianLcof {
    private static class Solution {

        public Solution() {
        }
//        int curNum = 0;
//        int kNum = 0;
        ArrayList<Integer> inorderRes;
        public void inorder(TreeNode root, int k) {
//            if(root==null) return;
            if(root.left != null)
                inorder(root.left, k);
            inorderRes.add(root.val);
//            System.out.println(root.val);
//            curNum++;
//            if(curNum == k)
//                kNum = root.val;
            if(root.right != null)
                inorder(root.right, k);


        }
        public int kthLargest(TreeNode root, int k) {
            if (root == null) return 0;
            inorderRes = new ArrayList<Integer>();

            inorder(root, k);
            if (k > inorderRes.size()) return inorderRes.get(inorderRes.size() - 1);;
            return inorderRes.get(inorderRes.size() - k);
//            for (int i = 0; i < inorderRes.size(); ++i) {
//                System.out.println(inorderRes.get(i));
//            }
//            return 0;
//            return kNum;
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

        String str = "3,1,4,null,2";
        root = array2Tree(str);


        int res = solution.kthLargest(root, 1);
        System.out.println(res);


//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
