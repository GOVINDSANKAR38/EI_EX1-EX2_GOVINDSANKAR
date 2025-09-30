import java.util.*;

public class DoorLock implements Device, Lockable, Subject {
    private final int id;
    private boolean locked = false;
    private final List<Observer> observers = new ArrayList<>();

    public DoorLock(int id) { this.id = id; }

    @Override
    public int getId() { return id; }

    @Override
    public String getType() { return "Door"; }

    @Override
    public String getStatus() { return locked ? "Locked" : "Unlocked"; }

    @Override
    public void lock() {
        locked = true;
        System.out.println("Door " + id + " locked.");
        notifyObservers("locked");
    }

    @Override
    public void unlock() {
        locked = false;
        System.out.println("Door " + id + " unlocked.");
        notifyObservers("unlocked");
    }

    @Override
    public Optional<Lockable> asLockable() { return Optional.of(this); }

    @Override
    public void addObserver(Observer obs) { observers.add(obs); }

    @Override
    public void removeObserver(Observer obs) { observers.remove(obs); }

    @Override
    public void notifyObservers(String event) {
        for (Observer obs : observers) {
            obs.update(this, event);
        }
    }
}
