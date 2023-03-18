package src.avaj_launcher.simulator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.avaj_launcher.simulator.vehicles.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        Logger.towerAnnouncesRegistration(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        // observers.remove(p_flyable);
        Logger.towerAnnouncesUnregistration(p_flyable);
    }

    protected void conditionChanged() {
        Iterator<Flyable> it = observers.iterator();
        while (it.hasNext()) {
            Flyable flyable = it.next();
            flyable.updateConditions();
            if (flyable.getCoordinates().getHeight() == 0)
                it.remove();
        }
    }

    public List<Flyable> getObservers() {
        return observers;
    }
}
