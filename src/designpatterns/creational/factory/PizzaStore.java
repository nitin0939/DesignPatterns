package designpatterns.creational.factory;

/**
 * Creator (abstract) in the Factory Method pattern.
 * Contains the core order-taking logic that depends on a {@link Pizza},
 * without knowing which concrete style of pizza will actually be created.
 */
public abstract class PizzaStore {

    /**
     * Client-facing operation that uses the product returned by the factory method.
     * This method never changes; only the pizza returned by {@link #createPizza(String)} varies.
     */
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * The Factory Method. Subclasses override this to decide which concrete
     * {@link Pizza} implementation gets instantiated for a given {@code type}.
     */
    protected abstract Pizza createPizza(String type);
}
