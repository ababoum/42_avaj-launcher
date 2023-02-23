package src.avaj_launcher.simulator.vehicles;

public class AircraftFactory {
    private static AircraftFactory instance = null;
    private static long id = 1;

    static public class InvalidFlyableType extends Exception {
        public InvalidFlyableType(String message) {
            super(message);
        }
    }

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidFlyableType {
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(id++, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(id++, p_name, p_coordinates);
            case "Baloon":
                return new Baloon(id++, p_name, p_coordinates);
            default:
                throw new InvalidFlyableType("Cannot create Aircraft of type " + p_type);
        }
    }
}
