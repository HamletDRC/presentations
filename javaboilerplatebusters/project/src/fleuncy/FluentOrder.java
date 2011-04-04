package fleuncy;

import java.util.Currency;

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

    public static void main(String[] args) {


        new FluentOrder()
                .withItemName("lattes")
                .withQuantity(2)
                .pay(Currency.getInstance("USD"));


    }
}