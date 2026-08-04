package designpatterns.behavioral.mediator;

/**
 * Concrete Mediator in the Mediator pattern.
 * The only class that knows about every colleague and the rules connecting
 * them — that coordination logic ("when the alarm rings, start the coffee
 * maker and open the blinds") lives here instead of being scattered across
 * the colleague classes themselves.
 */
public class SmartHomeHub implements SmartHomeMediator {
    private AlarmClock alarmClock;
    private CoffeeMaker coffeeMaker;
    private Blinds blinds;

    public void setAlarmClock(AlarmClock alarmClock) {
        this.alarmClock = alarmClock;
    }

    public void setCoffeeMaker(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    public void setBlinds(Blinds blinds) {
        this.blinds = blinds;
    }

    /**
     * Reacts to a colleague's event by coordinating whichever other
     * colleagues need to respond — the colleagues themselves never call
     * each other.
     */
    @Override
    public void notify(Object sender, String event) {
        if (sender == alarmClock && "ALARM_RANG".equals(event)) {
            System.out.println("SmartHomeHub: alarm rang -> starting coffee and opening blinds");
            coffeeMaker.startBrewing();
            blinds.open();
        } else if (sender == coffeeMaker && "COFFEE_READY".equals(event)) {
            System.out.println("SmartHomeHub: coffee is ready -> notifying occupant");
        }
    }
}
