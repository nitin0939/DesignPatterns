package designpatterns.behavioral.mediator;

/**
 * Client class that demonstrates the Mediator pattern.
 * Wires three colleagues to one hub, then rings the alarm and shows the
 * coffee maker and blinds both react — despite neither of them, nor the
 * alarm clock, ever holding a reference to each other.
 */
public class TestMediator {

    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();

        AlarmClock alarmClock = new AlarmClock(hub);
        CoffeeMaker coffeeMaker = new CoffeeMaker(hub);
        Blinds blinds = new Blinds();

        hub.setAlarmClock(alarmClock);
        hub.setCoffeeMaker(coffeeMaker);
        hub.setBlinds(blinds);

        alarmClock.ring();
    }
}
