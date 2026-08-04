package designpatterns.structural.facade;

/**
 * Facade in the Facade pattern.
 * Provides one simplified interface (`watchMovie()`/`endMovie()`) over a
 * complex subsystem of independently-usable components. The client no
 * longer needs to know the correct order of a dozen individual calls across
 * six different classes — nor does the Facade take away the option of using
 * those classes directly when finer control is actually needed.
 */
public class HomeTheaterFacade {
    private final Amplifier amp;
    private final DvdPlayer dvd;
    private final Projector projector;
    private final Screen screen;
    private final TheaterLights lights;
    private final PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector projector,
                              Screen screen, TheaterLights lights, PopcornPopper popper) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
    }

    /**
     * Drives every subsystem component through the exact sequence needed to
     * get ready for a movie, in the right order, with the right settings.
     */
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.setInput(dvd);
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    /**
     * Reverses {@link #watchMovie(String)}, shutting everything back down in order.
     */
    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }
}
