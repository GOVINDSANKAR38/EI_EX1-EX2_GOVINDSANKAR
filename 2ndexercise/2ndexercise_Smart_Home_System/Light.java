import java.util.*;

public class Light implements Device, Switchable, Subject {
    private final int id;
    private boolean isOn = false;
    private final List<Observer> observers = new ArrayList<>();

    public Light(int id) { this.id = id; }

    @Override
    public int getId() { return id; }

    @Override
    public String getType() { return "Light"; }

    @Override
    public String getStatus() { return isOn ? "ON" : "OFF"; }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light " + id + " is ON");
        notifyObservers("turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light " + id + " is OFF");
        notifyObservers("turned OFF");
    }

    @Override
    public Optional<Switchable> asSwitchable() { return Optional.of(this); }

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
