package src.avaj_launcher.simulator.vehicles;

public class AircraftFactory {
    private static AircraftFactory instance = null;
    private static long id = 0;

    private AircraftFactory() {}

    public AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(id++, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(id++, p_name, p_coordinates);
            case "Baloon":
                return new Baloon(id++, p_name, p_coordinates);
            default:
                System.err.println("Cannot create Aircraft of type " + p_type);
                return null;
        }
    }
}
