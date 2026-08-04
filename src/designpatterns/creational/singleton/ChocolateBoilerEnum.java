package designpatterns.creational.singleton;

/**
 * Singleton variant: enum singleton, applied to the Chocolate Boiler example.
 * The JVM guarantees an enum constant is instantiated exactly once, even under
 * concurrent class loading — and this form is inherently immune to the
 * reflection and deserialization tricks that can defeat a private-constructor singleton.
 */
public enum ChocolateBoilerEnum {
    INSTANCE;

    private boolean empty = true;
    private boolean boiled = false;

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
