package dataflow;

class CalculatorFacade {
    int calculate(String operation, String left, String right) {
        BinaryOperation operationStrategy = OperationFactory.create(operation);
        int leftAsInt = Conversions.toInt(left);
        int rightAsInt = Conversions.toInt(right);
        return operationStrategy.apply(leftAsInt, rightAsInt);
    }

    int calculate(String operation, Float left, Float right) {
        BinaryOperation operationStrategy = OperationFactory.create(operation);
        int leftAsInt = Conversions.toInt(left);
        int rightAsInt = Conversions.toInt(right);
        return operationStrategy.apply(leftAsInt, rightAsInt);
    }
}
