package src.avaj_launcher.simulator;

import java.util.List;

import src.avaj_launcher.simulator.vehicles.Flyable;

public class Tower {
    private List<Flyable> observers;

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        Logger.print(this, null);
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
    }

    protected void conditionChanged() {
        
    }
}
