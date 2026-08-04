package designpatterns.creational.builder;

/**
 * Builder interface in the Builder pattern.
 * Declares the step-by-step operations common to building any product variant
 * (a real {@link Beverage} or its printed {@link Receipt}), regardless of
 * which concrete builder assembles it.
 */
public interface OrderBuilder {

    /**
     * Sets the name of the beverage being ordered.
     */
    void setBeverageName(String name);

    /**
     * Sets the cup size.
     */
    void setSize(Size size);

    /**
     * Adds one condiment (e.g. "Whip", "Soy", "Ice") to the order.
     */
    void addCondiment(String condiment);
}
