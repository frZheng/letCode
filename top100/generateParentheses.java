package top100;

 //web https://leetcode-cn.com/problems/generate-parentheses


import java.util.ArrayList;
import java.util.List;


public class    generateParentheses {
    private static class Solution {

        public Solution() {
        }

        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            generate(res, "", 0, 0, n);
            return res;
        }
        //count1统计“(”的个数，count2统计“)”的个数
        public void generate(List<String> res , String ans, int count1, int count2, int n){
            if(count1 > n || count2 > n) return;
            if(count1 == n && count2 == n)  res.add(ans);
            if(count1 >= count2){
                String ans1 = new String(ans);
                generate(res, ans+"(", count1+1, count2, n);
                generate(res, ans1+")", count1, count2+1, n);
            }
        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        List<String> lists = solution.generateParenthesis(3);
        for (String list : lists) {
            System.out.println(list);
        }
    }

}
