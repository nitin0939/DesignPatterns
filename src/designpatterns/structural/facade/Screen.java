package designpatterns.structural.facade;

/**
 * Subsystem class in the Facade pattern.
 */
public class Screen {
    public void down() {
        System.out.println("Screen going down");
    }

    public void up() {
        System.out.println("Screen going up");
    }
}
