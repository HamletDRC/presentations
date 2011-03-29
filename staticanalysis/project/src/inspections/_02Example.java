package inspections;


public class _02Example {

    private boolean active = false;

    public boolean isActive() {
        return active;
    }

    public synchronized void activate() {
        active = true; 
    }
}
