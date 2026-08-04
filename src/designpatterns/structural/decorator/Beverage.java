package designpatterns.structural.decorator;

/**
 * Component in the Decorator pattern (Head First's Starbuzz Coffee example).
 * Both plain beverages and their decorated (condiment-wrapped) versions share
 * this interface, so a client can treat either one identically.
 */
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * Every beverage — plain or decorated — must be able to price itself.
     */
    public abstract double cost();
}
