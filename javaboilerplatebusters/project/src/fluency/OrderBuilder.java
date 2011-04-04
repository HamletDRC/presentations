package fluency;


import java.util.Currency;

public class OrderBuilder {

    QuantityHolder withItem(String itemName) {
        return new QuantityHolder(itemName);
    }

    static class QuantityHolder {

        private final String itemName;

        public QuantityHolder(String itemName) {
            this.itemName = itemName;
        }

        OrderFiller withQuantity(int quantity) {
            return new OrderFiller(itemName, quantity); 
        }
    }

    static class OrderFiller {
        private final String itemName;
        private final int quantity;

        OrderFiller(String itemName, int quantity) {
            this.itemName = itemName;
            this.quantity = quantity;
        }

        boolean pay(Currency currency) {
            System.out.println("paying...");
            return true;
        }
    }

    public static void main(String[] args) {
        new OrderBuilder()
                .withItem("lattes")
                .withQuantity(2)
                .pay(Currency.getInstance("USD"));

    }
}
