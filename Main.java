import java.util.*;


public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        int n = Integer.parseInt(next);

        StringBuilder data = new StringBuilder();
        next = sc.nextLine();
        String[] s = next.split(" ");
        for (int i = 0; i < n; ++i) {
            data.append(s[i]);
        }

        int radius = romanToInt(data.toString());
        System.out.println(radius);
    }
}
