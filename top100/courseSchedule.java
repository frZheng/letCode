package top100;

//web https://leetcode.cn/problems/course-schedule


import java.util.*;

public class   courseSchedule {
    private static class Solution {

        public Solution() {
        }




        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> edges;
            int[] indeg;
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            indeg = new int[numCourses];//有多少个课程依赖本课
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            int visited = 0;
            while (!queue.isEmpty()) {
                ++visited;
                int u = queue.poll();
                for (int v: edges.get(u)) {
                    --indeg[v];
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            return visited == numCourses;
        }




    }


    public static void main(String[] Args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        boolean s = solution.canFinish(numCourses,prerequisites);
        System.out.println(s);

    }
}
