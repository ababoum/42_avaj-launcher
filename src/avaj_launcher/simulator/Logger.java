package src.avaj_launcher.simulator;

import java.io.FileWriter;
import java.io.IOException;

import src.avaj_launcher.simulator.vehicles.Flyable;

public class Logger {

    static FileWriter writer = null;

    static public void turnOn(String output_filename) throws IOException {
        writer = new FileWriter(output_filename);
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
        System.out.println("Tower says: " + flyableLabel(registree) + "registered to weather tower.");
    }

    static public void towerAnnouncesUnregistration(Flyable registree) {
        System.out.println("Tower says: " + flyableLabel(registree) + "unregistered from weather tower.");
    }

    static public void update(Flyable broadcaster, String action) {

        System.out.println(flyableLabel(broadcaster) + " " + action + ".");
    }

    static public void weatherReact(Flyable broadcaster, String weather) {
        String prompt = flyableLabel(broadcaster) + ": ";
        switch (broadcaster.getType()) {
            case "Baloon":
                switch (weather) {
                    case "SUN":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    case "RAIN":
                        System.out.println(prompt + "Damn you rain! You messed up my baloon.");
                        break;
                    case "SNOW":
                        System.out.println(prompt + "It's snowing. We're gonna crash.");
                        break;
                    case "FOG":
                        System.out.println(prompt + "Fog messes with my head.");
                        break;
                    default:
                        break;
                }
                break;

            case "JetPlane":
                switch (weather) {
                    case "SUN":
                        System.out.println(prompt + "What a wonderful weather.");
                        break;
                    case "RAIN":
                        System.out.println(prompt + "It's raining. Better watch out for lightings.");
                        break;
                    case "SNOW":
                        System.out.println(prompt + "OMG! Winter is coming!");
                        break;
                    case "FOG":
                        System.out.println(prompt + "Can I see? Barely!");
                        break;
                    default:
                        break;
                }
                break;

            case "Helicopter":
                switch (weather) {
                    case "SUN":
                        System.out.println(prompt + "This is hot.");
                        break;
                    case "RAIN":
                        System.out.println(prompt + "Chop-chop that rain!");
                        break;
                    case "SNOW":
                        System.out.println(prompt + "My rotor is going to freeze!");
                        break;
                    case "FOG":
                        System.out.println(prompt + "I hope this is all a dream.");
                        break;
                    default:
                        break;
                }
                break;

            default:
                break;
        }
    }
}
