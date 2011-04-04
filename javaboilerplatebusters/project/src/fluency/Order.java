package fluency;


import java.util.Currency;

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

    public static void main(String[] args) {

        Order order = new Order();
        order.setItemName("lattes");
        order.setQuantity(2);
        order.pay(Currency.getInstance("USD"));


    }
}