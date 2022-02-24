package dp;

//web https://leetcode-cn.com/problems/unique-paths/
public class uniquePathsIi {
    private static class Solution {

        public Solution() {
        }

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid[0][0] == 1) return 0;
            int rowNum = obstacleGrid.length;
            int colNum = obstacleGrid[0].length;
            int[][] dp = new int[rowNum][colNum];
            dp[0][0] = 1;
            for (int i = 1; i < rowNum; ++i) {
                if (obstacleGrid[i][0] == 1)
                    dp[i][0] = 0;
                else
                    dp[i][0] = dp[i - 1][0];
//                System.out.println(i + " " + dp[i][0]);
            }
            for (int i = 1; i < colNum; ++i) {
                if (obstacleGrid[0][i] == 1)
                    dp[0][i] = 0;
                else
                    dp[0][i] = dp[0][i - 1];
//                System.out.println(i + " " + dp[0][i]);
            }

            for (int i = 1; i < rowNum; ++i){
                for (int j = 1; j < colNum; ++j) {
                    if(obstacleGrid[i][j] == 1)
                        dp[i][j] = 0;
                    else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
//                    System.out.println(i + " " + j + " " + dp[i][j]);
                }
            }

            return dp[rowNum - 1][colNum - 1];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
//        int[][] obstacleGrid = {{0,0,0}, {0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,1}, {0,0}};
        int fib = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(fib);
    }
}
