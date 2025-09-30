import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DeviceFactory {
    private static final Map<String, Function<Integer, Device>> registry = new HashMap<>();

    static {
        registerDevice("light", Light::new);
        registerDevice("thermostat", Thermostat::new);
        registerDevice("door", DoorLock::new);
    }

    public static void registerDevice(String type, Function<Integer, Device> constructor) {
        registry.put(type.toLowerCase(), constructor);
    }

    public static Device createDevice(int id, String type) {
        Function<Integer, Device> constructor = registry.get(type.toLowerCase());
        if (constructor == null) {
            throw new IllegalArgumentException("Unknown device type: " + type);
        }
        return constructor.apply(id);
    }
}
