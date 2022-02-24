package Trees;//import javax.swing.tree.TreeNode;
import java.util.*;

import Trees.Tree.TreeNode;

public class findModeInBinarySearchTree {


    private static class Solution {

        public Solution() {
        }


        int preVal = 0, curTimes = 0, maxTimes = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        void traversal(TreeNode root){
            if(root == null) return;
            traversal(root.left);
            if(preVal == root.val)
                curTimes += 1;
            else {
                curTimes = 1;
                preVal = root.val;
            }
            if(maxTimes == curTimes){
                list.add(root.val);
            }else if(curTimes > maxTimes){
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }
            traversal(root.right);
        }
        public int[] findMode(TreeNode root) {
            traversal(root);
            int size = list.size();
            int[] ints = new int[size];
            for(int i = 0; i < size; ++i) {
                ints[i] = list.get(i);
            }
            return ints;
        }
    }



    public static void main(String Args[]) {
//        System.out.println("hello word");
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);


        treeNode.setLeft(treeNode1);
        treeNode.setRight(treeNode2);
        treeNode2.setLeft(treeNode3);
        treeNode2.setRight(treeNode4);

        Solution solution = new Solution();
        int[] mode = solution.findMode(treeNode);
        System.out.println(mode);


    }

}
