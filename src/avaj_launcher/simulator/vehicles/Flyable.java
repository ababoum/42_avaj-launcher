package src.avaj_launcher.simulator.vehicles;

import src.avaj_launcher.simulator.WeatherTower;

public interface Flyable {
    WeatherTower weatherTower = null;

    abstract void updateConditions();

    public void registerTower(WeatherTower p_tower);

    public long getId();

    public String getName();

    public Coordinates getCoordinates();

    public String getType();

}
