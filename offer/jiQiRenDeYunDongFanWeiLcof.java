package offer;

//web https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof

public class jiQiRenDeYunDongFanWeiLcof {
    private static class Solution {

        public Solution() {
        }

        int calSum(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num%10;
                num/=10;
            }
            return sum;
        }

//        public int movingCount(int m, int n, int k) {
//            int reslut = 0;
//            int[][] dp = new int[m][n];
//            for (int i = 0; i < m; ++i) {
//                if (i < k) dp[i][0] = i + 1;
//            }
//            for (int i = 0; i < n; ++i) {
//                if (i < k) dp[0][i] = i + 1;
//            }
//
//            for (int i = 1; i < m; ++i) {
//                for (int j = 1; j < n; ++j) {
//
//                    if(calSum(i) + calSum(j) <= k) {
////                        reslut++;
//                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + 1;
//                        reslut = Math.max(reslut, dp[i][j]);
//                    }
//                    else break;
//                }
//            }
//            return reslut;
//        }
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            return dfs(0, 0, m, n, k, visited);
        }

        private int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
            if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) +
                    dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + 1;
        }

    }
    public static void main(String Args[]) {

        Solution solution = new Solution();
//        System.out.println(solution.calSum(0));
//        System.out.println(solution.calSum(15));
//        System.out.println(solution.calSum(100));

//        String teest = "123";
//        System.out.println(teest.length());


        int lists = solution.movingCount(16, 8, 4);
        System.out.println(lists);

    }

}
