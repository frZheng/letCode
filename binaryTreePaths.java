//import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.*;

import Tree.TreeNode;

// 没能写出来
public class binaryTreePaths {


    private static class Solution {

        public Solution() {
        }

        void solve(TreeNode root, String cur, List<String> ret){
            if(root == null) return;

            cur += root.val;
            if(root.left == null && root.right == null)
                ret.add(cur);
            else{
                solve(root.left, cur + "->", ret);
                solve(root.right, cur + "->", ret);
            }
        }

        public List<String> binaryTreePaths(TreeNode root) {
            ArrayList<String> result = new ArrayList<>();
            if (root == null)
                return result;
            solve(root, "", result);
            return result;
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
        List<String> strings = solution.binaryTreePaths(treeNode);
        System.out.println(strings);


    }

}
