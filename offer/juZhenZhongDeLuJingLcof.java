package offer;

//web https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof

public class juZhenZhongDeLuJingLcof {
    private static class Solution {

        public Solution() {
        }

        public boolean exist(char[][] board, String word) {
            if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
                return false;
            }
            boolean[][] isVisited = new boolean[board.length][board[0].length];
            char[] chs = word.toCharArray();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == chs[0]) {
                        if (bfs(board, i, j, isVisited, chs, 0)) return true;
                    }
                }
            }
            return false;
        }

        private boolean bfs(char[][] board, int i, int j, boolean[][] isVisited, char[] chs, int index) {

            if (index == chs.length) {
                return true;
            }
            if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != chs[index]) {
                return false;
            }
            isVisited[i][j] = true;
            boolean res =  bfs(board, i + 1, j, isVisited, chs, index + 1)
                        || bfs(board, i - 1, j, isVisited, chs, index + 1)
                        || bfs(board, i, j + 1, isVisited, chs, index + 1)
                        || bfs(board, i, j - 1, isVisited, chs, index + 1);
            isVisited[i][j] = false;
            return res;
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
//        String teest = "123";
//        System.out.println(teest.length());

        char[][] board =  {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean lists = solution.exist(board, "ABCCED");
        System.out.println(lists);

    }

}
