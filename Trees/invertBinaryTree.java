package Trees;//import javax.swing.tree.TreeNode;

import Trees.Tree.TreeNode;

// 没能写出来
public class  invertBinaryTree {


    private static class Solution {

        public Solution() {
        }

        public TreeNode invertTree(TreeNode root) {
            if(root==null)
                return root;
            TreeNode treeNode = new TreeNode();
            treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
            invertTree(root.left);
            invertTree(root.right);
            return root;
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
        TreeNode root = solution.invertTree(treeNode);
        System.out.println(root);


    }

}
