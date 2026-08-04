package designpatterns.creational.singleton;

/**
 * Singleton variant: eager initialization, applied to the Chocolate Boiler example.
 * The instance is created once, at class-loading time, by the JVM's class
 * loading guarantees — no explicit synchronization is needed.
 */
public final class EagerChocolateBoiler {

    private static final EagerChocolateBoiler INSTANCE = new EagerChocolateBoiler();

    private boolean empty;
    private boolean boiled;

    /**
     * Private constructor — runs exactly once, when the JVM initializes this class.
     */
    private EagerChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    /**
     * Returns the single instance built at class-loading time.
     */
    public static EagerChocolateBoiler getInstance() {
        return INSTANCE;
    }

    /**
     * Fills the boiler with milk and chocolate, but only if it's currently empty.
     */
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            System.out.println("Filling the boiler with milk and chocolate");
        }
    }

    /**
     * Drains the boiled mixture, but only once it's actually been boiled.
     */
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            System.out.println("Draining the boiled milk and chocolate mixture");
            empty = true;
        }
    }

    /**
     * Boils the mixture, but only if the boiler is full and not already boiled.
     */
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            System.out.println("Boiling the milk and chocolate mixture");
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
