package designpatterns.creational.factory;

/**
 * Concrete Creator in the Factory Method pattern.
 * Overrides the factory method to produce Chicago style pizzas.
 */
public class ChicagoPizzaStore extends PizzaStore {

    /**
     * @return a new {@link ChicagoStyleCheesePizza} for {@code "cheese"}, or {@code null}
     * for any type this store doesn't carry.
     */
    @Override
    protected Pizza createPizza(String type) {
        if ("cheese".equalsIgnoreCase(type)) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}
