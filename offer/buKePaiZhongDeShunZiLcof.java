package offer;

//web https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class buKePaiZhongDeShunZiLcof {
    private static class Solution {

        public Solution() {
        }


        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int zeroCnt=0,diff=0;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]==0){
                    zeroCnt++;
                }else{
                    if(nums[i]==nums[i+1]) return false;
                    if(nums[i]+1!=nums[i+1]){
                        diff+=nums[i+1]-nums[i]-1;
                    }
                }
            }
            return zeroCnt>=diff;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] num = {1,2,3,4,5};
        boolean lists = solution.isStraight(num);
        System.out.println(lists);

    }

}
