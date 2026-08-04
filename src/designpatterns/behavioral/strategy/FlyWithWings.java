package designpatterns.behavioral.strategy;

/**
 * Concrete Strategy in the Strategy pattern.
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
