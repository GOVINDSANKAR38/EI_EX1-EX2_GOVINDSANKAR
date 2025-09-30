import java.util.Optional;

public interface Device {
    int getId();
    String getType();
    String getStatus();
    default Optional<Switchable> asSwitchable() { return Optional.empty(); }
    default Optional<Adjustable> asAdjustable() { return Optional.empty(); }
    default Optional<Lockable> asLockable() { return Optional.empty(); }
}
