package highFre;

// 饿汉模式
public class singlePattern {


    //1.将构造方法私有化，不允许外部直接创建对象
    private singlePattern() {
    }

    //2.创建类的唯一实例，使用private static修饰
    private static singlePattern instance = new singlePattern();

    //3.提供一个用于获取实例的方法，使用public static修饰
    public static singlePattern getInstance() {
        return instance;
    }
}
