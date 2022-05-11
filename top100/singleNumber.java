package top100;


//web https://leetcode.cn/problems/single-number


import java.util.*;

public class  singleNumber {
    private static class Solution {

        public Solution() {
        }
//        public int singleNumber(int[] nums) {
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int i : nums) {
//                Integer last = map.getOrDefault(i, 0);
//                map.put(i,last+1);
//            }
//            for (int i : nums) {
//                if (map.get(i)==1)
//                    return i;
//            }
//            return 0;
//        }
        public int singleNumber(int[] nums) {
            int single = nums[0];
            for (int i =1; i < nums.length; ++i) {
                single ^= nums[i];
            }
            return single;
        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {4,1,2,1,2};
        int lists = solution.singleNumber(arr);
        System.out.println(lists);

    }

}
