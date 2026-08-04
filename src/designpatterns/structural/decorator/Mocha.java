package designpatterns.structural.decorator;

/**
 * Concrete Decorator in the Decorator pattern.
 * Wraps a {@link Beverage} and adds mocha's cost and description on top of it.
 */
public class Mocha extends CondimentDecorator {
    private final Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    /**
     * Delegates to the wrapped beverage's cost, then adds mocha's own cost on top.
     */
    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}
