package top100;

//web https://leetcode.cn/problems/daily-temperatures


import java.util.*;

public class  dailyTemperatures {
    private static class Solution {

        public Solution() {
        }
        public int[] dailyTemperatures(int[] temperatures) {
            int size = temperatures.length;
            int[] answer = new int[size];

//            for (int i = 0; i <size-1; ++i) {
//                for (int j = i+1; j < size;++j){
//                    if (temperatures[j] > temperatures[i]){
//                        answer[i] = j - i;
//                        break;
//                    }
//                }
//            }

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                int temperature = temperatures[i];
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    int prevIndex = stack.pop();
                    answer[prevIndex] = i - prevIndex;
                }
                stack.push(i);
            }

//            int maxTemp = Integer.MIN_VALUE;
//            int index = size-1;
//            for (int i = 0; i < size-1;--i) {
//                if (maxTemp < temperatures[i+1]) {
//                    maxTemp = temperatures[i + 1];
//                    index = i+1;
//                }
//                if (temperatures[i] > maxTemp){
//
//                }
//            }
            return answer;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int[]temperatures = {
                73,74,75,71,69,72,76,73
        };
        // 1,1,4,2,1,1,0,0

        int[] res = solution.dailyTemperatures(temperatures);
        StringBuilder msg = new StringBuilder();
        for (int i : res) {
            msg.append(i);
            msg.append(",");
        }
        System.out.println(msg);


    }
}
