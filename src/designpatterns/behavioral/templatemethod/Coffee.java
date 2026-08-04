package designpatterns.behavioral.templatemethod;

/**
 * Concrete Class in the Template Method pattern.
 * Fills in only the two steps that differ; {@code prepareRecipe()} itself is
 * inherited unchanged from {@link CaffeineBeverage}.
 */
public class Coffee extends CaffeineBeverage {

    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
