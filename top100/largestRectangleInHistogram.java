package top100;

//web https://leetcode-cn.com/problems/largest-rectangle-in-histogram


import java.util.*;

public class  largestRectangleInHistogram {
    private static class Solution {

        public Solution() {
        }


//        public int largestRectangleArea(int[] heights) {
////            int[] dp = new int[heights.length];
////            dp[0] = heights[0];
//            int maxArea = heights[0];
//            for (int i = 1; i < heights.length; ++i) {
//                for (int j = 0; j <= i; ++j){
//                    int minVal = heights[j];
//                    for (int k =j; k <= i; ++k) {
//                        minVal = Math.min(minVal,heights[k]);
//                    }
//                    maxArea = Math.max(maxArea,minVal*(i-j+1));
//                }
//            }
//            return maxArea;
//        }
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);

            Deque<Integer> mono_stack = new ArrayDeque<Integer>();
            for (int i = 0; i < n; ++i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    right[mono_stack.peek()] = i;
                    mono_stack.pop();
                }
                left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
                mono_stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }
    }


    public static void main(String[] Args) {
        Solution solution = new Solution();



        int[] heigh = {2,1,5,6,2,3};
        int lists = solution.largestRectangleArea(heigh);
        System.out.println(lists);


    }
}
