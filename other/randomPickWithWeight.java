package other;


import java.util.Arrays;

public class randomPickWithWeight {
    private static class Solution {
        int[] pre;
        int total;
        public Solution() {
        }
        public Solution(int[] w) {
            pre = new int[w.length];
            pre[0] = w[0];
            for (int i = 1; i < w.length; ++i) {
                pre[i] = pre[i - 1] + w[i];
            }
            total = Arrays.stream(w).sum();
//            for (int i : pre)
//                System.out.println(i);
        }
        public int pickIndex() {

            int x = (int) (Math.random() * total) + 1;
            return binarySearch(x);
        }
        private int binarySearch(int x) {
            int low = 0, high = pre.length - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (pre[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
    public static void main(String Args[]) {
        int[] arr = {2,3,5,10};
        Solution solution = new Solution(arr);
        int res = solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
        System.out.println(res);
        res = solution.pickIndex(); // 返回 1
        System.out.println(res);
        res = solution.pickIndex(); // 返回 1
        System.out.println(res);
        res = solution.pickIndex(); // 返回 1
        System.out.println(res);
        res = solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
        System.out.println(res);

    }

}
