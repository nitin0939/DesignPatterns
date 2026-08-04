package designpatterns.structural.facade;

/**
 * Subsystem class in the Facade pattern.
 */
public class Projector {
    public void on() {
        System.out.println("Projector on");
    }

    public void setInput(DvdPlayer dvd) {
        System.out.println("Projector setting input to DVD player");
    }

    public void wideScreenMode() {
        System.out.println("Projector in widescreen mode");
    }

    public void off() {
        System.out.println("Projector off");
    }
}
