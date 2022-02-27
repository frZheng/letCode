package dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//web https://leetcode-cn.com/problems/perfect-squares/
public class perfectSquares {
    private static class Solution {

        public Solution() {
        }

        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for(int i = 1; i <= n; ++i) {
                dp[i] = i;
            }
            dp[0] = 0;
            ArrayList<Integer> squares = new ArrayList<>();
            int square;
            for(int i = 1; i <= n; ++i) {
                square = i * i;
                if (square <= n)
                    squares.add(square);
                else
                    break;
            }


            for(int i = 0; i < squares.size(); ++i) {
                square = squares.get(i);
                for (int j = square; j <= n; ++j) {
                    dp[j] = Math.min(dp[j], dp[j - square] + 1);
                }

//                String str = "";
//                str += square;
//                str += ": ";
//                for (int j = 0; j <= n; ++j) {
////                    System.out.println(dp[j]);
//                    str += dp[j];
//                    str += ",";
//                }
//                System.out.println(str);
            }
            return dp[n];

        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
//        int[] coins = {1, 2, 5};
        int fib = solution.numSquares( 13);
        System.out.println(fib);
    }
}
