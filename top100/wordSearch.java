package top100;

//web https://leetcode-cn.com/problems/word-search


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class  wordSearch {
    private static class Solution {

        public Solution() {
        }


        public boolean exist(char[][] board, String word) {
            char[] chars = word.toCharArray();
            int[] rowStep = {-1, 0, 1, 0};
            int[] colStep = {0, 1, 0, -1};
            boolean[][] visited = new boolean[board.length][board[0].length];

            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {

                    for (int a = 0; a < visited.length; ++a) {
                        for (int b = 0; b < visited[0].length; ++b) {
                            visited[a][b] = false;
                        }
                    }

//                    System.out.println(i + "," + j);
                    boolean dfs = dfs(board, chars, 0, i, j, rowStep, colStep,visited);
                    if (dfs)
                        return true;
                }
            }
            return false;
        }
        public boolean dfs(char[][] board, char[] chars, int i,
                           int row, int col,int[] rowStep,int[] colStep,boolean[][] visited) {

            if (row < 0 || row > board.length-1 ||
                col < 0 || col > board[0].length-1||
                visited[row][col]||
                board[row][col] != chars[i]

            )
                return false;

            if(i == chars.length-1)
                return true;

            boolean res = false;
            for (int j = 0; j < rowStep.length; ++j) {
                visited[row][col] = true;
                res |= dfs(board,chars,i+1,row + rowStep[j],
                        col + colStep[j],rowStep,colStep,visited);
                visited[row][col] = false;

            }
            if(res)
                visited[row][col] = true;
            return res;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
//        char[][] board = {
//                {'A','S','C','E'},
//                {'E','E','C','S'},
//                {'A','D','E','E'}};
//        String word = "SEE";
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCB";


        boolean lists = solution.exist(board,word);
        System.out.println(lists);


    }
}
