package designpatterns.creational.factory;

/**
 * Concrete Creator in the Factory Method pattern.
 * Overrides the factory method to produce New York style pizzas.
 */
public class NYPizzaStore extends PizzaStore {

    /**
     * @return a new {@link NYStyleCheesePizza} for {@code "cheese"}, or {@code null} for
     * any type this store doesn't carry.
     */
    @Override
    protected Pizza createPizza(String type) {
        if ("cheese".equalsIgnoreCase(type)) {
            return new NYStyleCheesePizza();
        }
        return null;
    }
}
