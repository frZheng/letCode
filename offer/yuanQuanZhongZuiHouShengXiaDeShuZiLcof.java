package offer;
//web https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof


import java.util.ArrayList;
import java.util.List;

public class yuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    private static class Solution {

        public Solution() {
        }
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int idx = 0;
            while (n > 1) {
                idx = (idx + m - 1) % n;
                list.remove(idx);
                n--;
            }
            return list.get(0);
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        int b = solution.lastRemaining(5,3);
        System.out.println(b);
    }



}

