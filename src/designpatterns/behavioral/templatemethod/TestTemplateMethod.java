package designpatterns.behavioral.templatemethod;

/**
 * Client class that demonstrates the Template Method pattern.
 * Runs the same {@code prepareRecipe()} algorithm across coffee and tea, then
 * shows the {@code customerWantsCondiments()} hook skipping a step entirely.
 */
public class TestTemplateMethod {

    public static void main(String[] args) {
        System.out.println("Making coffee...");
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println("\nMaking tea...");
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println("\nMaking tea, no lemon this time (hook returns false)...");
        CaffeineBeverage teaNoCondiments = new TeaWithHook(false);
        teaNoCondiments.prepareRecipe();
    }
}
