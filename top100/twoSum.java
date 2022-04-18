package top100;

//web https://leetcode-cn.com/problems/two-sum


import java.util.HashMap;

public class twoSum {
    private static class Solution {

        public Solution() {
        }


        public int[] twoSum(int[] nums, int target) {
//            int[] ints = new int[2];
//            boolean finded = false;
//            int i = 0;
//            while (!finded && i < nums.length) {
//                for (int j = i + 1; j < nums.length; ++j) {
//                    if (target==nums[i] + nums[j]) {
//                        ints[0] = i;
//                        ints[1] = j;
//                        finded = true;
//                        break;
//                    }
//                }
//                ++i;
//            }
//            return ints;

            int[] indexs = new int[2];
            // 建立k-v ，一一对应的哈希表
            HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
            for(int i = 0; i < nums.length; i++){
                if(hash.containsKey(nums[i])){
                    indexs[0] = i;
                    indexs[1] = hash.get(nums[i]);
                    return indexs;
                }
                // 将数据存入 key为补数 ，value为下标
                hash.put(target-nums[i],i);
            }
            return indexs;
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] lists = solution.twoSum(nums, target);
        for (int i : lists)
            System.out.println(i);

    }

}
