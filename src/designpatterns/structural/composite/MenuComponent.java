package designpatterns.structural.composite;

/**
 * Component in the Composite pattern (Head First's Diner Menu example).
 * Declares the operations both leaves ({@link MenuItem}) and composites
 * ({@link Menu}) support, so a client can treat a single dish and an entire
 * menu of sub-menus identically. Methods that only make sense for one side
 * default to throwing, so neither subclass is forced to implement operations
 * that don't apply to it.
 */
public abstract class MenuComponent {

    /**
     * Composite-only: adds a child component. Leaves don't override this.
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * Composite-only: removes a child component. Leaves don't override this.
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * Composite-only: fetches a child by index. Leaves don't override this.
     */
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    /**
     * Prints this component. A leaf prints one line; a composite prints its
     * own name then recurses into every child — the recursion is what lets
     * the client print an entire menu tree with a single call.
     */
    public void print() {
        throw new UnsupportedOperationException();
    }
}
