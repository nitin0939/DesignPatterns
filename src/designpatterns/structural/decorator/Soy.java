package designpatterns.structural.decorator;

/**
 * Concrete Decorator in the Decorator pattern.
 * Wraps a {@link Beverage} and adds soy's cost and description on top of it.
 */
public class Soy extends CondimentDecorator {
    private final Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    /**
     * Delegates to the wrapped beverage's cost, then adds soy's own cost on top.
     */
    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}
