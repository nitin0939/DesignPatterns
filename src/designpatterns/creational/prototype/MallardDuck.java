package designpatterns.creational.prototype;

/**
 * Concrete Prototype in the Prototype pattern.
 */
public class MallardDuck extends Duck {

    /**
     * Default constructor, used when building a mallard from scratch (not by cloning).
     */
    public MallardDuck() {
    }

    /**
     * Copy constructor. Copies {@link Duck}'s fields via {@code super(source)}.
     */
    public MallardDuck(MallardDuck source) {
        super(source);
    }

    /**
     * Returns a new, independent {@link MallardDuck} with the same field values as this one.
     */
    @Override
    public Duck clone() {
        return new MallardDuck(this);
    }

    @Override
    public void quack() {
        System.out.println(name + " says: Quack!");
    }
}
