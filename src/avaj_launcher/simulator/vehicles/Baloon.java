package src.avaj_launcher.simulator.vehicles;

import src.avaj_launcher.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower p_tower) {

    }
}