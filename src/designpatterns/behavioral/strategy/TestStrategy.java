package designpatterns.behavioral.strategy;

/**
 * Client class that demonstrates the Strategy pattern.
 * Shows a duck's flying behavior being swapped at runtime, without touching
 * the {@link Duck} class or writing a new subclass.
 */
public class TestStrategy {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.display();
        model.performFly();

        System.out.println("\nUpgrading the model duck with a rocket...");
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.performQuack();
        rubber.performFly();
    }
}
