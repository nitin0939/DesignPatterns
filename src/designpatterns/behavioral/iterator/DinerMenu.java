package designpatterns.behavioral.iterator;

/**
 * Concrete Aggregate in the Iterator pattern.
 * Stores its items in a fixed-size array — this diner's menu barely
 * changes, so a plain array (with wasted trailing {@code null} slots) is
 * how it was originally written, long before anyone needed to iterate over
 * it uniformly alongside {@link PancakeHouseMenu}.
 */
public class DinerMenu implements Menu {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private final MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", "A bowl of the soup of the day, with a side of potato salad", false, 3.29);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("Sorry, menu is full! Can't add item to menu");
            return;
        }
        menuItems[numberOfItems++] = new MenuItem(name, description, vegetarian, price);
    }

    /**
     * Returns an iterator that walks the internal array up to
     * {@code numberOfItems}, skipping the unused trailing slots entirely.
     */
    @Override
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems, numberOfItems);
    }

    /**
     * Concrete Iterator over an array-backed menu.
     */
    private static class DinerMenuIterator implements Iterator {
        private final MenuItem[] items;
        private final int size;
        private int position = 0;

        DinerMenuIterator(MenuItem[] items, int size) {
            this.items = items;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public MenuItem next() {
            return items[position++];
        }
    }
}
