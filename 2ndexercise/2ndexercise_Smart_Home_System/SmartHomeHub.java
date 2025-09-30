import java.util.*;
import java.util.concurrent.*;

public class SmartHomeHub implements Observer {

    private final Map<Integer, DeviceProxy> devices = new LinkedHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    public void addDevice(DeviceProxy proxy) {
        devices.put(proxy.getId(), proxy);
        System.out.println("Added " + proxy.getType() + " with ID " + proxy.getId());
        if (proxy.getRealDevice() instanceof Subject) {
            ((Subject) proxy.getRealDevice()).addObserver(this);
        }
    }

    public void removeDevice(int id) {
        DeviceProxy removed = devices.remove(id);
        if (removed != null) {
            System.out.println("Removed device " + id);
            if (removed.getRealDevice() instanceof Subject) {
                ((Subject) removed.getRealDevice()).removeObserver(this);
            }
        } else {
            System.out.println("Device not found");
        }
    }

    public void turnOn(int id) {
        DeviceProxy proxy = devices.get(id);
        if (proxy == null) { System.out.println("Device not found"); return; }
        proxy.turnOn();
    }

    public void turnOff(int id) {
        DeviceProxy proxy = devices.get(id);
        if (proxy == null) { System.out.println("Device not found"); return; }
        proxy.turnOff();
    }

    public void setTemperature(int id, int temp) {
        DeviceProxy proxy = devices.get(id);
        if (proxy == null) { System.out.println("Device not found"); return; }
        proxy.setTemperature(temp);
    }

    public void lockDoor(int id) {
        DeviceProxy proxy = devices.get(id);
        if (proxy == null) { System.out.println("Device not found"); return; }
        proxy.lock();
    }

    public void unlockDoor(int id) {
        DeviceProxy proxy = devices.get(id);
        if (proxy == null) { System.out.println("Device not found"); return; }
        proxy.unlock();
    }

    public void scheduleTurnOff(int id, int delayMillis) {
        DeviceProxy proxy = devices.get(id);
        if (proxy == null) { System.out.println("Device not found"); return; }
        scheduler.schedule(() -> {
            proxy.turnOff();
            System.out.println("Scheduled task: Device " + id + " turned off.");
        }, delayMillis, TimeUnit.MILLISECONDS);
        System.out.println("Scheduled device " + id + " to turn off in " + delayMillis + " ms");
    }

    public void showStatus() {
        System.out.println("\n--- Device Status ---");
        for (DeviceProxy proxy : devices.values()) {
            System.out.println("Device " + proxy.getId() + " [" + proxy.getType() + "]: " + proxy.getStatus());
        }
    }

    public void autoCheckTemperatureAndTurnOffLights(int threshold) {
        for (DeviceProxy proxy : devices.values()) {
            Device real = proxy.getRealDevice();
            if (real instanceof Thermostat) {
                int temp = ((Thermostat) real).getTemperature();
                if (temp > threshold) {
                    System.out.println("Automation: Thermostat " + real.getId() + " is " + temp + "°F (> " + threshold + "). Turning off all lights.");
                    devices.values().forEach(p -> p.asSwitchable().ifPresent(Switchable::turnOff));
                }
            }
        }
    }
    @Override
    public void update(Device device, String event) {
        System.out.println("[Observer] Device " + device.getId() + " [" + device.getType() + "] event: " + event);
    }

    public void shutdown() {
        scheduler.shutdownNow();
        System.out.println("Scheduler shut down.");
    }
}
