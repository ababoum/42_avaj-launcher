package src.avaj_launcher.simulator;

import src.avaj_launcher.simulator.vehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider instance = null;
    private String[] weather = {"SUN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[0];
    }
}
