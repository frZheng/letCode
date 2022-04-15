package offer;

 //web https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof


import java.util.HashMap;

public class  ngeTouZiDeDianShuLcof {
    private static class Solution {

        public Solution() {
        }
        public double[] dicesProbability(int n) {
            int[][] dp=new int[n+1][6*n+1];
            double[] ans=new double[5*n+1];
            double all=Math.pow(6,n);
            for(int i=1;i<=6;i++)
                dp[1][i]=1;
            for(int i=1;i<=n;i++){
                for(int j=i;j<=6*n;j++){
                    for(int k=1;k<=6;k++){
                        dp[i][j]+=j>=k?dp[i-1][j-k]:0;
                        if(i==n)
                            ans[j-i]=dp[i][j]/all;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        double[] lists = solution.dicesProbability(10);
        for (double i : lists)
            System.out.println(i);

    }



}
