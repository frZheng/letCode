package offer;


import list.ListNode;



//web https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof

public class xuanZhuanShuZuDeZuiXiaoShuZiLcof {

    private static class Solution {

        public Solution() {
        }
        public int minArray(int[] numbers) {
            int minVal = Integer.MAX_VALUE;
            for (int i:numbers) {
                minVal = minVal > i? i: minVal;
            }
            return minVal;
        }

	}
	public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] array = {3,4,5,1,2};
        int fib = solution.minArray(array);
        System.out.println(fib);

    }
}
