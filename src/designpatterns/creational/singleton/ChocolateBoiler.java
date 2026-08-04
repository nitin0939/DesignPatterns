package designpatterns.creational.singleton;

/**
 * Singleton in the Singleton pattern (Head First's Chocolate Boiler example),
 * implemented with thread-safe lazy initialization (double-checked locking).
 * A factory has exactly one chocolate boiler — if two instances existed, two
 * pieces of code could each think it's safe to fill or drain it, overflowing
 * or damaging the physical tank. This class makes that impossible.
 */
public final class ChocolateBoiler {

    /**
     * {@code volatile} so a thread that reads a non-null value here is guaranteed
     * to see a fully-constructed instance, not a partially-initialized one.
     */
    private static volatile ChocolateBoiler instance;

    private boolean empty;
    private boolean boiled;

    /**
     * Private constructor — the only place this class is ever {@code new}'d,
     * preventing any code outside this class from creating a second boiler.
     * Starts empty and unboiled, matching the boiler's real starting state.
     */
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    /**
     * Returns the single shared instance, creating it on first call.
     * Checks {@code instance} once without locking (fast path, for the common
     * case where it's already built), and only synchronizes — then checks again
     * inside the lock — the first time, when construction actually has to happen.
     */
    public static ChocolateBoiler getInstance() {
        ChocolateBoiler result = instance;
        if (result != null) {
            return result;
        }
        synchronized (ChocolateBoiler.class) {
            if (instance == null) {
                instance = new ChocolateBoiler();
            }
            return instance;
        }
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
