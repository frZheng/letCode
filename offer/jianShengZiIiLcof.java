package offer;

//web https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof


import java.util.HashMap;

public class  jianShengZiIiLcof {
    private static class Solution {

        public Solution() {
        }

        public int cuttingRope(int n) {
            if(n == 2) return 1;
            if(n == 3) return 2;
            long result = 1;
            while (n > 4) {
                n -= 3;
                result *= 3;
                result = result % 1000000007;
            }
            return (int)(result * n % 1000000007);
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        int lists = solution.cuttingRope(120);
        System.out.println(lists);
    }



}
