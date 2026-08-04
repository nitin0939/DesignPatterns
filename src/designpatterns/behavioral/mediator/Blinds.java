package designpatterns.behavioral.mediator;

/**
 * Colleague in the Mediator pattern.
 * Has no {@code notify()} call of its own in this example — it only ever
 * gets acted upon, never initiates an event, which is a perfectly valid
 * colleague role.
 */
public class Blinds {

    public void open() {
        System.out.println("Blinds: Opening...");
    }
}
