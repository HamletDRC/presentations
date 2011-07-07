package fluency.generics;

import java.util.Currency;

public class OrderBuilder<NAME, QUANTITY> {

    // required fields
    private String itemName;
    private int quantity;

    // optional fields
    private Currency currency;

    private OrderBuilder() {
    }

    public static OrderBuilder<NOK, NOK> newInstance() {
        return new OrderBuilder<>();
    }

    public OrderBuilder(String itemName, int quantity, Currency currency) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.currency = currency;
    }

    public OrderBuilder<OK, QUANTITY> initItemName(String name) {
        itemName = name;
        return new OrderBuilder<>(name, quantity, currency);
    }

    public OrderBuilder<NAME, OK> initQuantity(int quantity) {
        this.quantity = quantity;
        return new OrderBuilder<>(itemName, quantity, currency);
    }

    public OrderBuilder<NAME, QUANTITY> withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }
}
