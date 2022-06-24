package codeContest;

import cn.hutool.core.io.FileUtil;

import java.util.*;

// https://leetcode.cn/problems/valid-parentheses/
//给定一个只包括
// 'S'，'I'，
// 'A'，'T'，
// 's'，'i'，
// 'a'，'t'的字符串 str ，判断字符串是否有效。
//有效字符串需满足：
// 第一个字符必须用相同行的第二个字符闭合。
//字符必须以正确的顺序闭合。

public class validStr {

    public static int isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return 0;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put('I', 'S');
            put('T', 'A');
            put('i', 's');
            put('t', 'a');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return 0;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty())
            return 1;
        else
            return 0;

    }

    //length用户要求产生字符串的长度
    public static String getRandomString(int length){
        String str="SIATsiat";

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
//        System.out.println(isValid("SIAT"));
        for (int i = 0; i < 10; ++i) {
            int res = 1;
            String arr = "";
            while (res == 1) {
                Random random = new Random();
                int number = (random.nextInt(10) + 1) * 2;
                arr = getRandomString(number);
                res = isValid(arr);
            }
            System.out.println(arr);
            System.out.println(res);

            String path = "D:\\ZGZ\\labuladong\\java-letcode\\src\\main\\java\\codeContest\\validStrTestCase\\";
            int caseNum = i;
            StringBuilder inMsg = new StringBuilder();
            inMsg.append(arr.length());
            inMsg.append("\n");
            for (int j = 0; j <arr.length();++j){
                inMsg.append(arr.charAt(j));
                if (j < arr.length() - 1) {
                    inMsg.append(" ");
                }
            }
            FileUtil.writeUtf8String(inMsg.toString(), path + String.valueOf(caseNum) + ".in");
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
