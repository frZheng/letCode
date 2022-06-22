package codeContest;


import java.util.Scanner;

// 题目要求
public class reverList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        String[] s = next.split(" ");
        int size = s.length;
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < size; ++i){
//            System.out.println(s[size - 1 - i]);
            msg.append(s[size - 1 - i]);
            if (i < size - 1)
                msg.append(" ");
        }
        System.out.print(msg.toString());
    }
}
