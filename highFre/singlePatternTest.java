package highFre;

public class singlePatternTest {
    public static void main(String[] args) {
        //饿汉模式
        singlePattern s1 = singlePattern.getInstance();
        singlePattern s2 = singlePattern.getInstance();
        if (s1 == s2) {
            System.out.println("s1和s2是同一个实例");
        } else {
            System.out.println("s1和s2不是同一个实例");
        }

        //懒汉模式
        singlePattern2 s3 = singlePattern2.getInstance();
        singlePattern2 s4 = singlePattern2.getInstance();
        if (s3 == s4) {
            System.out.println("s3和s4是同一个实例");
        } else {
            System.out.println("S3和s4不是同一个实例");
        }
    }
}
