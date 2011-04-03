package functions.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ResourceController {
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	public <T> T withReadLock(Callable<T> block) throws Exception {
		lock.readLock().lock();
		try {
			System.out.println("Begin read");
            T x = block.call();
            System.out.println("end read");
            return x;
		} finally {
			lock.readLock().unlock();
		}
	}

	public <T> T withWriteLock(Callable<T> block) throws Exception {
		lock.writeLock().lock();
		try {
			//reload the resources into memory
			System.out.println("Begin write");
            T x = block.call();
            System.out.println("end write");
            return x;
		} finally {
			lock.writeLock().unlock();
		}
	}
}
