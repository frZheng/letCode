package offer;

//web https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof

import java.util.HashMap;

public class shuZuZhongZhongFuDeShuZiLcof {
    private static class Solution {

        public Solution() {
        }
        public int findRepeatNumber(int[] nums) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; ++i) {
                boolean b = hashMap.containsKey(nums[i]);
                if (b) {
                    return nums[i];
                }
                else{
                    hashMap.put(nums[i], 0);
                }

            }
            return 0;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int s = solution.findRepeatNumber(arr);
        System.out.println(s);

    }
		
}
