package domain;

public class WarehouseImpl implements Warehouse {

    private Integer id;

    public WarehouseImpl(DataSource ds) {}

    public Integer getID() {
        return id; 
    }

    public void save() {
        System.out.println("Save called for warehouse: " + getID());
    }
}
