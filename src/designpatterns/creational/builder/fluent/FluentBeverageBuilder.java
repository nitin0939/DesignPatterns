package designpatterns.creational.builder.fluent;

import designpatterns.creational.builder.Beverage;
import designpatterns.creational.builder.Size;

import java.util.ArrayList;
import java.util.List;

/**
 * Fluent (chained-setter) alternative to
 * {@link designpatterns.creational.builder.BeverageBuilder}.
 * Each setter returns {@code this}, so calls can be chained directly into a
 * single expression instead of needing a separate {@code Barista} to sequence
 * them. Static factory methods ({@link #darkRoastWithWhip()},
 * {@link #houseBlendIced()}, {@link #espressoDouble()}) take over the role
 * the classic pattern's {@code Barista} played: encoding reusable recipes.
 */
public class FluentBeverageBuilder {
    private String name;
    private Size size;
    private final List<String> condiments = new ArrayList<>();

    /**
     * Sets the beverage name and returns this builder for chaining.
     */
    public FluentBeverageBuilder name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the cup size and returns this builder for chaining.
     */
    public FluentBeverageBuilder size(Size size) {
        this.size = size;
        return this;
    }

    /**
     * Adds a condiment and returns this builder for chaining.
     */
    public FluentBeverageBuilder condiment(String condiment) {
        this.condiments.add(condiment);
        return this;
    }

    /**
     * Terminal operation: assembles the accumulated parts into a finished {@link Beverage}.
     */
    public Beverage build() {
        return new Beverage(name, size, condiments);
    }

    /**
     * Pre-configured recipe equivalent to {@code Barista.constructDarkRoastWithWhip}:
     * grande dark roast with whip.
     */
    public static FluentBeverageBuilder darkRoastWithWhip() {
        return new FluentBeverageBuilder()
                .name("Dark Roast")
                .size(Size.GRANDE)
                .condiment("Whip");
    }

    /**
     * Pre-configured recipe equivalent to {@code Barista.constructHouseBlendIced}:
     * venti iced house blend.
     */
    public static FluentBeverageBuilder houseBlendIced() {
        return new FluentBeverageBuilder()
                .name("House Blend")
                .size(Size.VENTI)
                .condiment("Ice");
    }

    /**
     * Pre-configured recipe equivalent to {@code Barista.constructEspressoDouble}:
     * plain tall espresso, no condiments.
     */
    public static FluentBeverageBuilder espressoDouble() {
        return new FluentBeverageBuilder()
                .name("Espresso")
                .size(Size.TALL);
    }
}
