package designpatterns.creational.abstractfactory;

/**
 * Concrete Product in the Abstract Factory pattern.
 * Belongs to the "Chicago" ingredient family.
 */
public class ThickCrustDough implements Dough {

    @Override
    public String describe() {
        return "Extra Thick Crust Dough";
    }
}
