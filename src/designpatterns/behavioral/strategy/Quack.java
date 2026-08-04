package designpatterns.behavioral.strategy;

/**
 * Concrete Strategy in the Strategy pattern.
 */
public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
