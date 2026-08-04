package designpatterns.behavioral.observer;

/**
 * Client class that demonstrates the Observer pattern.
 * Registers three independent displays against one {@link WeatherData}
 * subject, then feeds in new sensor readings and shows all three react
 * automatically without {@code WeatherData} ever naming a display class.
 */
public class TestObserver {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println();
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println();
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
