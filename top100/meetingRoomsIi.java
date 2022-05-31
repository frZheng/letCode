package top100;

//web https://leetcode.cn/problems/meeting-rooms-ii


import java.util.*;

public class  meetingRoomsIi {
    private static class Solution {

        public Solution() {
        }
        public int minMeetingRooms(int[][] intervals) {
            // 先考虑特殊情况
            if (intervals == null || intervals.length == 0)
                return 0;
            // 从定义排序按照进入时间排序
            Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
            // 定义一个优先队列
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            // 一个计数器
            int meetingCount = 0;

            for (int[] meeting : intervals){
                //要是堆非空，当前会议的开始时间已经大于等于了最小的结束时间
                // 这里就是要把所有已经结束的会议淘汰出去
                while (!heap.isEmpty() && meeting[0] >= heap.peek()){
                    heap.poll();
                }
                // 再把当前会议的结束时间加进去
                heap.add(meeting[1]); // 堆里有的就是进行的会议的数量
                // 谈话不断的看是不是最大的
                meetingCount = Math.max(meetingCount, heap.size());
            }
            return meetingCount;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

//        int[] lists = solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        int[][] intervals = {
                {0,30},
                {5,10},
                {15,20}
        };

        int res = solution.minMeetingRooms(intervals);

        System.out.println(res);


    }
}
