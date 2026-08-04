package designpatterns.behavioral.iterator;

import java.util.List;

/**
 * Client in the Iterator pattern.
 * Prints any number of menus identically, regardless of whether each one is
 * backed by an {@code ArrayList} ({@link PancakeHouseMenu}) or a raw array
 * ({@link DinerMenu}) internally.
 */
public class Waitress {
    private final List<Menu> menus;

    public Waitress(List<Menu> menus) {
        this.menus = menus;
    }

    /**
     * Prints every item from every menu, using only the {@link Iterator}
     * interface — never touching a menu's internal storage.
     */
    public void printMenu() {
        for (Menu menu : menus) {
            printMenu(menu.createIterator());
        }
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}
