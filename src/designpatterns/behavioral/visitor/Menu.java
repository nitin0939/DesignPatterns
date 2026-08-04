package designpatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Element (composite) in the Visitor pattern.
 * A menu of items and/or nested sub-menus — combining Visitor with the same
 * tree shape used by the Composite pattern.
 */
public class Menu extends MenuComponent {
    private final String name;
    private final List<MenuComponent> components = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(MenuComponent component) {
        components.add(component);
    }

    /**
     * Visits itself, then drives the visitor into every child — this is what
     * lets one {@code accept()} call at the root walk the entire tree.
     */
    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visit(this);
        for (MenuComponent component : components) {
            component.accept(visitor);
        }
    }
}
