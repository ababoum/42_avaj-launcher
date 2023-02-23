package src.avaj_launcher.simulator;

import src.avaj_launcher.simulator.vehicles.Flyable;

public class Logger {

    static private String flyableLabel(Flyable flyable) {
        return flyable.getType() + "#" + flyable.getName() +
                "(" + flyable.getId() + ")";
    }

    static void towerAnnouncesRegistration(Flyable registree) {
        System.out.println("Tower says: " + flyableLabel(registree) + "registered to weather tower.");
    }

    static void towerAnnouncesUnregistration(Flyable registree) {
        System.out.println("Tower says: " + flyableLabel(registree) + "unregistered from weather tower.");
    }

    static void update(Flyable broadcaster, String action) {

        System.out.println(flyableLabel(broadcaster) + " " + action + ".");
    }

    static void weatherReact(Flyable broadcaster, String action, String weather) {
        String prompt = flyableLabel(broadcaster) + ": ";
        switch (broadcaster.getType()) {
            case "Baloon":
                switch (weather) {
                    case "SUN":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    case "RAIN":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    case "SNOW":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                    case "FOG":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    default:
                        break;
                }
                break;
            
            case "JetPlane":
                switch (weather) {
                    case "SUN":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    case "RAIN":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    case "SNOW":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                    case "FOG":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    default:
                        break;
                }
                break;

            case "Helicopter":
                switch (weather) {
                    case "SUN":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    case "RAIN":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                        break;
                    case "SNOW":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
                    case "FOG":
                        System.out.println(prompt + "Let's enjoy the good weather and take some pics.");
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
