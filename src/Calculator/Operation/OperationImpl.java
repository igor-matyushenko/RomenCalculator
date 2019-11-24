package Calculator.Operation;


public class OperationImpl implements Operation {


    @Override
    public int addition(int a, int b) {
        return a+b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a-b;
    }

    @Override
    public int multiplay(int a, int b) {
        return a*b;
    }

    @Override
    public float division(int a, int b) {
        return (float)a/b;
    }


}
