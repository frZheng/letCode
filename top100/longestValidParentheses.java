package top100;

//web https://leetcode-cn.com/problems/longest-valid-parentheses


import java.util.Deque;
import java.util.LinkedList;

public class longestValidParentheses {
    private static class Solution {

        public Solution() {
        }
//        public int longestValidParentheses(String s) {
//            int maxans = 0;
//            Deque<Integer> stack = new LinkedList<Integer>();
//            stack.push(-1);
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == '(') {
//                    stack.push(i);
//                } else {
//                    stack.pop();
//                    if (stack.isEmpty()) {
//                        stack.push(i);
//                    } else {
//                        maxans = Math.max(maxans, i - stack.peek());
//                    }
//                }
//            }
//            return maxans;
//        }

        public int longestValidParentheses(String s) {
            int maxans = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }


    }


    public static void main(String Args[]) {
        Solution solution = new Solution();

        int i1 = solution.longestValidParentheses(")()())");
        System.out.println(i1);
    }
}