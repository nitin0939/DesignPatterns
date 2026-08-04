package designpatterns.creational.factory;

/**
 * Client class that demonstrates the Factory Method pattern.
 * Orders the same {@code "cheese"} pizza type from two different stores and
 * lets each store's factory method decide which regional style gets made.
 */
public class TestFactoryMethod {

    public static PizzaStore store;

    /**
     * Configures the desired store and orders a pizza from it.
     */
    public static void main(String[] args) {
        configure("NY");
        Pizza nyPizza = store.orderPizza("cheese");
        System.out.println("Ethan ordered a " + nyPizza.getName() + "\n");

        configure("Chicago");
        Pizza chicagoPizza = store.orderPizza("cheese");
        System.out.println("Joel ordered a " + chicagoPizza.getName() + "\n");
    }

    /**
     * Picks the concrete {@link PizzaStore} implementation based on the given city name.
     */
    static void configure(String city) {
        if ("NY".equalsIgnoreCase(city))
            store = new NYPizzaStore();
        else if ("Chicago".equalsIgnoreCase(city))
            store = new ChicagoPizzaStore();
    }
}
