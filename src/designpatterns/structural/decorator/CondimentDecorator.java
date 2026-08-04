package designpatterns.structural.decorator;

/**
 * Decorator (abstract) in the Decorator pattern.
 * Extends {@link Beverage} so a decorated beverage is still a {@code Beverage}
 * itself — that's what lets decorators wrap other decorators, stacking
 * arbitrarily many condiments onto one drink.
 */
public abstract class CondimentDecorator extends Beverage {

    /**
     * Every condiment must expose the description of the beverage it wraps,
     * so a chain of decorators can each prepend their own name to it.
     */
    public abstract String getDescription();
}
