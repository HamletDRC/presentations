package dataflow;


class OperationFactory {

    public static BinaryOperation create(String operation) {
        if ("+".equals(operation)) return new Add();
        if ("-".equals(operation)) return new Subtract();
        if ("/".equals(operation)) return new Divide();
        if ("*".equals(operation)) return new Multiply();
        return null;
    }
}
