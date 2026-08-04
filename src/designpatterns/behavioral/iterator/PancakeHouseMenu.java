package designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Aggregate in the Iterator pattern.
 * Stores its items in an {@code ArrayList} — a resizable structure, since
 * breakfast items get added and removed more often.
 */
public class PancakeHouseMenu implements Menu {
    private final List<MenuItem> menuItems = new ArrayList<>();

    public PancakeHouseMenu() {
        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs and toast", true, 2.99);
        addItem("Waffles", "Waffles with your choice of blueberries or strawberries", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    /**
     * Returns an iterator that walks the internal {@code ArrayList} by index,
     * without exposing the list itself.
     */
    @Override
    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }

    /**
     * Concrete Iterator over an {@code ArrayList}-backed menu.
     */
    private static class PancakeHouseMenuIterator implements Iterator {
        private final List<MenuItem> items;
        private int position = 0;

        PancakeHouseMenuIterator(List<MenuItem> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            return position < items.size();
        }

        @Override
        public MenuItem next() {
            return items.get(position++);
        }
    }
}
