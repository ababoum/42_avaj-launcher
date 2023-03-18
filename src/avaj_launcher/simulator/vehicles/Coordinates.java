package src.avaj_launcher.simulator.vehicles;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    static public class InvalidCoordinates extends Exception {
        public InvalidCoordinates() {
            super("Coordinates must be positive integers and height must be between 0 and 100");
        }
    }

    public Coordinates(int longitude, int latitude, int height) throws InvalidCoordinates {
        if (longitude < 0 || latitude < 0 || height < 0 || height > 100) {
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
        if (this.height + delta > 100)
            this.height = 100;
        else if (this.height + delta <= 0)
            this.height = 0;
        else
            this.height += delta;
    }
}
