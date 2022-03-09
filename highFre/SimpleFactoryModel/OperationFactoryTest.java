package highFre.SimpleFactoryModel;

public class OperationFactoryTest {
    public static void main(String[] args) throws Exception {
        //加法
        Addpend(1,1);
        //减法
        Subtract(1,1);
        //乘法
        Multiply(1,1);
        //除法
        Divide(1,1);
    }
    public static void Addpend(double number1,double number2) throws Exception {
        String add = "+";
        Operation Add = OperationFactory.createOperation(add);
        Add.setNumber1(number1);
        Add.setNumber2(number2);
        Double result = Add.getResult();
        System.out.println("加法："+result);
    }

    public static void Subtract(double number1,double number2) throws Exception {
        String sub = "-";
        Operation Sub = OperationFactory.createOperation(sub);
        Sub.setNumber1(number1);
        Sub.setNumber2(number2);
        Double result = Sub.getResult();
        System.out.println("减法："+result);
    }

    public static void Multiply(double number1,double number2) throws Exception {
        String mul = "*";
        Operation Mul = OperationFactory.createOperation(mul);
        Mul.setNumber1(number1);
        Mul.setNumber2(number2);
        Double result = Mul.getResult();
        System.out.println("乘法："+result);
    }

    public static void Divide(double number1,double number2) throws Exception {
        String div = "/";
        Operation Div = OperationFactory.createOperation(div);
        Div.setNumber1(number1);
        Div.setNumber2(number2);
        Double result = Div.getResult();
        System.out.println("除法："+result);
    }
}

