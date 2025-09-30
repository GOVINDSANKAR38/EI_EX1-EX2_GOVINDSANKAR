import java.util.Optional;

public class DeviceProxy implements Device {
    private final Device realDevice;

    public DeviceProxy(Device realDevice) {
        this.realDevice = realDevice;
    }

    @Override
    public int getId() { return realDevice.getId(); }

    @Override
    public String getType() { return realDevice.getType(); }

    @Override
    public String getStatus() { return realDevice.getStatus(); }

    @Override
    public Optional<Switchable> asSwitchable() {
        return realDevice.asSwitchable();
    }

    @Override
    public Optional<Adjustable> asAdjustable() {
        return realDevice.asAdjustable();
    }

    @Override
    public Optional<Lockable> asLockable() {
        return realDevice.asLockable();
    }
    public void turnOn() {
        Optional<Switchable> cap = asSwitchable();
        if (cap.isPresent()) {
            System.out.println("[Proxy] Checking access to turn ON device " + getId() + "...");
            cap.get().turnOn();
        } else {
            System.out.println("Device " + getId() + " does not support ON operation.");
        }
    }

    public void turnOff() {
        Optional<Switchable> cap = asSwitchable();
        if (cap.isPresent()) {
            System.out.println("[Proxy] Checking access to turn OFF device " + getId() + "...");
            cap.get().turnOff();
        } else {
            System.out.println("Device " + getId() + " does not support OFF operation.");
        }
    }

    public void setTemperature(int t) {
        Optional<Adjustable> cap = asAdjustable();
        if (cap.isPresent()) {
            System.out.println("[Proxy] Checking access to set temperature for device " + getId() + "...");
            cap.get().setTemperature(t);
        } else {
            System.out.println("Device " + getId() + " is not adjustable.");
        }
    }

    public void lock() {
        Optional<Lockable> cap = asLockable();
        if (cap.isPresent()) {
            System.out.println("[Proxy] Checking access to lock device " + getId() + "...");
            cap.get().lock();
        } else {
            System.out.println("Device " + getId() + " is not lockable.");
        }
    }

    public void unlock() {
        Optional<Lockable> cap = asLockable();
        if (cap.isPresent()) {
            System.out.println("[Proxy] Checking access to unlock device " + getId() + "...");
            cap.get().unlock();
        } else {
            System.out.println("Device " + getId() + " is not lockable.");
        }
    }

    public Device getRealDevice() {
        return realDevice;
    }
}
