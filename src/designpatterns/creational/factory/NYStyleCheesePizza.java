package designpatterns.creational.factory;

/**
 * Concrete Product in the Factory Method pattern.
 * New York style: thin crust, plum tomato sauce, shredded mozzarella.
 */
public class NYStyleCheesePizza extends Pizza {

    /**
     * Sets up this pizza's NY-style ingredients.
     */
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust";
        sauce = "Marinara";
        toppings.add("Grated Reggiano Cheese");
    }
}
