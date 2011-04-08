package factory;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import domain.User;
import domain.Warehouse;
import domain.WarehouseImpl;

public class SpringObjectFactoryTest {
    private SpringObjectFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new SpringObjectFactory();
    }

    @Test
    public void testUser() {
        User user = factory.make(User.class);
        Assert.assertNotNull(user);
        Assert.assertEquals(User.class, user.getClass());
    }

    @Test
    public void testWarehouse() {
        Warehouse warehouse = factory.make(Warehouse.class);
        Assert.assertNotNull(warehouse);
        Assert.assertEquals(WarehouseImpl.class, warehouse.getClass());
    }

}
