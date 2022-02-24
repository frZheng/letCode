package Trees;//import javax.swing.tree.TreeNode;

import Trees.Tree.TreeNode;

public class  deleteNodeInABst {


    private static class Solution {

        public Solution() {
        }


        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;
            if (key < root.val){
                root.left = deleteNode(root.left, key);
            }
            else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                TreeNode left = root.left;
                TreeNode right = root.right;
                while (right != null && right.left != null){
                    right = right.left;
                }
                if (right != null){
                    right.left = left;
                    return root.right;
                } else {
                    return left;
                }
            }
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
        TreeNode treeNode5 = solution.deleteNode(treeNode, 1);
        System.out.println(treeNode5);


    }

}