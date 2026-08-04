package designpatterns.structural.facade;

/**
 * Subsystem class in the Facade pattern (Head First's Home Theater example).
 * A real, independently usable component with its own multi-step API — the
 * Facade will drive several classes like this one through the same call.
 */
public class Amplifier {
    public void on() {
        System.out.println("Amplifier on");
    }

    public void setDvd(DvdPlayer dvd) {
        System.out.println("Amplifier setting DVD player as input");
    }

    public void setSurroundSound() {
        System.out.println("Amplifier surround sound on");
    }

    public void setVolume(int level) {
        System.out.println("Amplifier setting volume to " + level);
    }

    public void off() {
        System.out.println("Amplifier off");
    }
}
