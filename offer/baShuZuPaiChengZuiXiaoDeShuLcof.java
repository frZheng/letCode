package offer;

//web https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof

import java.util.ArrayList;
import java.util.List;

public class baShuZuPaiChengZuiXiaoDeShuLcof {
    private static class Solution {

        public Solution() {
        }

        public String minNumber(int[] nums) {
            List<String> list = new ArrayList<>();
            for (int num : nums) {
                list.add(String.valueOf(num));
            }
            list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            return String.join("", list);
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] arr = {3,30,34,5,9,1};//30,3,1,34,5,9
        String lists = solution.minNumber(arr);
        System.out.println(lists);

    }

}
