package offer;

//web https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof


import java.util.ArrayDeque;
import java.util.Deque;

public class biaoShiShuZhiDeZiFuChuanLcof {
    private static class Solution {

        public Solution() {
        }
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            //去掉首位空格
            s = s.trim();
            boolean numFlag = false;
            boolean dotFlag = false;
            boolean eFlag = false;
            for (int i = 0; i < s.length(); i++) {
                //判定为数字，则标记numFlag
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    numFlag = true;
                    //判定为.  需要没出现过.并且没出现过e
                } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                    dotFlag = true;
                    //判定为e，需要没出现过e，并且出过数字了
                } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                    eFlag = true;
                    numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                    //判定为+-符号，只能出现在第一位或者紧接e后面,直接跳过不校验
                } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                    //其他情况，都是非法的
                } else {
                    return false;
                }
            }
            return numFlag;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        String str = "123";
        boolean sum = solution.isNumber(str);
        System.out.println(sum);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
