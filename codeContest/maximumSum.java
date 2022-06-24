package codeContest;

import cn.hutool.core.io.FileUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// https://leetcode.cn/problems/maximum-subarray/
// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//子数组 是数组中的一个连续部分。
//
//
public class maximumSum {


    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }



    public static void main(String[] args) {


        for (int j = 0; j < 100; ++j) {


            Random random = new Random();
            int arrLen = random.nextInt(99) + 1;
            int[] nums = new int[arrLen];
            StringBuilder inData = new StringBuilder();
            inData.append(arrLen);
            inData.append("\n");
            for (int i = 0; i < arrLen; ++i) {
                nums[i] = random.nextInt(100) - 10;
                inData.append(nums[i]);
                if (i < arrLen-1)
                    inData.append(" ");
            }
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        String path = "D:\\ZGZ\\labuladong\\java-letcode\\src\\main\\java\\codeContest\\maximumSumTestCase\\";
        int caseNum = j;
        FileUtil.writeUtf8String(inData.toString(), path + String.valueOf(caseNum) + ".in");
        FileUtil.writeUtf8String(String.valueOf(res), path + String.valueOf(caseNum) + ".out");
        }


//        String path = "D:\\ZGZ\\labuladong\\java-letcode\\src\\main\\java\\codeContest\\str2NumTestCase\\";
//        int caseNum = i;
//        FileUtil.writeUtf8String(arr, path + String.valueOf(caseNum) + ".in");
//        FileUtil.writeUtf8String(String.valueOf(res), path + String.valueOf(caseNum) + ".out");


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
