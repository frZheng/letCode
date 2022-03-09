package highFre;

public class singlePattern2 {
    public singlePattern2() {
    }
    //2.声明类的唯一实例，使用private static修饰
    private static singlePattern2 instance;

    //3.提供一个用于获取实例的方法，使用public static修饰
    public static synchronized singlePattern2 getInstance(){
        if(instance==null){
            instance=new singlePattern2();
        }
        return instance;
    }
}
