package factory;

import domain.User;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

public class SpringObjectFactory {

    private XmlBeanFactory factory = new XmlBeanFactory(
            new ClassPathResource("objectFactory.sping.xml")
    );
    
    public <T> T make(Class<T> clazz) {
        Map<String,T> beanMap = factory.getBeansOfType(clazz);
        if (beanMap.isEmpty()) throw new RuntimeException("No beans found of type: " + clazz);
        if (beanMap.size() > 1) throw new RuntimeException("Too many beans found: " + beanMap.keySet());
        return beanMap.values().iterator().next();  
    }
}
