package offer;

//web https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof

public class tiHuanKongGeLcof {
    private static class Solution {

        public Solution() {
        }
        public String replaceSpace(String s) {
            return s.replace(" ", "%20");
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String s = solution.replaceSpace("We are happy.");
        System.out.println(s);

    }
		
}
