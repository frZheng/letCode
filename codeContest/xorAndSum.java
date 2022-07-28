package codeContest;

import java.util.Scanner;

public class xorAndSum {




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        int n = Integer.parseInt(next);
        next = sc.nextLine();
        String[] s = next.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(s[i]);
        }
//        int n = 3;
//        int[] arr = new int[n];
//        int[] arr = {1,2,3};

        int[] ontinuousSum = new int[1000+1];
//        for (int i =1; i < n; ++i) {
//            ontinuousSum[i] = arr[i];
//        }
//        int nums = 0;
        int res = arr[0];
        for (int i =0; i < n; ++i) {
            ontinuousSum[i+1] = arr[i];
            res ^= ontinuousSum[i+1];
            for (int j = 0; j < i; ++j) {
                ontinuousSum[j] = ontinuousSum[j] + i;
//                System.out.println(ontinuousSum[j]);
                res ^= ontinuousSum[j];
            }
//            ontinuousSum.add(arr[i]);
//            nums = i;
        }

        System.out.println(res);

    }
}
