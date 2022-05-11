package top100;


 //web https://leetcode.cn/problems/longest-consecutive-sequence


import java.util.*;

public class  longestConsecutiveSequence {
    private static class Solution {

        public Solution() {
        }


        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }





    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {100,4,200,1,3,2};
        int lists = solution.longestConsecutive(arr);
        System.out.println(lists);

    }

}
