package fluency.generics;

import java.util.Currency;

public class Order {

    private final String itemName;
    private final int quantity;
    private final Currency currency;

    public Order(OrderBuilder<OK, OK> builder) {
        itemName = builder.getItemName();
        quantity = builder.getQuantity();
        if (builder.getCurrency() == null) {
            currency = Currency.getInstance("USD");
        } else {
            currency = builder.getCurrency();
        }
    }

    public boolean pay() {
        System.out.printf(
                "paying in %s for %s %s \n",
                currency.getDisplayName(),
                quantity,
                itemName);
        return true;
    }


    public static void main(String[] args) {
        new Order(
                OrderBuilder.newInstance()
                        .initItemName("latte")
                        .initQuantity(10)
                        .withCurrency(Currency.getInstance("CHF"))
        ).pay();

        // order of method calls does not matter
        new Order(
                OrderBuilder.newInstance()
                        .initItemName("latte")
                        .withCurrency(Currency.getInstance("CHF"))
                        .initQuantity(10)
        ).pay();


        // forgetting a required arg results in unusable type
        OrderBuilder<OK, NOK> x = OrderBuilder.newInstance()
                .withCurrency(Currency.getInstance("CHF"))
                .initItemName("latte");

        // forgetting required args is a compile error
//        new Order(
//                OrderBuilder.newInstance()
//                        .initItemName("latte")
//                        .withCurrency(Currency.getInstance("CHF")
//        ));
    }
}
