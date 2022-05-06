package top100;

//web https://leetcode-cn.com/problems/subsets


import list.ListNode;

import java.util.*;

public class Subsets {
    private static class Solution {

        public Solution() {
        }

//        public List<List<Integer>> subsets(int[] nums) {
//            List<List<Integer>> res = new ArrayList<>();
//            ArrayList<Integer> one = new ArrayList<>();
//            res.add(one);
//
//            for (int i = 1; i < nums.length; ++i) {
//
//            }
//            return res;
//        }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>(); // 解集
        lists.add(new ArrayList<Integer>()); // 首先将空集加入解集中
        for (int num : nums) {
            int size = lists.size(); // 当前子集数
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(lists.get(j));// 拷贝所有子集
                newList.add(num); // 向拷贝的子集中加入当前数形成新的子集
                lists.add(newList); // 向lists中加入新子集
            }
        }
        return lists;
    }

    }




    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution.subsets(nums);

        for (List<Integer> lis: subsets) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer i : lis) {
                stringBuilder.append(i).append(",");
            }
            System.out.println(stringBuilder.toString());
        }


    }

}
