package com.canoo.cdi.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Transactional
@Interceptor
public class TransactionalInterceptor {
    @AroundInvoke
    public Object manageTransaction(InvocationContext ctx) throws Exception {
        System.out.println("Intercepted before: " + ctx.getParameters()[0] + "!!!");
        Object result = ctx.proceed();
        System.out.println("Intercepted after : " + ctx.getParameters()[0] + "!!!");
        return result;
    }
}

