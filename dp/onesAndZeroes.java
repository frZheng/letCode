package dp;

//web https://leetcode-cn.com/problems/unique-paths/
public class  onesAndZeroes {
    private static class Solution {

        public Solution() {
        }

        public int findMaxForm(String[] strs, int numOfZero, int numOfOne) {
            if (strs.length == 0) return 0;
            int[][] dp = new int[numOfZero + 1][numOfOne + 1];

            for( String s : strs) {
                int oneNum = 0, zeroNum = 0;
                for (char c : s.toCharArray()) {
                    if (c == '0') ++zeroNum;
                    else ++oneNum;
                }
//                System.out.println(oneNum + " " + zeroNum);
                for (int i = numOfZero; i >= zeroNum; --i) {
                    for (int j = numOfOne; j >= oneNum; --j) {
                        int row = i - zeroNum;
                        int col = j - oneNum;
//                        System.out.println("in: " + row + " " + col);
                        dp[i][j] = Math.max(dp[i][j], dp[row][col] + 1);
                    }
                }

            }
            return dp[numOfZero][numOfOne];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String [] strs = {"10", "0001", "111001", "1", "0"};
        int fib = solution.findMaxForm(strs, 5, 3);
        System.out.println(fib);
    }
}
