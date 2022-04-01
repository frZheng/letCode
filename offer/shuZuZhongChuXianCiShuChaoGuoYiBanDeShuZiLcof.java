package offer;

 //web https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof



public class shuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    private static class Solution {

        public Solution() {
        }
        public int majorityElement(int[] nums) {
            int count = 1;
            int result = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                if (count == 0)
                    result = nums[i];
                count += (result == nums[i])?1:-1;
            }
            return result;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();


//        String str = "3,4,5,1,2,null,null";

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int b = solution.majorityElement(nums);

        System.out.println(b);

    }



}
