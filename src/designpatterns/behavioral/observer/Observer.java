package designpatterns.behavioral.observer;

/**
 * Observer in the Observer pattern (Head First's Weather Station example).
 * Any display that wants to be notified whenever the weather station's
 * measurements change implements this.
 */
public interface Observer {

    /**
     * Called by the {@link Subject} whenever its state changes, pushing the
     * new measurements to this observer.
     */
    void update(float temperature, float humidity, float pressure);
}
