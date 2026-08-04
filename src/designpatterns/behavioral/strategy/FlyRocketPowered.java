package designpatterns.behavioral.strategy;

/**
 * Concrete Strategy in the Strategy pattern.
 * Demonstrates that new flying algorithms can be added later without ever
 * touching {@link Duck} or any existing duck subclass.
 */
public class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
