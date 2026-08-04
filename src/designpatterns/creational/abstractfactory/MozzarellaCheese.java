package designpatterns.creational.abstractfactory;

/**
 * Concrete Product in the Abstract Factory pattern.
 * Belongs to the "Chicago" ingredient family.
 */
public class MozzarellaCheese implements Cheese {

    @Override
    public String describe() {
        return "Shredded Mozzarella Cheese";
    }
}
