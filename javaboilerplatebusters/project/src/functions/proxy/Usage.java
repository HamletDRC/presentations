package functions.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

class Usage {

    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new ResourceController(new DefaultResourceProvider());

        ResourceProvider provider = (ResourceProvider) Proxy.newProxyInstance(
                DefaultResourceProvider.class.getClassLoader(),
                new Class[]{ResourceProvider.class},
                handler);

        provider.refresh();
        provider.getResource("property");
    }
}
    

