package dataflow;



class Divide implements BinaryOperation {
    @Override
    public int apply(int left, int right) {
        return left / right;
    }
}
