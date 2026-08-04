package designpatterns.structural.adapter;

/**
 * Concrete Adaptee in the Adapter pattern.
 * A real, working turkey — reused as-is, never modified, even though its
 * interface doesn't match what {@link Duck}-expecting code needs.
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
