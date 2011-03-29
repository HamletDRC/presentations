package inspections;

public class _01Example {

    private static long count = 0L;

    public synchronized void increment() {
        count++;
    }
}
