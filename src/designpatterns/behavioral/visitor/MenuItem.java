package designpatterns.behavioral.visitor;

/**
 * Concrete Element (leaf) in the Visitor pattern.
 */
public class MenuItem extends MenuComponent {
    private final String name;
    private final boolean vegetarian;
    private final double price;

    public MenuItem(String name, boolean vegetarian, double price) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Double dispatch: this call is resolved by the item's own type (via
     * overriding), and the overload it calls is resolved by the visitor's
     * type (via overloading) — together, that's what routes each element to
     * the correct {@code visit(...)} method without an {@code instanceof} chain.
     */
    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visit(this);
    }
}
