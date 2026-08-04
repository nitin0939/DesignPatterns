package designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Registry — a well-known extension of the Prototype pattern.
 * Stores one pre-configured duck prototype per key so callers can fetch a
 * ready-made clone by name instead of re-specifying every field each time.
 */
public class DuckPond {
    private static final Map<String, Duck> pond = new HashMap<>();

    /**
     * Populates the registry with pre-configured prototype ducks.
     * Called once before {@link #getDuck(String)} is used.
     */
    public static void stockPond() {
        MallardDuck mallard = new MallardDuck();
        mallard.name = "Mallard";
        mallard.weight = 2.5;
        pond.put("Mallard", mallard);

        RubberDuck rubber = new RubberDuck();
        rubber.name = "Rubber Ducky";
        rubber.weight = 0.1;
        pond.put("Rubber", rubber);
    }

    /**
     * Returns a fresh, independent clone of the prototype registered under {@code duckId}.
     * The cached prototype itself is never handed out directly, so callers can
     * freely mutate the returned duck without affecting the pond.
     */
    public static Duck getDuck(String duckId) {
        Duck prototype = pond.get(duckId);
        return prototype.clone();
    }
}
