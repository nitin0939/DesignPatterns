package designpatterns.behavioral.strategy;

/**
 * Concrete Context in the Strategy pattern.
 * Starts out unable to fly — but since flying is a swappable strategy object
 * rather than an inherited method, it can be upgraded at runtime by calling
 * {@link #setFlyBehavior(FlyBehavior)} with a {@link FlyRocketPowered} instead
 * of needing a new subclass.
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
