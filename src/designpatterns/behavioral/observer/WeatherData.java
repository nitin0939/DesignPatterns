package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject in the Observer pattern.
 * Tracks the current weather measurements and pushes them out to every
 * registered {@link Observer} whenever they change, without knowing or
 * caring which concrete displays are listening.
 */
public class WeatherData implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Pushes the current measurements to every registered observer.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * Called whenever the weather station's sensors take a new reading.
     * Updates this subject's state, then notifies every observer.
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * Simulates new sensor readings arriving and triggers the notification cycle.
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
