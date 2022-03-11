package offer;

 //web https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof

public class guPiaoDeZuiDaLiRunLcof {
    private static class Solution {

        public Solution() {
        }

        public int maxProfit(int[] prices) {
            int profit = 0;
//            if (prices.length == 1 || prices == null) return 0;
            if (prices.length == 0) return 0;
            int min = prices[0];

            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] < min){
                    min = prices[i];
                }
                else
                    profit = Math.max(prices[i] - min, profit);

            }
            return profit;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] price = {7,6,4,3,1};
        int lists = solution.maxProfit(price);
        System.out.println(lists);

    }

}
