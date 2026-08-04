package designpatterns.behavioral.mediator;

/**
 * Colleague in the Mediator pattern.
 */
public class CoffeeMaker {
    private final SmartHomeMediator mediator;

    public CoffeeMaker(SmartHomeMediator mediator) {
        this.mediator = mediator;
    }

    public void startBrewing() {
        System.out.println("CoffeeMaker: Brewing coffee...");
        mediator.notify(this, "COFFEE_READY");
    }
}
