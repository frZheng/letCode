package offer;

//web https://leetcode-cn.com/problems/qiu-12n-lcof

public class qiu12nLcof {
    private static class Solution {

        public Solution() {
        }


        public int sumNums(int n) {
            return n*(n+1)/2;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int price = 9;
        int lists = solution.sumNums(price);
        System.out.println(lists);

    }

}
