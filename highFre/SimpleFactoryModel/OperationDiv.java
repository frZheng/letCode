package highFre.SimpleFactoryModel;


public class OperationDiv extends Operation {

    @Override
    public Double getResult() throws Exception {
        if (getNumber2()==0) {
            throw new ArithmeticException("除数不能为'0'!");
        }
        //super.getNumber1()+super.getNumber2();
        return getNumber1()/getNumber2();
    }

}
