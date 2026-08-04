package designpatterns.behavioral.command;

/**
 * Receiver in the Command pattern.
 * A second, unrelated receiver type — proving commands can wrap any receiver
 * API, not just an on/off switch like {@link Light}.
 */
public class CeilingFan {
    public static final int HIGH = 2;
    public static final int MEDIUM = 1;
    public static final int OFF = 0;

    private final String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println(location + " ceiling fan is on high");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " ceiling fan is on medium");
    }

    public void off() {
        speed = OFF;
        System.out.println(location + " ceiling fan is off");
    }

    public int getSpeed() {
        return speed;
    }
}
