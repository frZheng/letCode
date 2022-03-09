package highFre.SimpleFactoryModel;


/**
 * 简单运算工厂类
 */
public class OperationFactory {
    public static Operation oper = null;

    public static Operation createOperation(String operator) {
        //根据传入的运算符生产出相对应的运算对象
        switch (operator) {
            case "+":
                oper=new OperationAdd();
                break;
            case "-":
                oper=new OperationSub();
                break;
            case "*":
                oper=new OperationMul();
                break;
            case "/":
                oper=new OperationDiv();
                break;
            default:
                break;
        }
        return oper;
    }
}