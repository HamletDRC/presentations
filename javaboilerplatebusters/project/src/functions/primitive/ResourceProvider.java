package functions.primitive;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ResourceProvider {

	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Map<String, String> data = new HashMap<String, String>();

	public String getResource(String key) throws Exception {
		lock.readLock().lock();
		try {
			return data.get(key);
		} finally {
			lock.readLock().unlock();
		}
	}

	public void refresh() throws Exception {
		lock.writeLock().lock();
		try {
			System.out.println("Reloading settings...");
		} finally {
			lock.writeLock().unlock();
		}
	}
}
