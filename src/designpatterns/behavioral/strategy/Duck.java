package designpatterns.behavioral.strategy;

/**
 * Context in the Strategy pattern.
 * Holds a {@link FlyBehavior} and a {@link QuackBehavior} instead of
 * implementing flying/quacking itself, or inheriting a fixed implementation
 * from a common duck superclass — composition over inheritance is the whole
 * point here, since not every duck flies or quacks the same way.
 */
public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    /**
     * Every duck looks like a duck, regardless of its behaviors.
     */
    public abstract void display();

    /**
     * Delegates to whichever {@link FlyBehavior} this duck currently holds.
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * Delegates to whichever {@link QuackBehavior} this duck currently holds.
     */
    public void performQuack() {
        quackBehavior.quack();
    }

    /**
     * Swaps this duck's flying strategy at runtime.
     */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    /**
     * Swaps this duck's quacking strategy at runtime.
     */
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}
