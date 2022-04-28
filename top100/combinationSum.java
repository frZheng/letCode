package top100;


//web https://leetcode-cn.com/problems/combination-sum


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  combinationSum {
    private static class Solution {

        public Solution() {
        }


//        List<List<Integer>> res;
//        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            res = new ArrayList<>();
//            List<Integer> integers = new ArrayList<>();
//            dfs(candidates,target,integers);
//            return res;
//        }
//        void dfs(int[] candidates,int target, List<Integer> ints){
//            if(target < 0) return;
//            if (target == 0) {
//                List<Integer> integers = new ArrayList<>(ints);
//                res.add(integers);
//            }
//            for (int i : candidates) {
//                ints.add(i);
//                target -= i;
//                if (target >= 0)
//                    dfs(candidates,target,ints);
//                target += i;
//                ints.remove(ints.size() -1);
//            }
//        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<>(combine));
                return;
            }
            // 直接跳过
            dfs(candidates, target, ans, combine, idx + 1);
            // 选择当前数
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }

    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {2,3,6,7};
        List<List<Integer>> lists = solution.combinationSum(arr, 7);
        for (List<Integer> list : lists){
            StringBuilder msg = new StringBuilder();
                for (int i : list){
                    msg.append(i).append(",");
                }
            System.out.println(msg);
        }

//        List<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(10);
//        integers.add(100);
//        StringBuilder msg = new StringBuilder();
//        for (int i : integers) {
//            msg.append(i).append(",");
//        }
//        System.out.println(msg);
//
//        msg.setLength(0);
//        integers.remove(integers.size()-1);
//        for (int i : integers) {
//            msg.append(i).append(",");
//        }
//        System.out.println(msg);
    }

}
