package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite in the Composite pattern.
 * Holds a list of {@link MenuComponent} children, which may themselves be
 * {@link MenuItem} leaves or further nested {@code Menu} composites — that's
 * what lets a "dessert menu" be added as a child of a "dinner menu," which is
 * itself a child of the top-level menu, to any depth.
 */
public class Menu extends MenuComponent {
    private final List<MenuComponent> menuComponents = new ArrayList<>();
    private final String name;
    private final String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Prints this menu's own heading, then recurses into every child —
     * leaves print themselves, and nested menus repeat this same recursion.
     */
    @Override
    public void print() {
        System.out.println("\n" + getName() + ", " + getDescription());
        System.out.println("---------------------");
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}
