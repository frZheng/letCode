package offer;

//web https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof


public class erWeiShuZuZhongDeChaZhaoLcof {
    private static class Solution {

        public Solution() {
        }
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0)return false;
            int row = matrix.length, col = matrix[0].length, cur_row = 0, cur_col = col - 1;

            while (cur_row < row && cur_col >= 0) {
                if (matrix[cur_row][cur_col] > target) {
                    --cur_col;
                } else if(matrix[cur_row][cur_col] < target) {
                    ++cur_row;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[][] arr = { {1,   4,  7, 11, 15},
                        {2,   5,  8, 12, 19},
                        {3,   6,  9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30},};
        boolean s = solution.findNumberIn2DArray(arr, 20);
        System.out.println(s);

    }
		
}
