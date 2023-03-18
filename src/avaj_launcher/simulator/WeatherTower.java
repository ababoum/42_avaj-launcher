package src.avaj_launcher.simulator;

import src.avaj_launcher.simulator.vehicles.Coordinates;
import src.avaj_launcher.simulator.WeatherProvider;

public class WeatherTower extends Tower {
    private WeatherProvider weatherProvider = WeatherProvider.getInstance();

    public String getWeather(Coordinates p_coordinates) {
        return this.weatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        // Do nothing
    }
}
