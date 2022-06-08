package top100;

//web https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/


import Trees.Tree.TreeNode;

import java.util.*;

import static Trees.Tree.TreeNode.*;

public class  serializeAndDeserializeBinaryTree {
    private static class Codec {

        public Codec() {
        }
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return rserialize(root, "");
        }
        public String rserialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += String.valueOf(root.val) + ",";
                str = rserialize(root.left, str);
                str = rserialize(root.right, str);
            }
            return str;
        }

        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
            return rdeserialize(dataList);
        }

        public TreeNode rdeserialize(List<String> dataList) {
            if (dataList.get(0).equals("None")) {
                dataList.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
            dataList.remove(0);
            root.left = rdeserialize(dataList);
            root.right = rdeserialize(dataList);

            return root;
        }

    }


    public static void main(String[] Args) {
        Codec codec = new Codec();
        String data = "1,2,3,null,null,4,5";

        TreeNode root = String2Tree(data);
//        TreeNode.inOrder(root);
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize("1,2,3,None,None,4,5");
        TreeNode.inOrder(deserialize);

    }
}
