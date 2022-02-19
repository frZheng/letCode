//import javax.swing.tree.Node;
import java.util.*;

import Tree.Node;

public class nAryTreeLevelOrderTraversal {


    private static class Solution {

        public Solution() {
        }


        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;


            Queue<Node> que = new LinkedList<>();
            que.add(root);

            while (!que.isEmpty()) {
                int size = que.size();
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node poll = que.poll();
                    list.add(poll.val);

                    List<Node> children = poll.children;
                    if(children==null)continue;
                    for(int j = 0; j < children.size(); j++) {
                        Node node = children.get(j);
                        if(node != null)
                            que.add(node);

                    }
                }
                res.add(list);
            }
            return res;
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
        List<List<Integer>> lists = solution.levelOrder(Node);
        System.out.println(lists);


    }

}
