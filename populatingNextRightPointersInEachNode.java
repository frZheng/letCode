
import java.util.*;


import perfectTree.Node;

public class populatingNextRightPointersInEachNode {


    private static class Solution {

        public Solution() {
        }


        public Node connect(Node root) {

            if(root==null)
                return root;
            Queue<Node> que = new LinkedList<>();
            que.add(root);

            while (!que.isEmpty()) {
                int size = que.size();

                for (int i = 0; i < size; i++) {

                    Node poll = que.poll();
                    if(i != size-1)
                        poll.next = que.peek();// 取出队列的头元素,是下一个的
                    if (poll.left != null)
                        que.add(poll.left);

                    if (poll.right != null)
                        que.add(poll.right);

                }
            }

            return root;
        }


    }



    public static void main(String Args[]) {
//        Node node7 = new Node(7);
//        Node node6 = new Node(6,null, null, node7);
//        Node node5 = new Node(5,null, null, node6);
//        Node node4 = new Node(4,null, null, node5);
//        Node node3 = new Node(3,node6, node7, null);
//        Node node2 = new Node(2,node4, node5, node3);
//        Node node = new Node(1,node2, node3, null);
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3,node6, node7, null);
        Node node2 = new Node(2,node4, node5, null);
        Node node = new Node(1,node2, node3, null);


        Solution solution = new Solution();
        Node connect = solution.connect(node);
        System.out.println(connect);


    }

}
