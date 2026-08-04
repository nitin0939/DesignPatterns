package designpatterns.creational.prototype;

/**
 * Prototype in the Prototype pattern (a Head-First-style example, reusing the
 * Duck domain that runs through several of the book's other chapters — not a
 * verbatim book example, since HFDP only covers Prototype briefly).
 * Declares the {@link #clone()} operation every concrete duck must support,
 * and holds the fields common to all ducks so subclasses can copy them via
 * the protected copy constructor.
 */
public abstract class Duck {
    protected String name;
    protected double weight;

    /**
     * Default constructor, used when building a duck from scratch (not by cloning).
     */
    public Duck() {
    }

    /**
     * Copy constructor. Subclasses call this via {@code super(source)} to copy
     * the fields declared on {@code Duck} before copying their own fields.
     */
    protected Duck(Duck source) {
        if (source != null) {
            this.name = source.name;
            this.weight = source.weight;
        }
    }

    /**
     * Creates and returns an independent copy of this duck.
     * Each concrete subclass implements this by invoking its own copy constructor.
     */
    public abstract Duck clone();

    /**
     * Makes this duck's characteristic sound.
     */
    public abstract void quack();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "', weight=" + weight + "}";
    }
}
