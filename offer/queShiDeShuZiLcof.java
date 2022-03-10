package offer;

//web https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof


public class queShiDeShuZiLcof {
    private static class Solution {

        public Solution() {
        }
        public int missingNumber(int[] nums) {
//            if (nums.length == 1 && nums[0]==0) return 1;
//            if (nums.length == 1 && nums[0]==1) return 0;
            for (int i = 0; i < nums.length; ++i) {
                if(nums[i] != i)
                    return i;
            }
            return nums.length;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] arr = {0,1,3};
        int s = solution.missingNumber(arr);
        System.out.println(s);

    }
		
}
