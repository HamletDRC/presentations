package inspections;

public class Example04 {

    private static long count = 0L;

    public synchronized void increment() {
        count++;
    }
}
