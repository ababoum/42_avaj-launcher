package src.avaj_launcher.simulator.vehicles;

import src.avaj_launcher.simulator.WeatherTower;

public interface Flyable {
    public WeatherTower weatherTower = null;

    abstract void updateConditions();
    public void registerTower(WeatherTower p_tower);
}
