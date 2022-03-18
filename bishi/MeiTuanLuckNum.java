package bishi;
//import java.text.ParseException;
import java.util.Scanner;

public class MeiTuanLuckNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        while(sc.hasNextLine()) {

//        while(true){
        int numOfInput = sc.nextInt();
        for(int k = 0; k <numOfInput; ++k){
            int N = sc.nextInt();
            int beishu = 0;
            beishu = N / 11;
            boolean flag = true;
            int oneNum = 0;
            if ((N - beishu * 11) == 0) {
                flag = false;
            }
            else {
                while(N > 0) {
                    int a = N%10;
                    if (a == 1) {
                        oneNum++;
                        if (oneNum >= 2){
                            flag = false;
                            break;
                        }
                    }
                    N/=10;
                }
            }
            if (flag) {
                System.out.println("no");
            }
            else {
                System.out.println("yes");
            }
        }
    }
}