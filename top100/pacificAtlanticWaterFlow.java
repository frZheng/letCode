package top100;

//web https://leetcode-cn.com/problems/pacific-atlantic-water-flow


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class  pacificAtlanticWaterFlow {
    private static class Solution {

        public Solution() {
        }


        boolean[][] P, A;
        List<List<Integer>> ret;
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            //水往高处逆流回去
            ret = new ArrayList<>();
            int row = heights.length, col = heights[0].length;
            P = new boolean[row][col];
            A = new boolean[row][col];
            for(int i = 0; i < row; i++) {
                dfs(heights, P, i, 0);
                dfs(heights, A, i, col - 1);
            }
            for(int i = 1; i < col; i++) {
                dfs(heights, P, 0, i);
                dfs(heights, A, row - 1, i - 1);
            }
            return ret;
        }

        void dfs(int[][] heights, boolean[][] vised, int x, int y) {
            if(vised[x][y]) return;
            vised[x][y] = true;
            if(P[x][y] && A[x][y]) ret.add(Arrays.asList(x, y));
            if(x + 1 < heights.length && heights[x][y] <= heights[x + 1][y]) dfs(heights, vised, x + 1, y);
            if(x - 1 >= 0 && heights[x][y] <= heights[x - 1][y]) dfs(heights, vised, x - 1, y);
            if(y - 1 >= 0 && heights[x][y] <= heights[x][y - 1]) dfs(heights, vised, x, y - 1);
            if(y + 1 < heights[0].length && heights[x][y] <= heights[x][y + 1]) dfs(heights, vised, x, y + 1);
        }
    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> listList = solution.pacificAtlantic(heights);
        listList.forEach(i -> {
            StringBuilder msg = new StringBuilder();
            for (int j : i) {
                msg.append(j);
                msg.append(",");
            }
            System.out.println(msg);
        });

    }
}
