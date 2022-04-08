package offer;

//web https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class baZiFuChuanZhuanHuanChengZhengShuLcof {
    private static class Solution {

        public Solution() {
        }


        public int strToInt(String str) {
            str = str.trim();
            if(str.length() == 0){
                return 0;
            }
            boolean isMinus = false;
            char[] ch = str.toCharArray();
            if(ch[0] == '+' || ch[0] == '-' || Character.isDigit(ch[0])){
                if(ch[0] == '+' || ch[0] == '-'){
                    if(ch[0] == '-')
                        isMinus = true;
                    ch = Arrays.copyOfRange(ch,1,ch.length);
                }
                int index = 0;

                long res = 0;

                while(index < ch.length && Character.isDigit(ch[index])){
                    res *= 10;
                    res += ch[index] - '0';
                    if(res > Integer.MAX_VALUE){
                        return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    index++;
                }
                return isMinus ? -(int)res : (int)res;
            }
            return 0;
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String num = "42";
        int lists = solution.strToInt(num);
        System.out.println(lists);

    }

}
