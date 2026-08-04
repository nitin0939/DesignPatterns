package designpatterns.creational.builder;

import java.util.List;

/**
 * Product in the Builder pattern.
 * A complex, immutable object assembled part-by-part by a {@link OrderBuilder}
 * (typically {@link BeverageBuilder}) instead of through a single telescoping constructor.
 */
public class Beverage {
    private static final double BASE_PRICE = 1.99;
    private static final double CONDIMENT_PRICE = 0.20;

    private final String name;
    private final Size size;
    private final List<String> condiments;

    /**
     * Wires all pre-built parts together into a finished beverage.
     */
    public Beverage(String name, Size size, List<String> condiments) {
        this.name = name;
        this.size = size;
        this.condiments = condiments;
    }

    /**
     * Computes the price: a base price plus a per-condiment charge.
     */
    public double getPrice() {
        return BASE_PRICE + condiments.size() * CONDIMENT_PRICE;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public List<String> getCondiments() {
        return condiments;
    }
}
