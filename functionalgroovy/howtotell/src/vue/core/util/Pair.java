package vue.core.util;


public class Pair<T, U> {

    private final T left;
    private final U right;

    public Pair(T left, U right) {
        this.left = left;
        this.right = right;
    }

    T getLeft() { return left; }
    U getRight() { return right; }

    static <T, U> Pair from(T left, U right) {
        return new Pair<T, U>(left, right);
    }
}
