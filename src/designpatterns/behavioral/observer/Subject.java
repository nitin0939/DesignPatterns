package designpatterns.behavioral.observer;

/**
 * Subject in the Observer pattern.
 * Lets any number of {@link Observer}s register for change notifications,
 * without the subject needing to know their concrete types.
 */
public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    /**
     * Pushes the current state out to every registered observer.
     */
    void notifyObservers();
}
