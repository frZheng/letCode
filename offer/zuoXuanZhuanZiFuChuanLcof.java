package offer;

 //web https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof

public class zuoXuanZhuanZiFuChuanLcof {
    private static class Solution {

        public Solution() {
        }
        public String reverseLeftWords(String s, int n) {
            if (s == null) return null;
            int len = s.length();
            if (n >= len) return s;
            return s.substring(n,len) + s.substring(0,n);
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String s = solution.reverseLeftWords("abcdefg", 2);
        System.out.println(s);

    }
		
}
