package designpatterns.structural.facade;

/**
 * Client class that demonstrates the Facade pattern.
 * Calls just two methods on {@link HomeTheaterFacade} instead of manually
 * sequencing calls across six different subsystem classes.
 */
public class TestFacade {

    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, screen, lights, popper);

        homeTheater.watchMovie("Raiders of the Lost Ark");
        System.out.println();
        homeTheater.endMovie();
    }
}
