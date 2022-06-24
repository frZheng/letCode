package codeContest;



import java.util.*;


public class Main {

    static int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int N = 1 << n; // 1 << n 等价于2^n
        int[] sum = new int[N];
        for(int i = 0; i < N; ++i){
            int sumcookies = 0; // 依次选取集合情况
            for(int j = 0; j < n; ++j){ // 判断里面是否有j号项目，加入到该集合的sum里
                if(((i >> j) & 1) == 1){
                    sumcookies += cookies[j];
                }
            }
            sum[i] = sumcookies;
        }
        int[][] dp = new int[k][N];
        for(int i = 1; i < k; ++i) {
            for (int j = 1; j < N; ++j) {
                dp[i][j] = 100000;
            }
        }
        dp[0] = sum;
        for(int i = 1; i < k; ++i){
            for(int j = 1; j < N; ++j){
                for(int s = j; s > 0; s = (s - 1) & j){ // 枚举j的子集s
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][j ^ s], sum[s]));
                }
            }
        }
        return dp[k-1][N-1];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        int k = Integer.parseInt(next);
        next = sc.nextLine();
        int cookiesLen = Integer.parseInt(next);
        int[] cookies = new int[cookiesLen];
        next = sc.nextLine();
        String[] s = next.split(" ");
        for (int i = 0; i < cookiesLen; ++i) {
            cookies[i] = Integer.parseInt(s[i]);
        }

//        System.out.println(k);
//        System.out.println(cookiesLen);
//        StringBuilder msg = new StringBuilder();
//        for (int i = 0; i < cookiesLen; ++i) {
//            msg.append(cookies[i]);
//            msg.append(",");
//        }
//        System.out.println(msg);
        int radius = distributeCookies(cookies,k);
        System.out.println(radius);
    }
}
