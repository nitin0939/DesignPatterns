package designpatterns.structural.composite;

/**
 * Client in the Composite pattern.
 * Holds only a reference to the single top-level {@link MenuComponent} and
 * calls {@code print()} on it — completely unaware of how many sub-menus or
 * how many levels of nesting actually exist underneath.
 */
public class Waitress {
    private final MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
