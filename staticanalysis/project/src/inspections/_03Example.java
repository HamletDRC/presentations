package inspections;


import java.util.concurrent.locks.ReentrantLock;

public class _03Example {

    private final ReentrantLock lock = new ReentrantLock();
    private boolean active = false;

    public boolean isActive() throws Exception {
        lock.lock();
        boolean result = active;
        lock.unlock();
        return result;
    }

    public void activate() {
        lock.lock();
        active = true;
        lock.unlock();
    }
}
