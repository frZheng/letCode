package top100;

//web https://leetcode-cn.com/problems/search-in-rotated-sorted-array



public class   searchInRotatedSortedArray {
    private static class Solution {

        public Solution() {
        }


        public int search(int[] nums, int target) {
            int res = -1;
            for (int i = 0; i < nums.length; ++i){
                    if (nums[i] == target)
                        return i;
            }
            return res;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int[] nums =  {4,5,6,7,0,1,2};
        int s = solution.search(nums,0);
        System.out.println(s);

    }
}
