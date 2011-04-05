package functions.interceptor;

import functions.proxy.WithReadLock;
import functions.proxy.WithWriteLock;

import javax.interceptor.InvocationContext;
import javax.interceptor.AroundInvoke;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class WithLockInterceptor  {

    // This is shared!!!
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @AroundInvoke
    public Object enforceLock(InvocationContext context) throws Exception{
		try {
			Method targetMethod = context.getMethod();

			if (targetMethod.isAnnotationPresent(WithReadLock.class)) {
				lock.readLock().lock();
				try {
					return context.proceed();
				} finally {
					lock.readLock().unlock();
				}
			} else if (targetMethod.isAnnotationPresent(WithWriteLock.class)){
				lock.writeLock().lock();
				try {
					//reload the resources into memory
                    return context.proceed();
				} finally {
					lock.writeLock().unlock();
				}
			}
            return context.proceed();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
    }
}
