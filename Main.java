import java.util.ArrayList;
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
class Animal{
    private String type;
    private String cry;
    public Animal(String type,String cry){
        this.type = type;
        this.cry = cry;
    }
    public String getType(){
        return type;
    }
}

public class Main {

    public static void transform(Animal a, Animal b){
        Animal temp = a;
        a = b;
        b = temp;
    }
    public static void transform(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        int a = 10,b=11;
        Animal cat = new Animal("cat", "miao miao");
        Animal dog = new Animal("dog", "wang wang");
        transform(a,b);
        transform(cat,dog);
        System.out.println("a=" + a + ",b=" + b);
        System.out.println("cat=" + cat.getType() + ",dog=" + dog.getType());
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.valueOf(sc.nextLine());
//        for (int i = 0; i< n;++i){
//
//            boolean flag = true;
//            int m = Integer.valueOf(sc.nextLine());
//            ArrayList<String> strings = new ArrayList<>(m);
//            for (int j = 0;j<m;++j){
//                String s = sc.nextLine();
//
//                for (int k=0;k<strings.size();++k){
//                    String s1 = strings.get(k);
//                    int minLen = Math.min(s1.length(),s.length());
//                    flag = true;
//                    for (int x=0;x<minLen;++x){
//                        if(s1.charAt(x)!=s.charAt(x))
//                        {
//                            flag=false;
//                        }
//                    }
//                    if(j>0 && flag){
//                        System.out.println("NO");
//                        break;
//                    }
//                }
//                if(j>0 && flag){
//                    break;
//                }
//
//                strings.add(s);
//
//            }
//            if (flag==false)
//                System.out.println("YES");

//        }
    }
}

