package codeContest;

import cn.hutool.core.io.FileUtil;

// https://leetcode.cn/problems/climbing-stairs/
// 题目描述: 现在进行选择题考试,单选题1分,双选题4分,你有多少种不同的方法可以获取到指定分数呢？
// 示例 1：
//输入：n = 2
//输出：1
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶

//示例 2：
//
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶

public class countScore {


    public static Long countScore(int n) {
        if (n < 4) return 1l;
        Long[] dp = new Long[n + 1];
        dp[0] = 1L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        for(int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 4];
        }
        return dp[n];
    }

    public static void main(String[] args) {


        for (int n = 0; n <= 100; ++n) {
//        int n = 101;
            Long res = countScore(n);
            System.out.println(n + "," + res);
            String path = "D:\\ZGZ\\labuladong\\java-letcode\\src\\main\\java\\codeContest\\countScoreTestCase\\";
            int caseNum = n;
            FileUtil.writeUtf8String(String.valueOf(n), path + String.valueOf(caseNum) + ".in");
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
