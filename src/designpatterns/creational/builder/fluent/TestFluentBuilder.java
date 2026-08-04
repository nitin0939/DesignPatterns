package designpatterns.creational.builder.fluent;

import designpatterns.creational.builder.Beverage;
import designpatterns.creational.builder.Size;

/**
 * Client class demonstrating the fluent Builder alternative.
 * Contrasts with {@code TestBuilder}: no {@code Barista} object is needed —
 * chained calls (or the {@code darkRoastWithWhip()}/{@code houseBlendIced()}/
 * {@code espressoDouble()} recipes) replace it.
 */
public class TestFluentBuilder {

    /**
     * Builds one beverage via a pre-configured recipe and another via an
     * ad-hoc chain of setters, printing both.
     */
    public static void main(String[] args) {
        Beverage darkRoast = FluentBeverageBuilder.darkRoastWithWhip().build();
        System.out.printf("Beverage built via recipe: %s (%s) - $%.2f%n",
                darkRoast.getName(), darkRoast.getSize(), darkRoast.getPrice());

        Beverage customOrder = new FluentBeverageBuilder()
                .name("House Blend")
                .size(Size.TALL)
                .condiment("Soy")
                .condiment("Mocha")
                .build();
        System.out.printf("%nBeverage built via ad-hoc chain: %s (%s) - $%.2f%n",
                customOrder.getName(), customOrder.getSize(), customOrder.getPrice());
    }
}
