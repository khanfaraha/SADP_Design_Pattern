import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherDataSubject {
    void registerObserver(WeatherDataObserver observer);
    void removeObserver(WeatherDataObserver observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements WeatherDataSubject {
    private float temperature;
    private float humidity;
    private float pressure;
    private List<WeatherDataObserver> observers;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setWeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void registerObserver(WeatherDataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherDataObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherDataObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

// Observer interface
interface WeatherDataObserver {
    void update(float temperature, float humidity, float pressure);
}

// Concrete Observer
class CurrentConditionsDisplay implements WeatherDataObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Current conditions: " + temperature + "°C, " + humidity + "% humidity");
    }
}

class ForecastDisplay implements WeatherDataObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Weather forecast: Sunny");
    }
}

public class Task10_ObserverPatternWeatherDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherStation.registerObserver(currentConditionsDisplay);
        weatherStation.registerObserver(forecastDisplay);

        // Simulate changes in weather data
        weatherStation.setWeatherData(25.0f, 60.0f, 1013.2f);
        weatherStation.setWeatherData(27.5f, 55.0f, 1012.0f);

        // Remove the current conditions display
        weatherStation.removeObserver(currentConditionsDisplay);

        // Simulate another change in weather data
        weatherStation.setWeatherData(23.0f, 70.0f, 1015.5f);
    }
}
