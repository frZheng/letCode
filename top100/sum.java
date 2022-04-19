package top100;


//web https://leetcode-cn.com/problems/3sum


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  sum {
    private static class Solution {

        public Solution() {
        }

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length < 3)   return result;
            Arrays.sort(nums);//升序
            int left;
            int right;
            int target;


            for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {
                if(i > 0 && nums[i] == nums[i - 1]) continue;
                target = -nums[i];
                left = i + 1;
                right = nums.length - 1;
                while(left <= right - 1){
                    if(nums[left] + nums[right] < target){
                        left++;
                    }else if(nums[left] + nums[right] > target){
                        right--;
                    }else{
                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]== nums[left-1]) left++;
                        while(left<right && nums[right]== nums[right + 1]) right--;
                    }
                }
            }
            return result;

        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {-1,0,1,2,-1,-4};
        List lists = solution.threeSum(arr);
        System.out.println(lists);
    }

}
