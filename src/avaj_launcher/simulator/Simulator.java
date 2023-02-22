package src.avaj_launcher.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import src.avaj_launcher.simulator.vehicles.Aircraft;

public class Simulator {
    static int simulation_cycles = 0;
    static Aircraft aircrafts[];

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java -jar avaj_launcher.jar scenario.txt");
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            String line = reader.readLine();
            int lineNum = 0;
            while (line != null) {
                if (lineNum++ == 0) {
                    try {
                        simulation_cycles = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println("First line of the file " + args[0] + " must be an integer");
                        return;
                    }
                    if (simulation_cycles < 0) {
                        System.out.println("First line of the file " + args[0] + " must be a positive integer");
                        return;
                    }
                    continue ;
                }
                
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    System.out.println("Invalid line " + lineNum + " in the file " + args[0]);
                    return;
                }
                
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not found");
        } catch (IOException e) {
            System.out.println("Error while reading the file " + args[0]);
        }
    }

}
