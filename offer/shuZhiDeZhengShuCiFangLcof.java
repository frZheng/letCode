package offer;

  //web https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof






public class  shuZhiDeZhengShuCiFangLcof {
    private static class Solution {

        public Solution() {
        }
        public double myPow(double x, int n) {
            if (x == 0.0) return 0.0;
            double sum = x;
            int flag = 1;
            if (n < 0) {
                flag = 0;
                n = -n;
            }
            for (int i = 1; i < n; ++i){
                sum*=x;
            }
            if(flag == 0) sum = 1/sum;
            return sum;
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
