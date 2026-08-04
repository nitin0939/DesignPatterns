package designpatterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Product in the Factory Method pattern (Head First's Pizza Store example).
 * Defines the steps every pizza goes through, regardless of style. Subclasses
 * fill in {@code name}, {@code dough}, {@code sauce}, and {@code toppings};
 * only {@link #cut()} varies enough by region to be worth overriding.
 */
public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();

    /**
     * Prints the ingredients being layered onto the pizza.
     */
    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing " + dough + " dough...");
        System.out.println("Adding " + sauce + " sauce...");
        System.out.println("Adding toppings: " + toppings);
    }

    /**
     * Bakes the pizza. Same for every style, so no subclass needs to override it.
     */
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    /**
     * Cuts the pizza into diagonal slices. Overridden by {@link ChicagoStyleCheesePizza},
     * which cuts into squares instead.
     */
    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    /**
     * Boxes the finished pizza for serving.
     */
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
