package backnotout;

import java.util.ArrayList;
import java.util.List;

public class MultipleRetValue {

    static Object[] getEvenNumbers(int bottom, int top) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int x = bottom; x <= top; x++) {
            if (x % 2 == 0) {
                result.add(x);
                count++;
            }
        }
        return new Object[] {result, count};
    }

    static ResultObj getEvenNumbers2(int bottom, int top) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int x = bottom; x <= top; x++) {
            if (x % 2 == 0) {
                result.add(x);
                count++;
            }
        }
        return new ResultObj(result, count);
    }

    static class ResultObj {

        private List<Integer> elements;
        private int count;

        public ResultObj(List<Integer> elements, int count) {
            this.elements = elements;
            this.count = count;
        }
    }

    static Pair<List<Integer>, Integer> getEvenNumbers3(int bottom, int top) {
        List<Integer> elements = new ArrayList<>();
        int count = 0;
        for (int x = bottom; x <= top; x++) {
            if (x % 2 == 0) {
                elements.add(x);
                count++;
            }
        }
        return Pair.from(elements, count);
    }


    static class Pair<T, U> {
        final T left;
        final U right;

        Pair(T left, U right) {
            this.left = left;
            this.right = right;
        }

        public T getLeft() {
            return left;
        }

        public U getRight() {
            return right;
        }
        static <T, U> Pair<T, U> from(T left, U right) {
            return new Pair<T, U>(left, right);
        }
    }
    public static void main(String[] args) {
        Object[] x = getEvenNumbers(5, 20);
        System.out.println("elements: " + x[0]);
        System.out.println("count: " + x[1]);

        ResultObj y = getEvenNumbers2(5, 20);
        System.out.println("elements: " + y.elements);
        System.out.println("count: " + y.count);

        Pair<List<Integer>, Integer> z = getEvenNumbers3(5, 20);
        List<Integer> elements = z.getLeft();
        Integer count = z.getRight();
        System.out.println("elements: " + elements);
        System.out.println("count: " + count);
    }
}
