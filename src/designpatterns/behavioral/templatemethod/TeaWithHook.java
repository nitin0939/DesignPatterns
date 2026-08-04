package designpatterns.behavioral.templatemethod;

/**
 * Concrete Class in the Template Method pattern.
 * Demonstrates the {@code customerWantsCondiments()} hook: this subclass
 * overrides it instead of accepting the base class's default, letting one
 * order opt out of the condiments step entirely without touching
 * {@code prepareRecipe()} itself.
 */
public class TeaWithHook extends CaffeineBeverage {
    private final boolean wantsLemon;

    public TeaWithHook(boolean wantsLemon) {
        this.wantsLemon = wantsLemon;
    }

    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }

    /**
     * Overrides the hook to reflect whether this particular customer wants lemon.
     */
    @Override
    protected boolean customerWantsCondiments() {
        return wantsLemon;
    }
}
