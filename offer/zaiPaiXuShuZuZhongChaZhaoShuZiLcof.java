package offer;

//web https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof

import java.util.HashMap;

public class zaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    private static class Solution {

        public Solution() {
        }
        public int search(int[] nums, int target) {
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == target)
                    ++count;
            }
            return count;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] arr = {5,7,7,8,8,10};
        int s = solution.search(arr, 8);
        System.out.println(s);

    }
		
}
