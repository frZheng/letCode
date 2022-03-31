package offer;

  //web https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof






public class  shuZhiDeZhengShuCiFangLcof {
    private static class Solution {

        public Solution() {
        }
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if(n == -1) return 1 / x;
            double half = myPow(x, n / 2);
            double mod = myPow(x, n % 2);
            return half * half * mod;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();


        double sum = solution.myPow(2.0,-2);
        System.out.println(sum);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
