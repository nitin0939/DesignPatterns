package designpatterns.behavioral.command;

/**
 * Receiver in the Command pattern.
 * Knows how to actually perform the work — has no idea it's being controlled
 * via commands and a remote.
 */
public class Light {
    private final String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light is on");
    }

    public void off() {
        System.out.println(location + " light is off");
    }
}
