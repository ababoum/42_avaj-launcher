package src.avaj_launcher.simulator.vehicles;

import src.avaj_launcher.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower p_tower) {

    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getType() {
        return "Helicopter";
    }

}
