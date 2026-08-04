package designpatterns.creational.factory;

/**
 * Concrete Product in the Factory Method pattern.
 * Chicago style: extra thick crust, plum tomato sauce, sliced mozzarella —
 * and unlike its NY sibling, it's cut into squares.
 */
public class ChicagoStyleCheesePizza extends Pizza {

    /**
     * Sets up this pizza's Chicago-style ingredients.
     */
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust";
        sauce = "Plum Tomato";
        toppings.add("Shredded Mozzarella Cheese");
    }

    /**
     * Chicago deep dish is cut into squares, not diagonal slices.
     */
    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
