package designpatterns.behavioral.strategy;

/**
 * Concrete Strategy in the Strategy pattern.
 * Used by ducks that make no sound at all (e.g. {@code RubberDuck}, in the
 * classic sense — before it's given a squeak).
 */
public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
