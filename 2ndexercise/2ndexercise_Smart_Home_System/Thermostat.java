import java.util.*;

public class Thermostat implements Device, Adjustable, Subject {
    private final int id;
    private int temperature = 70;
    private final List<Observer> observers = new ArrayList<>();

    public Thermostat(int id) { this.id = id; }

    @Override
    public int getId() { return id; }

    @Override
    public String getType() { return "Thermostat"; }

    @Override
    public String getStatus() { return temperature + "°F"; }

    @Override
    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Thermostat " + id + " set to " + temp + "°F");
        notifyObservers("temperature set to " + temp + "°F");
    }

    
    public int getTemperature() { return temperature; }

    @Override
    public Optional<Adjustable> asAdjustable() { return Optional.of(this); }

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
