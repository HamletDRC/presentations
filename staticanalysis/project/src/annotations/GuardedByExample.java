package annotations;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.Immutable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Immutable
public class GuardedByExample {

    private final Object lock = new Object();

    @GuardedBy("lock")
    private final List<Object> myList = new ArrayList<Object>();

    public Object getElement(int index) {
        synchronized (lock) {
            return myList.get(index);
        }
    }

    public void addElement(Object e) {
        synchronized (lock) {
            myList.add(e);
        }
    }
}
