package src.avaj_launcher.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.avaj_launcher.simulator.vehicles.AircraftFactory;
import src.avaj_launcher.simulator.vehicles.Coordinates;
import src.avaj_launcher.simulator.vehicles.Flyable;
import src.avaj_launcher.simulator.vehicles.AircraftFactory.InvalidFlyableType;
import src.avaj_launcher.simulator.vehicles.Coordinates.InvalidCoordinates;

public class Simulator {
    static int simulation_cycles = 0;
    static List<Flyable> flyables = new ArrayList<>();
    static int lineNum = 0;
    static String filename = null;
    static AircraftFactory aircraftFactory = AircraftFactory.getInstance();
    static WeatherTower weatherTower = new WeatherTower();

    private static void printScenarioError(String message) {
        System.err.println("Invalid line " + lineNum + " in the file " + filename + ": " + message);
    }

    public static int Prepare(String inputFilename) {
        BufferedReader reader = null;
        filename = inputFilename;
        try {
            reader = new BufferedReader(new FileReader(filename));

            String line = reader.readLine();
            while (line != null) {
                // block for the first line only
                if (lineNum++ == 0) {
                    try {
                        simulation_cycles = Integer.parseInt(line);
                    } catch (NumberFormatException e) {

                        System.err.println("First line of the file " + filename + " must be an integer");
                        return 1;
                    }
                    if (simulation_cycles < 0) {
                        System.err.println("First line of the file " + filename + " must be a positive integer");
                        return 1;
                    }
                    line = reader.readLine();
                    continue;
                }

                // check for empty lines
                if (line.length() == 0) {
                    printScenarioError("a line must not be empty");
                    return 1;
                }

                // populate the aircrafts list
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    printScenarioError("an aircraft line must contain 5 items");
                    return 1;
                }

                Coordinates coordinates = null;
                try {
                    coordinates = new Coordinates(
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]),
                            Integer.parseInt(parts[4]));
                } catch (NumberFormatException e) {
                    printScenarioError("coordinates must be integers");
                    return 1;
                } catch (InvalidCoordinates e) {
                    printScenarioError(e.getMessage());
                    return 1;
                }
                Flyable newAircraft = null;
                try {
                    newAircraft = aircraftFactory.newAircraft(parts[0], parts[1], coordinates);
                } catch (InvalidFlyableType e) {
                    printScenarioError(e.getMessage());
                }
                flyables.add(newAircraft);
                line = reader.readLine();
            }
            reader.close();
            // for (Flyable flyable: flyables) {
            // if (flyable instanceof Aircraft) {
            // System.out.println(flyable.getName());
            // }
            // }
            return 0;
        } catch (FileNotFoundException e) {
            System.err.println("File " + filename + " not found");
            return 1;
        } catch (IOException e) {
            System.err.println("Error while reading the file " + filename);
            return 1;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error while handling the file " + filename);
                }
            }
        }
    }

    public static void Launch() {
        for (Flyable flyable : flyables) {
            weatherTower.register(flyable);
            flyable.registerTower(weatherTower);
        }

        while (--simulation_cycles >= 0) {
            weatherTower.conditionChanged();
        }
    }

}
