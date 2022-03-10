package offer;

//web https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof

public class fuZaLianBiaoDeFuZhiLcof {

    private static class Solution {

        public Solution() {
        }
        public Node copyRandomList(Node head) {
            if (head == null) return head;

            //将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
            Node cur = head;
            while (cur != null) {
                Node node = new Node(cur.val);
                node.next = cur.next;
                cur.next = node;
                cur = cur.next.next;
            }

            //拷贝random，例如1_2->1'_null这样的链表就变成了这样1_2->1'_2'
            cur = head;
            while (cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            // 删除多余的节点
            Node copyHead = head.next;
            cur = head;
            Node tmp = null;
            while (cur != null && cur.next != null) {
                tmp = cur.next;
                cur.next = cur.next.next;
                cur = tmp;
            }
            return copyHead;
        }

//        public Node copyRandomList(Node head) {
//            if (head == null) {
//                return head;
//            }
//            //将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
//            for (Node node = head, copy = null; node != null; node = node.next.next) {
//                copy = new Node(node.val);
//                copy.next = node.next;
//                node.next = copy;
//            }
//            //把拷贝节点的random指针安排上
//            for (Node node = head; node != null; node = node.next.next) {
//                if (node.random != null) {
//                    node.next.random = node.random.next;
//                }
//            }
//            //分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
//            Node newHead = head.next;
//            for (Node node = head, temp = null; node != null && node.next != null;) {
//                temp = node.next;
//                node.next = node.next.next;
//                node = temp;
//            }
//
//            return newHead;
//        }

	}
	public static void main(String Args[]) {
        Solution solution = new Solution();
//        int[][] array = {{1,1},{2,1}};
        String str = "[[7,null],[13,0],[11,4],[10,2],[1,0]]";
        String newStr = str.substring(2,str.length() - 2);
        String[] split = newStr.split("],\\[");
        Node head = new Node(Integer.parseInt(split[0].split(",")[0]));
        Node cur= head;
        int len = 1;
        for (int i = 1; i < split.length; ++i) {
            System.out.println(split[i]);
            cur.next = new Node(Integer.parseInt(split[i].split(",")[0]));
            cur = cur.next;
            ++len;
        }
        cur= head;
        Node[] nodes = new Node[len];
        for (int i = 0; i < nodes.length; ++i) {
            nodes[i] = cur;
            cur = cur.next;
        }
        for (int i = 0; i < nodes.length; ++i) {
            String str1 = split[i].split(",")[1];
//            System.out.println(i + str1);
            if (str1.equals("null")) {
                nodes[i].random = null;
                continue;
            }
            int index = Integer.parseInt(str1);
            nodes[i].random = nodes[index];
        }
        Node fib = solution.copyRandomList(head);
//        Node fib = head;

        System.out.println("result");
        while (fib != null) {
            if (fib.random != null)
                System.out.println(fib.val + ", " + fib.random.val);
            else
                System.out.println(fib.val + ", " + "null");
            fib = fib.next;
        }



//        solution.copyRandomList()


    }
}
