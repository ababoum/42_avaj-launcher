
import java.io.IOException;

import src.avaj_launcher.simulator.Logger;
import src.avaj_launcher.simulator.Simulator;

public class Main {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: java Main scenario.txt");
            return;
        }
        if (Simulator.Prepare(args[0]) < 0) {
            return;
        }
        try {
            Logger.turnOn("simulation.txt");
        } catch (IOException e) {
            System.err.println("Impossible to create output file: simulation.txt");
            return;
        }

        Simulator.Launch();
        Logger.turnOff();
    }
}
