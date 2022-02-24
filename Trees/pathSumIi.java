package Trees;//import javax.swing.tree.TreeNode;
import java.util.*;

import Trees.Tree.TreeNode;


// 没能写出来
public class pathSumIi {


    private static class Solution {

        public Solution() {
        }

        // 成员变量
//        List<List<Integer>> ans = new ArrayList<>();
//        public void helpher(TreeNode root, List<Integer>path, int sum, int targetSum) {
//            if(root == null)
//                return;
//            path.add(root.val);
//            if(root.left == null && root.right ==null){
//                if(sum + root.val == targetSum)
//                    ans.add(new ArrayList<>(path));
//            }
//            sum += root.val;
//            helpher(root.left, path, sum, targetSum);
//            helpher(root.right, path, sum, targetSum);
//            path.remove(path.size() - 1);
//        }
//        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//
//            helpher(root, new ArrayList<>(), 0, targetSum);
//            return ans;
//        }


        public void helpher(TreeNode root, List<Integer>path, int sum, int targetSum, List<List<Integer>> ans) {
            if(root == null)
                return;
            path.add(root.val);
            if(root.left == null && root.right ==null){
                if(sum + root.val == targetSum)
                    ans.add(new ArrayList<>(path));
            }
            sum += root.val;
            helpher(root.left, path, sum, targetSum, ans);
            helpher(root.right, path, sum, targetSum, ans);
            path.remove(path.size() - 1);
        }
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            helpher(root, new ArrayList<>(), 0, targetSum, ans);
            return ans;
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
        List<List<Integer>> lists = solution.pathSum(treeNode,5);
        System.out.println(lists);


    }

}
