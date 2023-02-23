package src.avaj_launcher.simulator;

import src.avaj_launcher.simulator.vehicles.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getInstance();

        return weatherProvider.getCurrentWeather(p_coordinates);
    }
}
