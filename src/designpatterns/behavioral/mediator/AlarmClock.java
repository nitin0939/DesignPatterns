package designpatterns.behavioral.mediator;

/**
 * Colleague in the Mediator pattern.
 * Only knows about the {@link SmartHomeMediator}, never about
 * {@link CoffeeMaker} or {@link Blinds} directly, even though ringing
 * ultimately triggers both of them.
 */
public class AlarmClock {
    private final SmartHomeMediator mediator;

    public AlarmClock(SmartHomeMediator mediator) {
        this.mediator = mediator;
    }

    public void ring() {
        System.out.println("AlarmClock: Ring ring!");
        mediator.notify(this, "ALARM_RANG");
    }
}
