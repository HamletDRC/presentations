package dataflow;



class Subtract implements BinaryOperation {
    @Override
    public int apply(int left, int right) {
        return left - right;
    }
}
