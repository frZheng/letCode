//web https://leetcode-cn.com/problems/zigzag-conversion


public class test {
    private static class Solution {

        public Solution() {
        }


        public int[] convert(int[] lowArr, int[] highArr, int[][] numArr) {
            int[] nums = new int[numArr.length];
            int max = 127;
            for (int i = 0; i < nums.length; ++i){
                int res = 0;
                for(int j =0; j < numArr[i].length;++j) {
                    if(numArr[i][j] == 1) {
                        res |= (0x01 << highArr[j]);
                        res &= ~(0x01 << lowArr[j]);
                    }
                }
            }
            return nums;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int[] lowArr = {1,5,3,1,3,5,1,2};
        int[] highArr = {6,2,2,2,1,1,5,1};
        int[][] numArr = {
                {1,1,1,1,1,1,0,0},
                {0,1,1,0,0,0,0,0},
                {1,1,0,1,1,0,1,0},
                {1,1,1,1,0,0,1,0},
                {0,1,1,0,0,1,1,0},
                {1,0,1,1,0,1,1,0},
                {1,0,1,1,1,1,1,0},
                {1,1,1,0,0,1,0,0},
                {1,1,1,1,1,1,1,0},
                {1,1,1,0,0,1,1,0}
        };
        int[] s = solution.convert(lowArr,highArr,numArr);
        for (int i : s)
            System.out.println(i);

    }
}
