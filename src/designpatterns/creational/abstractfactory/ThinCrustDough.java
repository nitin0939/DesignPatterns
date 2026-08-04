package designpatterns.creational.abstractfactory;

/**
 * Concrete Product in the Abstract Factory pattern.
 * Belongs to the "NY" ingredient family.
 */
public class ThinCrustDough implements Dough {

    @Override
    public String describe() {
        return "Thin Crust Dough";
    }
}
