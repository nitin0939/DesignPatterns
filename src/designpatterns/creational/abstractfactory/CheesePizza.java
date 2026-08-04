package designpatterns.creational.abstractfactory;

/**
 * Client class in the Abstract Factory pattern.
 * Builds itself using only the abstract {@link PizzaIngredientFactory},
 * {@link Dough}, and {@link Cheese} types, staying completely unaware of
 * which concrete regional family (NY or Chicago) is actually in use.
 */
public class CheesePizza {

    private final Dough dough;
    private final Cheese cheese;

    /**
     * Sources this pizza's ingredients via the given factory, without knowing its concrete type.
     */
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.dough = ingredientFactory.createDough();
        this.cheese = ingredientFactory.createCheese();
    }

    /**
     * Prints what this pizza was assembled from.
     */
    public void prepare() {
        System.out.println("Preparing cheese pizza with " + dough.describe() + " and " + cheese.describe());
    }
}
