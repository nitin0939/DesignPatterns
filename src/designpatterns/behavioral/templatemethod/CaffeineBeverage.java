package designpatterns.behavioral.templatemethod;

/**
 * Abstract Class in the Template Method pattern (Head First's Caffeine
 * Beverage example). Defines the skeleton of making a hot caffeinated drink
 * as a series of steps, deferring the steps that actually differ between
 * coffee and tea to subclasses.
 */
public abstract class CaffeineBeverage {

    /**
     * The template method — the fixed algorithm every subclass follows.
     * Marked {@code final} so subclasses can override individual steps but
     * can never change the overall recipe order.
     */
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * The one step that genuinely differs between beverages.
     */
    protected abstract void brew();

    /**
     * The other differing step — what condiment goes in.
     */
    protected abstract void addCondiments();

    /**
     * Identical for every beverage, so it's implemented once here instead of
     * being duplicated in every subclass.
     */
    protected void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * Also identical for every beverage.
     */
    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * Hook: subclasses may override this to opt out of the condiments step
     * entirely. The default lets condiments through; a subclass isn't
     * required to override it at all.
     */
    protected boolean customerWantsCondiments() {
        return true;
    }
}
