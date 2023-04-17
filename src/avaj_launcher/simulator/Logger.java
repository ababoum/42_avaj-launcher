package src.avaj_launcher.simulator;

import java.io.FileWriter;
import java.io.IOException;

import src.avaj_launcher.simulator.vehicles.Flyable;

public class Logger {

    static FileWriter writer = null;

    static public void turnOn(String output_filename) throws IOException {
        writer = new FileWriter(output_filename);
        try {
            writer.write("");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static public void turnOff() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                return;
            }
        }
    }

    static private String flyableLabel(Flyable flyable) {
        return flyable.getType() + "#" + flyable.getName() +
                "(" + flyable.getId() + ")";
    }

    static public void towerAnnouncesRegistration(Flyable registree) {
        try {
            writer.append("Tower says: " + flyableLabel(registree) + " registered to weather tower.\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static public void towerAnnouncesUnregistration(Flyable registree) {
        try {
            writer.append("Tower says: " + flyableLabel(registree) + " unregistered from weather tower.\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static public void update(Flyable broadcaster, String action) {
        try {

            writer.append(flyableLabel(broadcaster) + " " + action + ".\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    static public void weatherReact(Flyable broadcaster, String weather) {
        String prompt = flyableLabel(broadcaster) + ": ";
        try {
            switch (broadcaster.getType()) {
                case "Baloon":
                    switch (weather) {
                        case "SUN":
                            writer.append(prompt + "Let's enjoy the good weather and take some pics.");
                            break;
                        case "RAIN":
                            writer.append(prompt + "Damn you rain! You messed up my baloon.");
                            break;
                        case "SNOW":
                            writer.append(prompt + "It's snowing. We're gonna crash.");
                            break;
                        case "FOG":
                            writer.append(prompt + "Fog messes with my head.");
                            break;
                        default:
                            break;
                    }
                    break;

                case "JetPlane":
                    switch (weather) {
                        case "SUN":
                            writer.append(prompt + "What a wonderful weather.");
                            break;
                        case "RAIN":
                            writer.append(prompt + "It's raining. Better watch out for lightings.");
                            break;
                        case "SNOW":
                            writer.append(prompt + "OMG! Winter is coming!");
                            break;
                        case "FOG":
                            writer.append(prompt + "Can I see? Barely!");
                            break;
                        default:
                            break;
                    }
                    break;

                case "Helicopter":
                    switch (weather) {
                        case "SUN":
                            writer.append(prompt + "This is hot.");
                            break;
                        case "RAIN":
                            writer.append(prompt + "Chop-chop that rain!");
                            break;
                        case "SNOW":
                            writer.append(prompt + "My rotor is going to freeze!");
                            break;
                        case "FOG":
                            writer.append(prompt + "I hope this is all a dream.");
                            break;
                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
            writer.append("\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}