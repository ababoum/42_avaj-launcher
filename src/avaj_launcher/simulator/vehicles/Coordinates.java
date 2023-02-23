package src.avaj_launcher.simulator.vehicles;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    static public class InvalidCoordinates extends Exception {
        public InvalidCoordinates() {
            super("Coordinates must be positive integers");
        }
    }

    public Coordinates(int longitude, int latitude, int height) throws InvalidCoordinates {
        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new InvalidCoordinates();
        }
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void updateLongitude(int delta) {
        this.longitude += delta;
    }

    public void updateLatitude(int delta) {
        this.latitude += delta;
    }

    public void updateHeight(int delta) {
        this.height += delta;
    }
}
