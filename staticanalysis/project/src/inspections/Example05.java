package inspections;


public class Example05 {

    private boolean active = false;

    public boolean isActive() {
        return active;
    }

    public synchronized void activate() {
        active = true; 
    }
}
