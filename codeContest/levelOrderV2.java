package codeContest;


import Trees.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static Trees.Tree.TreeNode.String2Tree;

// 题目要求
public class levelOrderV2 {


    public static String levelOrder(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                res.append(node.val);
                res.append(",");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        TreeNode root = String2Tree("3,9,20,null,null,15,7");
        String s = levelOrder(root);
        System.out.println(s);
//        Scanner sc = new Scanner(System.in);
//        String next = sc.nextLine();
//        String[] s = next.split(",");
//        int size = s.length;
//        StringBuilder msg = new StringBuilder();
//
//        for (int i = 0; i < size; ++i){
////            System.out.println(s[size - 1 - i]);
//            msg.append(s[size - 1 - i]);
//            if (i < size - 1)
//                msg.append(" ");
//        }
//        System.out.print(msg.toString());
    }
}
