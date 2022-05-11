package top100;


 //web https://leetcode.cn/problems/longest-consecutive-sequence


import java.util.*;

public class  longestConsecutiveSequence {
    private static class Solution {

        public Solution() {
        }


//        public int longestConsecutive(int[] nums) {
//            Set<Integer> num_set = new HashSet<Integer>();
//            for (int num : nums) {
//                num_set.add(num);
//            }
//
//            int longestStreak = 0;
//
//            for (int num : num_set) {
//                if (!num_set.contains(num - 1)) {
//                    int currentNum = num;
//                    int currentStreak = 1;
//
//                    while (num_set.contains(currentNum + 1)) {
//                        currentNum += 1;
//                        currentStreak += 1;
//                    }
//
//                    longestStreak = Math.max(longestStreak, currentStreak);
//                }
//            }
//
//            return longestStreak;
//        }

    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        UF uf = new UF(nums.length);

        for (int i = 0; i < nums.length; i++) {
            // 存在重复元素，跳过
            if (map.containsKey(nums[i])) continue;

            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
            map.put(nums[i], i);
        }
        return uf.getMaxConnectSize();
    }

   private class UF {
        private int[] parent;
        private int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            // 注意 别写反了
            size[rootQ] += size[rootP];
        }
        // get root id
        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public int getMaxConnectSize() {
            int maxSize = 0;
            for (int i = 0; i < parent.length; i++) {
                if (i == parent[i]) {
                    maxSize = Math.max(maxSize, size[i]);
                }
            }
            return maxSize;
        }

    }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {100,4,200,1,3,2};
        int lists = solution.longestConsecutive(arr);
        System.out.println(lists);

    }

}
