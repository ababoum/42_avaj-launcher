package src.avaj_launcher.simulator.vehicles;

import src.avaj_launcher.simulator.WeatherTower;
import src.avaj_launcher.simulator.Logger;

public class Baloon extends Aircraft implements Flyable {
    WeatherTower weatherTower = null;

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        if (weatherTower != null) {

            String weather = this.weatherTower.getWeather(this.coordinates);

            Logger.weatherReact(this, weather);

            switch (weather) {
                case "SUN":
                    this.coordinates.updateLongitude(2);
                    this.coordinates.updateHeight(4);
                    break;
                case "RAIN":
                    this.coordinates.updateHeight(-5);
                    break;
                case "FOG":
                    this.coordinates.updateHeight(-3);
                    break;
                case "SNOW":
                    this.coordinates.updateHeight(-15);
                    break;
                default:
                    break;
            }
        }
    }

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
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
        return "Baloon";
    }
}