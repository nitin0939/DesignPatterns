package designpatterns.structural.adapter;

/**
 * Concrete Target implementation in the Adapter pattern.
 * A real, native duck — no adapting needed to use it wherever a {@link Duck} is expected.
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
