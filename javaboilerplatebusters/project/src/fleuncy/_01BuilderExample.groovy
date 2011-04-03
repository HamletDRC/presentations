package fleuncy


class Order {
    private String itemName;
    private int quantity;

    boolean pay(Currency currency) {
        System.out.println("paying...");
        return true;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity; 
    }
}

Order order = new Order()
order.setItemName("lattes");
order.setQuantity(2);
order.pay(Currency.getInstance("USD"));


class FluentOrder {
    private String itemName;
    private int quantity;

    boolean pay(Currency currency) {
        System.out.println("paying...");
        return true;
    }

    public FluentOrder withItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public FluentOrder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}

new FluentOrder()
        .withItemName("lattes")
        .withQuantity(2)
        .pay(Currency.getInstance("USD"));

