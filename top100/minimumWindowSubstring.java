package top100;

//web https://leetcode-cn.com/problems/minimum-window-substring


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class  minimumWindowSubstring {
    private static class Solution {

        public Solution() {
        }


        public String minWindow(String s, String t) {
            if(t.length()>s.length())return "";
            int len = s.length();
            int left =0;
            int right =0;
            int num=0;
            int min=100000;
            int resleft=0;
            int resright=-1;//如此定义，若没有匹配成功返回的substrinig就是空
            int[] count = new int[128];//记录对应字母仍未匹配的数量，acsii码总长128
            Arrays.fill(count,-len);//可以保证后面加待匹配字符种类时，不会加到0
            for(int i = 0; i < t.length(); i++){
                if(count[t.charAt(i) ] == -len){
                    count[t.charAt(i) ] =0;
                    num++;//新的字符种类
                }
                count[t.charAt(i)]++;
            }

            while(right<s.length()){
                char ch = s.charAt(right);
                count[ch]--;
                if(count[ch] == 0)num--;//每当一个字符ch所需的个数为0时，表示已经不需要再匹配该字符了
                while(num == 0){
                    if(right - left +1 < min){
                        resleft = left;
                        resright = right;
                        min = right- left +1;
                    }
                    count[s.charAt(left)]++;
                    if(count[s.charAt(left)] == 1)num++;//窗口左边界出去的那个字符是我们需要的
                    left ++;
                }
                right ++;
            }
            return s.substring(resleft,resright+1);
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        String s = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);


    }
}
