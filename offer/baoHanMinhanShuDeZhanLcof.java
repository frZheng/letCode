package highFre;


import java.util.ArrayList;
import java.util.LinkedList;

//web https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof

public class baoHanMinhanShuDeZhanLcof {

    private static class MinStack {
        /** initialize your data structure here. */

        private class Node {

            int val;
            int minVal;
            Node next;

            public Node(int val, int minVal, Node next) {
                this.val = val;
                this.minVal = minVal;
                this.next = next;
            }
        }
        private Node head; // 不能写static
        public MinStack() {
        }

        public void push(int x) {
            if (head == null)
                head = new Node(x, x, null);
            else
                // 这里是现有的最小值和输入x之间的最小值
                head = new Node(x, Math.min(head.minVal, x), head);

        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int min() {
            return head.minVal;
        }

	}
	public static void main(String Args[]) {
        MinStack minStack = new MinStack();
        int res;
        minStack.push(-1);
//        minStack.push(0);
//        minStack.push(-3);
//        res = minStack.min();
//        System.out.println(res);
//        minStack.pop();
        res = minStack.top();
        System.out.println(res);
        res = minStack.min();
        System.out.println(res);



    }
}
