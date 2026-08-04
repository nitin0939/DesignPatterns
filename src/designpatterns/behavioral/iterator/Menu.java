package designpatterns.behavioral.iterator;

/**
 * Common interface implemented by every menu, regardless of what data
 * structure it uses internally to store its items.
 */
public interface Menu {

    /**
     * Returns an {@link Iterator} over this menu's items, hiding whatever
     * internal storage the menu actually uses.
     */
    Iterator createIterator();
}
