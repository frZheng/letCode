//import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.*;

import Tree.TreeNode;

// 没能写出来
public class  maximumBinaryTree {


    private static class Solution {

        public Solution() {
        }

        int findMax(int[] nums, int left, int right){
            int max = Integer.MIN_VALUE, maxIndex = 1;
            for(int i = left; i <= right; i++){
                if(max < nums[i]){
                    max = nums[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

        TreeNode maxTree(int[] nums, int left, int right){
            if(left > right)
                return null;
            int maxIndex = findMax(nums, left, right);
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = maxTree(nums, left, maxIndex - 1);
            root.right = maxTree(nums, maxIndex + 1, right);
            return root;
        }
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return maxTree(nums, 0, nums.length - 1);
        }
    }


    public static void main(String Args[]) {
        int[] nums = {9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
        System.out.println(treeNode);


    }

}
