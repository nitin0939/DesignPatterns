package designpatterns.behavioral.strategy;

/**
 * Concrete Strategy in the Strategy pattern.
 * Used by ducks that can't fly at all (e.g. {@code RubberDuck}), instead of
 * forcing every duck to inherit a {@code fly()} that would need to be
 * overridden to do nothing.
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
