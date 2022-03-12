package offer;

 //web https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof

public class diaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    private static class Solution {

        public Solution() {
        }

        public int[] exchange(int[] nums) {
            int len = nums.length;
            int tmp, low = 0, high = len -1;
            while (low < high) {
                while ((nums[low] & 0x01) == 0x01 && low < high) {
                    low++;
                }
                while ((nums[high] & 0x01) == 0x00 && low < high) {
                    high--;
                }
                tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
            }
            return nums;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        int[] lists = solution.exchange(nums);
        for (int i : lists)
            System.out.println(i);

    }

}
