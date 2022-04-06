package offer;

  //web https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof


import java.util.ArrayDeque;
import java.util.Deque;

public class zhanDeYaRuDanChuXuLieLcof {
    private static class Solution {

        public Solution() {
        }
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque();
            int j = 0;
            for (int elem : pushed) {
                stack.push(elem);
                while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return j == popped.length;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        boolean sum = solution.validateStackSequences(pushed, popped);
        System.out.println(sum);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
