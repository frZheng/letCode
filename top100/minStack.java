package top100;

//web https://leetcode.cn/problems/min-stack


import java.util.Deque;
import java.util.LinkedList;

public class minStack {
    private static class MinStack {
        Deque<Integer> xStack;
        Deque<Integer> minStack;
        public MinStack() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            xStack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();

        }

        public int getMin() {
            return minStack.peek();
        }

    }


    public static void main(String Args[]) {
        MinStack solution = new MinStack();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);
        int min = solution.getMin();
        System.out.println(min);
        solution.pop();
        min = solution.top();
        System.out.println(min);
        min = solution.getMin();
        System.out.println(min);
    }
}
