public class Father {



    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.hashCode());
        Long i11 = 3l;
        Long i22 = 3l;
        System.out.println(i11 == i22);// 输出 false
//        Father father = new Father();
//        Child child = new Child();
//        try {
//            father.test();
//            child.test();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }
//    public void test() throws RuntimeException{
//        System.out.println("father");
//    }
//    static class Child extends Father{
//        @Override
//        public void test() throws Exception {
//            System.out.println("child");
//        }
//    }
}
