package designpatterns.structural.decorator;

/**
 * Concrete Decorator in the Decorator pattern.
 * Wraps a {@link Beverage} and adds whip's cost and description on top of it.
 */
public class Whip extends CondimentDecorator {
    private final Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    /**
     * Delegates to the wrapped beverage's cost, then adds whip's own cost on top.
     */
    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}
