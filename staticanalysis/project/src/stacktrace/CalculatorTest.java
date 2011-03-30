package stacktrace;


public class CalculatorTest {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        assert 4 == calc.add(2, 2);
        assert 0 == calc.divide(2, 0);
    }
}
