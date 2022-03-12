package offer;

//web https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof

public class heWeiSdeLiangGeShuZiLcof {
    private static class Solution {

        public Solution() {
        }

//        public int[] twoSum(int[] nums, int target) {
//            int[] result = new int[2];
//            int len = nums.length;
//            for (int i = 0; i < len; ++i) {
//                if (nums[i] > target) continue;
//                for (int j = i; j < len; ++j) {
//                    if (nums[j] > target) break;
//                    if (target == nums[i] + nums[j]) {
//                        result[0] = nums[i];
//                        result[1] = nums[j];
//                        return result;
//                    }
//                }
//            }
//            return result;
//        }

        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            int low = 0, high = len - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    return new int[]{nums[low], nums[high]};
                }
                else if(sum < target) {
                    low++;
                }
                else {
                    high--;
                }
            }
            return new int[2];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {14,15,16,22,53,60};
        int[] lists = solution.twoSum(nums, 76);
        for (int i : lists)
            System.out.println(i);

    }

}
