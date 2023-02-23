package src.avaj_launcher.simulator.vehicles;

import src.avaj_launcher.simulator.WeatherTower;
import src.avaj_launcher.simulator.Logger;

public class Helicopter extends Aircraft implements Flyable {
    WeatherTower weatherTower = null;

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        if (weatherTower != null) {

            String weather = this.weatherTower.getWeather(this.coordinates);

            Logger.weatherReact(this, weather);

            switch (weather) {
                case "SUN":
                    this.coordinates.updateHeight(2);
                    this.coordinates.updateLongitude(10);
                    break;
                case "RAIN":
                    this.coordinates.updateLongitude(5);
                    break;
                case "FOG":
                    this.coordinates.updateLongitude(1);
                    break;
                case "SNOW":
                    this.coordinates.updateHeight(-12);
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
        return "Helicopter";
    }

}
