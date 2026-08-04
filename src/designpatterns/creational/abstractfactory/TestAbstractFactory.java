package designpatterns.creational.abstractfactory;

/**
 * Entry point demonstrating the Abstract Factory pattern.
 * Selects a concrete {@link PizzaIngredientFactory} at runtime and lets
 * {@link CheesePizza} source its ingredients without ever referencing a
 * concrete ingredient class directly.
 */
public class TestAbstractFactory {

    public static PizzaIngredientFactory ingredientFactory;

    /**
     * Configures the desired regional factory and prepares a pizza with it.
     */
    public static void main(String[] args) {
        configure("NY");
        CheesePizza nyPizza = new CheesePizza(ingredientFactory);
        nyPizza.prepare();

        configure("Chicago");
        CheesePizza chicagoPizza = new CheesePizza(ingredientFactory);
        chicagoPizza.prepare();
    }

    /**
     * Picks the concrete {@link PizzaIngredientFactory} implementation based on the given city name.
     */
    static void configure(String city) {
        if ("NY".equalsIgnoreCase(city))
            ingredientFactory = new NYPizzaIngredientFactory();
        else if ("Chicago".equalsIgnoreCase(city))
            ingredientFactory = new ChicagoPizzaIngredientFactory();
    }
}
