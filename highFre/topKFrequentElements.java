package highFre;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//web https://leetcode-cn.com/problems/top-k-frequent-elements
public class topKFrequentElements {
    private static class Solution {

        public Solution() {
        }
        public int[] topKFrequent(int[] nums, int k) {
            int[] result = new int[k];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            // 根据map的value值正序排，相当于一个小顶堆
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());


            for (Map.Entry<Integer, Integer> entry : entries) {
                queue.add(entry); //相当于odder
                // 优先队列自带排序, 如果满了, 就把最小的弹出
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            for (int i = k - 1; i >= 0; i--) {
                result[i] = queue.poll().getKey();
            }
            return result;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        Solution solution = new Solution();
        int[] res = solution.topKFrequent(arr, 2);

        for (int i : res) {
            System.out.print(i + "\t");
        }
    }
}
