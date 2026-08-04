package designpatterns.creational.builder;

/**
 * Client class that demonstrates the Builder pattern.
 * Reuses the same {@link Barista} recipe with two different concrete
 * {@link OrderBuilder}s to produce two entirely different products.
 */
public class TestBuilder {

    /**
     * Builds a dark-roast-with-whip order both as a real {@link Beverage} and
     * as its printed {@link Receipt}, using the same
     * {@link Barista#constructDarkRoastWithWhip(OrderBuilder)} steps for both.
     */
    public static void main(String[] args) {
        Barista barista = new Barista();

        BeverageBuilder beverageBuilder = new BeverageBuilder();
        barista.constructDarkRoastWithWhip(beverageBuilder);

        Beverage beverage = beverageBuilder.getResult();
        System.out.printf("Beverage made: %s (%s) - $%.2f%n",
                beverage.getName(), beverage.getSize(), beverage.getPrice());

        ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        barista.constructDarkRoastWithWhip(receiptBuilder);
        Receipt receipt = receiptBuilder.getResult();
        System.out.println("\nReceipt printed:\n" + receipt.print());
    }
}
