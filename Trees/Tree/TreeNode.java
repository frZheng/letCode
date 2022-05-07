package Trees.Tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static TreeNode String2Tree(String str) {
        String[] split = str.split(",");
        TreeNode[] treeNodes = new TreeNode[split.length];
        System.out.println(split.length);
        for (int i = 0; i < split.length; ++i) {
//            System.out.println(split[i]);
            if (split[i].equals("null"))
                treeNodes[i] = null;
            else
                treeNodes[i] = new TreeNode(Integer.valueOf(split[i]));
        }
        for (int i = 0; i < split.length/2; ++i) {
            if (treeNodes[i]!=null) {
                treeNodes[i].left = treeNodes[i * 2 + 1];
                treeNodes[i].right = treeNodes[i * 2 + 2];
            }
        }

        return treeNodes[0];
    }
    public static void preOrder(TreeNode root) {
        System.out.print(root.val + ",");
        if (root.left != null)
            preOrder(root.left);
        if (root.right != null)
            preOrder(root.right);
    }
    public static void inOrder(TreeNode root) {
        if (root.left != null)
            preOrder(root.left);
        System.out.print(root.val + ",");
        if (root.right != null)
            preOrder(root.right);
    }
    public static void posOrder(TreeNode root) {
        if (root.left != null)
            preOrder(root.left);
        if (root.right != null)
            preOrder(root.right);
        System.out.print(root.val + ",");
    }
}
