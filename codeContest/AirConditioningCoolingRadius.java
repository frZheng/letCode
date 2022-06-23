package codeContest;

import cn.hutool.core.io.FileUtil;

import java.util.Arrays;

// https://leetcode.cn/problems/heaters/solution/gong-nuan-qi-by-leetcode-solution-rwui/
// 夏季已经来临。你的任务是设计一个有固定制冷半径的空调向所有工位制冷。
//在空调的制冷半径范围内的每个工位都可以获得制冷。
//现在，给出位于一条水平线上的工位和空调的位置，请你找出并返回可以覆盖所有工位的最小制冷半径。
//说明：所有空调都遵循你的半径标准，制冷的半径也一样。

// 示例 1：
//输入： houses = [1,2,3], heaters = [2]
//输出： 输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。

//示例 2：
//输入：houses = [1,2,3,4], heaters = [1,4]
//输出：1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。

//示例 3：
//输入：houses = [1,5], heaters = [2]
//输出：3


public class AirConditioningCoolingRadius {



    static public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }



    public static void main(String[] args) {

//        int[] houses = {1,2,3};
//        int[] heaters = {2};
//        int caseNum = 1;
//        int[] houses = {1,2,3,4};
//        int[] heaters = {1,4};
//        int caseNum = 2;
//        int[] houses = {1,5};
//        int[] heaters = {2};
//        int caseNum = 3;

//        int[] houses = {10,20,30,80};
//        int[] heaters = {45,60};
//        int caseNum = 4;

//        int[] houses = {1,5,30,80};
//        int[] heaters = {2,60};
//        int caseNum = 5;

//        int[] houses = {1,5,5,80};
//        int[] heaters = {2,9};
//        int caseNum = 6;

//        int[] houses = {1,80,5,120};
//        int[] heaters = {130,9};
//        int caseNum = 7;

//        int[] houses = {1,80,5,120};
//        int[] heaters = {130,9,50,20,60,110};
//        int caseNum = 8;

//        int[] houses = {1,50,5,120};
//        int[] heaters = {4,9,50,5,60,110};
//        int caseNum = 9;

        int[] houses = {1,50,5,846};
        int[] heaters = {4,786,467,786,45,110};
        int caseNum = 10;


        int res = findRadius(houses,heaters);
        System.out.println(res);
        String path = "D:\\ZGZ\\labuladong\\java-letcode\\src\\main\\java\\codeContest\\AirConditioningCoolingRadiusTestCase\\";

        String inPath = path + String.valueOf(caseNum) + ".in";
        FileUtil.writeUtf8String(String.valueOf(houses.length), inPath);
        FileUtil.appendUtf8String("\n",inPath);
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < houses.length; ++i) {
            msg.append(houses[i]);

            if (i < houses.length-1) {
                msg.append(" ");
            }
        }
        FileUtil.appendUtf8String(msg.toString(), inPath);
        FileUtil.appendUtf8String("\n", inPath);

        FileUtil.appendUtf8String(String.valueOf(heaters.length), inPath);
        FileUtil.appendUtf8String("\n",inPath);
        StringBuilder msg1 = new StringBuilder();
        for (int i = 0; i < heaters.length; ++i) {
            msg1.append(heaters[i]);

            if (i < heaters.length-1) {
                msg1.append(" ");
            }
        }
        FileUtil.appendUtf8String(msg1.toString(), inPath);

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
