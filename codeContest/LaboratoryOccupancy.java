package codeContest;

import cn.hutool.core.io.FileUtil;

import java.util.Arrays;

// https://blog.csdn.net/Childhood_Sweetheart/article/details/120917835
// 给定一个实验室时间安排的数组，每个实验时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，请你判断一个人是否能够参加这里面的全部实验。
// 示例 1：
//输入： [[0,30],[5,10],[15,20]]
//输出： false

//示例 2：
//输入：[[7,10],[2,4]]
//输出：true


public class LaboratoryOccupancy {


    //会议室 1
    static int canAttendMeetings(int[][] intervals){
        if(intervals.length <=1){
            return 1;
        }
        //先将会议数组按照开始的时间进行排序
        Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
        for(int i=0; i<intervals.length-1; i++){
            //如果后面一个会议的开始时间小于前面一个会议的结束时间，则此人不能参加全部的会议
            if(intervals[i][1]>intervals[i+1][0]){
                return 0;
            }
        }
        return 1;
    }


    public static void main(String[] args) {

//        int[][] intervals = new int[3][2];
//        intervals[0][0] = 0;
//        intervals[0][1] = 30;
//        intervals[1][0] = 5;
//        intervals[1][1] = 10;
//        intervals[2][0] = 15;
//        intervals[2][1] = 20;

//        [[7,10],[2,4]]
//        int[][] intervals = new int[2][2];
//        intervals[0][0] = 7;
//        intervals[0][1] = 10;
//        intervals[1][0] = 2;
//        intervals[1][1] = 4;
//        int caseNum = 2;

//        int[][] intervals = new int[2][2];
//        intervals[0][0] = 8;
//        intervals[0][1] = 5;
//        intervals[1][0] = 4;
//        intervals[1][1] = 4;
//        int caseNum = 3;

//        int[][] intervals = new int[2][2];
//        intervals[0][0] = 2;
//        intervals[0][1] = 5;
//        intervals[1][0] = 6;
//        intervals[1][1] = 4;
//        int caseNum = 4;

//        int[][] intervals = new int[2][2];
//        intervals[0][0] = 4;
//        intervals[0][1] = 5;
//        intervals[1][0] = 0;
//        intervals[1][1] = 4;
//        int caseNum = 5;

//        int[][] intervals = new int[2][2];
//        intervals[0][0] = 4;
//        intervals[0][1] = 5;
//        intervals[1][0] = 4;
//        intervals[1][1] = 5;
//        int caseNum = 6;

//        int[][] intervals = new int[2][2];
//        intervals[0][0] = 5;
//        intervals[0][1] = 4;
//        intervals[1][0] = 4;
//        intervals[1][1] = 5;
//        int caseNum = 7;

//        int[][] intervals = new int[2][2];
//        intervals[0][0] = 1;
//        intervals[0][1] = 2;
//        intervals[1][0] = 4;
//        intervals[1][1] = 5;
//        int caseNum = 8;

        int[][] intervals = new int[2][2];
        intervals[0][0] = 8;
        intervals[0][1] = 10;
        intervals[1][0] = 0;
        intervals[1][1] = 30;
        int caseNum = 9;

        int res = canAttendMeetings(intervals);
        System.out.println(res);
        String path = "D:\\ZGZ\\labuladong\\java-letcode\\src\\main\\java\\codeContest\\LaboratoryOccupancyTestCase\\";

        String inPath = path + String.valueOf(caseNum) + ".in";
        FileUtil.writeUtf8String(String.valueOf(intervals.length), inPath);
        FileUtil.appendUtf8String("\n",inPath);
        for (int i = 0; i < intervals.length; ++i) {
            StringBuilder msg = new StringBuilder();
            for (int j = 0; j < intervals[i].length; ++j) {
                msg.append(intervals[i][j]);
                if (j < intervals[i].length-1)
                    msg.append(" ");
            }

            FileUtil.appendUtf8String(msg.toString(),inPath);
            if (i < intervals.length-1) {
                FileUtil.appendUtf8String("\n",inPath);
            }
        }

        FileUtil.writeUtf8String(String.valueOf(res), path + String.valueOf(caseNum) + ".out");
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
