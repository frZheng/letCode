package offer;

//web https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof


import Trees.Tree.TreeNode;

import java.util.*;


public class erChaSouSuoShuYuShuangXiangLianBiaoLcof {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    private static class Solution {

        public Solution() {
        }

        public Node treeToDoublyList(Node root) {
            return root;
        }
    }
//    public static TreeNode array2Tree(String str) {
//        String[] split = str.split(",");
//
//
//        TreeNode[] treeNodes = new TreeNode[split.length];
//        System.out.println(split.length);
//        for (int i = 0; i < split.length; ++i) {
////            System.out.println(split[i]);
//            if (split[i].equals("null"))
//                treeNodes[i] = null;
//            else
//                treeNodes[i] = new TreeNode(Integer.valueOf(split[i]));
//        }
//        for (int i = 0; i < split.length/2; ++i) {
//            if (treeNodes[i]!=null) {
//                treeNodes[i].left = treeNodes[i * 2 + 1];
//                treeNodes[i].right = treeNodes[i * 2 + 2];
//            }
//        }
//
//        return treeNodes[0];
//    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        Node root = null;

//        String str = "3,4,5,1,2,null,null";

//        String str = "5,4,8,11,null,13,4,7,2,null,null,null,null,5,1";
//        root = array2Tree(str);


        Node lists = solution.treeToDoublyList(root);
//        for (List i : lists) {
//            System.out.println("result: ");
//            for (Object j : i) {
//                System.out.println(j);
//            }
//        }

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
