package codeContest;

import cn.hutool.core.io.FileUtil;

// https://leetcode.cn/problems/water-bottles/
// 实验室器材供应商便利店正在促销，用 numExchange 个空试验管可以兑换一瓶试验管。你购入了 numBottles 个试验管。
//如果用掉了试验管中的试剂，那么试验管就会变成空的。
//请你计算 最多 能用到多少个试验管。
// 示例 1：
//输入：numBottles = 9, numExchange = 3
//输出：13
//解释：：你可以用 3 个空酒瓶兑换 1 瓶酒。
//所以最多能喝到 9 + 3 + 1 = 13 瓶酒。

//示例 2：
//
//输入：numBottles = 15, numExchange = 4
//输出：19
//解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
//所以最多能喝到 15 + 3 + 1 = 19 瓶酒。

public class bottle {


    public static int numWaterBottles(int numBottles, int numExchange) {
        return numBottles+(numBottles-1)/(numExchange-1);
    }


    public static void main(String[] args) {

//        System.out.println(numWaterBottles(9, 3));
        int caseNum = 0;
        for (int n = 5; n <= 20; ++n) {
            for (int m = 2; m < n; ++m) {

                int res = numWaterBottles(n, m);
                System.out.println(n + "," + res);
                String path = "D:\\ZGZ\\labuladong\\java-letcode\\src\\main\\java\\codeContest\\bottleTestCase\\";

                FileUtil.writeUtf8String(String.valueOf(n) + " " + String.valueOf(m), path + String.valueOf(caseNum) + ".in");
                FileUtil.writeUtf8String(String.valueOf(res), path + String.valueOf(caseNum) + ".out");
                caseNum += 1;
            }
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
