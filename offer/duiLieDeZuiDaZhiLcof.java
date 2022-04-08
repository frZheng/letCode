package offer;

 //web https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof

import java.util.*;

public class duiLieDeZuiDaZhiLcof {
    private static class Solution {

        public Solution() {
        }
        private Deque<Integer> queue;
        private Deque<Integer> help;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        public int max_value() {
            return queue.isEmpty() ? -1 : help.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while(!help.isEmpty() && value > help.peekLast()) {
                help.pollLast();
            }
            help.offer(value);
        }

        public int pop_front() {
            if(queue.isEmpty()) {
                return -1;
            }
            int val = queue.pop();
            if(help.peek() == val) {
                help.pop();
            }
            return val;
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] num = {1,3,-1,-3,5,3,6,7};
        int[] lists = solution.maxSlidingWindow(num,3);
        for (int l : lists)
            System.out.println(l);

    }

}
