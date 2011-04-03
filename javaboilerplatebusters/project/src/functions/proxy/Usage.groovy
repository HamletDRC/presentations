package functions.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

InvocationHandler handler = new ResourceController(new DefaultResourceProvider());

ResourceProvider provider = (ResourceProvider) Proxy.newProxyInstance(
        DefaultResourceProvider.class.getClassLoader(),
        [ ResourceProvider.class ] as Class[],
        handler);

provider.refresh();
provider.getResource("foo");