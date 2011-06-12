package java7;

public class _03StringsInSwitchExample {

    static class Calculator {
        Number apply(int left, String operator, int right) {

            switch (operator) {
                case "plus": return left + right;
                case "minus": return left - right;
                case "times": return left * right;
                case "divided by": return left / right;
                default: throw new IllegalArgumentException(operator);
            }
        }
    }
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        assert calculator.apply(1, "plus", 2).equals(3);
        assert calculator.apply(5, "times", 2).equals(10);
        assert calculator.apply(5, "minus", 2).equals(3);

    }
}
