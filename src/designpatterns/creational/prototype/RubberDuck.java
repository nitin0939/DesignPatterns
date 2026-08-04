package designpatterns.creational.prototype;

/**
 * Concrete Prototype in the Prototype pattern.
 */
public class RubberDuck extends Duck {

    /**
     * Default constructor, used when building a rubber duck from scratch (not by cloning).
     */
    public RubberDuck() {
    }

    /**
     * Copy constructor. Copies {@link Duck}'s fields via {@code super(source)}.
     */
    public RubberDuck(RubberDuck source) {
        super(source);
    }

    /**
     * Returns a new, independent {@link RubberDuck} with the same field values as this one.
     */
    @Override
    public Duck clone() {
        return new RubberDuck(this);
    }

    @Override
    public void quack() {
        System.out.println(name + " says: Squeak!");
    }
}
