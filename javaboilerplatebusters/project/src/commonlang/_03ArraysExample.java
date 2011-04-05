package commonlang;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

class _03ArraysExample {

    public static void main(String[] args) {

        int[] evens = new int[]{2, 4, 6};
        int[] odds = new int[]{1, 3, 5};

        assert ArrayUtils.contains(evens, 2);
        assert ArrayUtils.contains(odds, 3);

        assert Arrays.equals(
                new int[]{2, 4, 6, 8},
                ArrayUtils.add(evens, 8)
        );
        assert Arrays.equals(
                new int[]{2, 4, 6, 1, 3, 5},
                ArrayUtils.addAll(evens, odds)
        );

        assert Arrays.equals(
                new int[]{2, 6},
                ArrayUtils.remove(evens, 1)
        );
        assert Arrays.equals(
                new int[]{1, 3},
                ArrayUtils.remove(odds, 2)
        );

        System.out.println("Success");
    }
}
