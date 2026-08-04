package designpatterns.creational.abstractfactory;

/**
 * Abstract Factory in the Abstract Factory pattern.
 * Declares a set of factory methods for producing each abstract ingredient
 * (Dough, Cheese) in a single, regionally-consistent family.
 */
public interface PizzaIngredientFactory {

    /**
     * @return a {@link Dough} belonging to this factory's regional family.
     */
    Dough createDough();

    /**
     * @return a {@link Cheese} belonging to this factory's regional family.
     */
    Cheese createCheese();
}
