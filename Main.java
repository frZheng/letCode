import java.util.*;


public class Main {
    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('A', 1);
        put('B', 5);
        put('C', 10);
        put('D', 50);
        put('E', 100);
        put('F', 500);
        put('G', 1000);
    }};

    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }


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
