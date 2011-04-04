package functions.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ResourceController implements InvocationHandler {

	private final Object target;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	ResourceController(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) {
		try {

			//try to find the method on the target
			Method targetMethod = target.getClass().getMethod(
				method.getName(),
				method.getParameterTypes());

			if (targetMethod.isAnnotationPresent(WithReadLock.class)) {
				lock.readLock().lock();
				try {
					System.out.println("Begin read");
                    Object x = targetMethod.invoke(target, args);
                    System.out.println("end read");
                    return x;
				} finally {
					lock.readLock().unlock();
				}
			} else if (targetMethod.isAnnotationPresent(WithWriteLock.class)){
				lock.writeLock().lock();
				try {
					//reload the resources into memory
					System.out.println("Begin write");
                    Object x = targetMethod.invoke(target, args);
                    System.out.println("end write");
                    return x;
				} finally {
					lock.writeLock().unlock();
				}
			} else {
				return targetMethod.invoke(target, args);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
