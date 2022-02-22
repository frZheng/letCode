//import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.*;

import Tree.TreeNode;

// 没能写出来
public class constructBinaryTreeFromInorderAndPostorderTraversal {


    private static class Solution {

        public Solution() {
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int inorderLength = inorder.length;
            int postorderLength = postorder.length;
            if(inorderLength == 0 || postorderLength == 0)
                return null;
            int rootVal = postorder[postorderLength - 1];
            TreeNode root = new TreeNode(rootVal);
            int k = 0;
            for(int i = 0; i < inorderLength; i++)
                if(rootVal == inorder[i]){
                    k = i;
                    break;
                }
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, k);
            int[] leftPostorder = Arrays.copyOfRange(postorder, 0, k);
            root.left = buildTree(leftInorder, leftPostorder);

            int[] rightInoder = Arrays.copyOfRange(inorder, k + 1, inorderLength);
            int[] rightPostorder = Arrays.copyOfRange(postorder, k, postorderLength - 1);
            root.right = buildTree(rightInoder, rightPostorder);
            return root;
        }
    }



    public static void main(String Args[]) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(inorder, postorder);
        System.out.println(treeNode);


    }

}
