//import javax.swing.tree.Node;
import java.util.*;

import Tree.Node;

public class  maximumDepthOfNAryTree {


    private static class Solution {

        public Solution() {
        }


        public int maxDepth(Node root) {
            if(root == null)
                return 0;
            if(root.children==null)
                return 1 + 0;

            int maxDeep = 0;

            for(int i = 0; i < root.children.size(); i++) {
                int deep = maxDepth(root.children.get(i));
                maxDeep = Math.max(maxDeep,deep);
            }
            return 1 + maxDeep;
        }


    }



    public static void main(String Args[]) {
//        System.out.println("hello word");
        Node Node = new Node(1);
        Node Node1 = new Node(3);
        Node Node2 = new Node(2);
        Node Node3 = new Node(4);
        Node Node4 = new Node(5);
        Node Node5 = new Node(6);

        ArrayList<Node> nodes2 = new ArrayList<Node>();
        nodes2.add(Node4);
        nodes2.add(Node5);
        Node1.setChildren(nodes2);

        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(Node1);
        nodes.add(Node2);
        nodes.add(Node3);
        Node.setChildren(nodes);

        Solution solution = new Solution();
        int res = solution.maxDepth(Node);
        System.out.println(res);


    }

}
