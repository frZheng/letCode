import java.util.Scanner;

/*
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346

1
3
911
97625999
91125426

1
5
113
12340
123440
12345
98346
 */
public class xunlei03 {

    public static int fun(int target, int max){
        int t = target;
        int M = max;
        int cun=0;
        while(t!=1){
            if (t%2==1){
                t-=1;
                cun++;
            }
            if(M!=0){
                t/=2;
                M--;
                cun++;
            }
            if (M==0){
                cun=cun+t-1;
                t=(t-t+1);
            }
        }
        return cun;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int n = Integer.valueOf(s[0]);
        int maxTime = Integer.valueOf(s[1]);
        System.out.println(fun(n, maxTime));
    }
}

