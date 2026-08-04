package designpatterns.creational.abstractfactory;

/**
 * Concrete Factory in the Abstract Factory pattern.
 * Produces the "NY" family of ingredients, guaranteeing every ingredient it
 * returns is authentic New York style and mutually compatible.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    /**
     * @return a new {@link ThinCrustDough}.
     */
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    /**
     * @return a new {@link ReggianoCheese}.
     */
    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }
}
