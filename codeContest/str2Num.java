package codeContest;

import cn.hutool.core.io.FileUtil;

import java.util.*;

// https://leetcode.cn/problems/roman-to-integer/
//SIAT数字包含以下七种字符: A， B， C， D，E，F 和 G。
//        字符          数值
//        A             1
//        B             5
//        C             10
//        D             50
//        E             100
//        F             500
//        G             1000
//        例如， SIAT数字 2 写做 AA ，即为两个并列的 1 。12 写做 CAA ，即为 C + AA 。 27 写做  CCBAA, 即为 CC + B + AA 。
//        通常情况下，SIAT数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 AAAA，而是 AB。
//        数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
//        同样地，数字 9 表示为 AC。这个特殊的规则只适用于以下六种情况：
//        A 可以放在 B (5) 和 C (10) 的左边，来表示 4 和 9。
//        C 可以放在 D (50) 和 E (100) 的左边，来表示 40 和 90。
//        E 可以放在 F (500) 和 G (1000) 的左边，来表示 400 和 900。
//        给定一个SIAT数字，将其转换成整数。
//

// 示例 1：
//输入： s = "AAA"
//输出：3

// 示例 2：
//输入： s = "AB"
//输出：4

// 示例 3：
//输入： s = "AC"
//输出：9

//输入4: s = "DBAAA"
//输出: 58
//解释: D = 50, B= 5, AAA = 3.

//输入5: s = "GEGCEAB"
//输出: 1994
//解释: G = 1000, EG = 900, CE = 90, AB = 4.
public class str2Num {


    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('A', 1);
        put('B', 5);
        put('C', 10);
        put('D', 50);
        put('E', 100);
        put('F', 500);
        put('G', 1000);
    }};

    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
    //length用户要求产生字符串的长度
    public static String getRandomString(int length){
        String str="ABCDEFG";

        Random random=new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


    public static void main(String[] args) {

//        System.out.println(getRandomString(3));
        for (int i = 0; i < 100; ++i) {
            Random random=new Random();
            int number=random.nextInt(10);
            String arr = getRandomString(number);
            System.out.println(arr);
            int res = romanToInt(arr);
            System.out.println(res);

            String path = "D:\\ZGZ\\labuladong\\java-letcode\\src\\main\\java\\codeContest\\str2NumTestCase\\";
            int caseNum = i;
            FileUtil.writeUtf8String(arr, path + String.valueOf(caseNum) + ".in");
            FileUtil.writeUtf8String(String.valueOf(res), path + String.valueOf(caseNum) + ".out");
        }

//        Scanner sc = new Scanner(System.in);
//        String next = sc.nextLine();
//        String[] s = next.split(",");
//        int size = s.length;
//        StringBuilder msg = new StringBuilder();
//
//        for (int i = 0; i < size; ++i){
////            System.out.println(s[size - 1 - i]);
//            msg.append(s[size - 1 - i]);
//            if (i < size - 1)
//                msg.append(" ");
//        }
//        System.out.print(msg.toString());
    }
}
