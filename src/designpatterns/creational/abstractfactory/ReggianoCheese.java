package designpatterns.creational.abstractfactory;

/**
 * Concrete Product in the Abstract Factory pattern.
 * Belongs to the "NY" ingredient family.
 */
public class ReggianoCheese implements Cheese {

    @Override
    public String describe() {
        return "Reggiano Cheese";
    }
}
