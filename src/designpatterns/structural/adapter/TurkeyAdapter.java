package designpatterns.structural.adapter;

/**
 * Adapter in the Adapter pattern (object-adapter style — via composition).
 * Implements {@link Duck} so it satisfies whatever Duck-consuming code
 * expects, while internally wrapping and delegating to an incompatible
 * {@link Turkey}. Since {@link Duck} is an interface here, this is the
 * cleanest possible object adapter — no workaround for single inheritance
 * is even needed, just implement the target and hold the adaptee.
 */
public class TurkeyAdapter implements Duck {
    private final Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    /**
     * Translates a duck quack into the wrapped turkey's gobble.
     */
    @Override
    public void quack() {
        turkey.gobble();
    }

    /**
     * Translates a duck's longer flight into several of the turkey's short flights,
     * so the wrapped turkey still "reads" like a duck to the caller.
     */
    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
