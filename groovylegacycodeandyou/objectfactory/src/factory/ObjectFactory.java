package factory;

import domain.User;
import domain.DataSource;
import domain.Warehouse;
import domain.WarehouseImpl;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;

public class ObjectFactory {

    private Map<Class, Class> classToType = new HashMap<Class, Class>() {{
        put(User.class, User.class);
        put(Warehouse.class, WarehouseImpl.class);
    }};
    
    private DataSource datasource;

    public <T> T make(Class<T> clazz) {
        try {
            Class type = classToType.get(clazz);
            if (type == null) throw new RuntimeException("Type not found: " + clazz); 
            Constructor constructor = type.getConstructor(DataSource.class);
            if (constructor == null) throw new RuntimeException("Constructor not found: " + clazz); 
            return clazz.cast(constructor.newInstance(datasource));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
