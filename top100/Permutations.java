package top100;


//web https://leetcode-cn.com/problems/permutations


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Permutations {
    private static class Solution {

        public Solution() {
        }
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> one = new ArrayList<Integer>();
            dfs(nums,res,one);
            return res;
        }
        void dfs(int[] nums,List<List<Integer>> res,List<Integer> one) {
            if (one.size() == nums.length) {
                res.add(new ArrayList<>(one));
                return;
            }
            for (int num : nums) {
                boolean flag = true;
                for (int j : one)
                    if (j == num) {
                        flag = false;
                        break;
                    }
                if (flag) {
                    one.add(num);
                    dfs(nums, res, one);
                    one.remove(one.size() - 1);
                }
            }
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {1,2,3};
        List<List<Integer>> lists = solution.permute(arr);
        for (List<Integer> list :lists){
            StringBuilder msg = new StringBuilder();
            for (int i : list) {
                msg.append(i).append(",");
            }
            System.out.println(msg);
        }

    }

}
