package offer;

//web https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/comments


import Trees.Tree.TreeNode;

import java.util.*;


public class Comments {
    private static class Solution {

        public Solution() {
        }
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "null,";
            String res =  root.val + ",";
            res += serialize(root.left);
            res += serialize(root.right);
            return res;
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            Queue<String> queue = new LinkedList<String>();
            for(int i = 0; i < arr.length; i++){
                queue.offer(arr[i]);
            }
            return help(queue);
        }
        public TreeNode help(Queue<String> queue){
            String val = queue.poll();
            if(val.equals("null")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = help(queue);
            root.right = help(queue);
            return root;
        }
        public boolean cmp(TreeNode root1, TreeNode root2){
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;
            return cmp(root1.left, root2.left) && cmp(root1.right, root2.right) && root1.val==root2.val;
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

        String str = "4,2,7,1,3,6,9";
        root = array2Tree(str);


        String lists = solution.serialize(root);
        TreeNode root2 = solution.deserialize(lists);
        System.out.println(solution.cmp(root, root2));

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
