package designpatterns.creational.abstractfactory;

/**
 * Concrete Factory in the Abstract Factory pattern.
 * Produces the "Chicago" family of ingredients, guaranteeing every ingredient
 * it returns is deep-dish style and mutually compatible.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    /**
     * @return a new {@link ThickCrustDough}.
     */
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    /**
     * @return a new {@link MozzarellaCheese}.
     */
    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }
}
