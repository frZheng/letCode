package offer;

//web https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof



public class buYongJiaJianChengChuZuoJiaFaLcof {
    private static class Solution {

        public Solution() {
        }
        public int add(int a, int b) {
            if (a == 0)
                return b;

            int base = a ^ b;
            int up = a & b;

            return add(up << 1, base);
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();


//        String str = "3,4,5,1,2,null,null";


        int b = solution.add(1, 1);
        System.out.println(b);

    }



}
