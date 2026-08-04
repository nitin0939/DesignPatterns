package designpatterns.behavioral.iterator;

import java.util.List;

/**
 * Client class that demonstrates the Iterator pattern.
 * Feeds two menus with completely different internal storage into the same
 * {@link Waitress}, which iterates over both identically.
 */
public class TestIterator {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(List.of(pancakeHouseMenu, dinerMenu));
        waitress.printMenu();
    }
}
