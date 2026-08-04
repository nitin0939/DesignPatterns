package designpatterns.behavioral.strategy;

/**
 * Concrete Strategy in the Strategy pattern.
 */
public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
