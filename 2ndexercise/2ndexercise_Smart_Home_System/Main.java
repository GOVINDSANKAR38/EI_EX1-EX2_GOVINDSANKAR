import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        Scanner sc = new Scanner(System.in);
        hub.addDevice(new DeviceProxy(DeviceFactory.createDevice(1, "light")));
        hub.addDevice(new DeviceProxy(DeviceFactory.createDevice(2, "thermostat")));
        hub.addDevice(new DeviceProxy(DeviceFactory.createDevice(3, "door")));

        System.out.println(" Welcome to Smart Home System");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Device");
            System.out.println("2. Remove Device");
            System.out.println("3. Turn On/Off Device");
            System.out.println("4. Set Thermostat Temperature");
            System.out.println("5. Lock/Unlock Door");
            System.out.println("6. Schedule Device (turn off after N seconds)");
            System.out.println("7. Show Status");
            System.out.println("8. Run automation check (temp > threshold)");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try { choice = Integer.parseInt(sc.next()); }
            catch (Exception e) { System.out.println("Invalid input"); continue; }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter device id: ");
                    int id = sc.nextInt();
                    System.out.print("Enter device type (light/thermostat/door): ");
                    String type = sc.next();
                    try {
                        hub.addDevice(new DeviceProxy(DeviceFactory.createDevice(id, type)));
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Unknown device type.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter device id to remove: ");
                    int id = sc.nextInt();
                    hub.removeDevice(id);
                }
                case 3 -> {
                    System.out.print("Enter device id: ");
                    int id = sc.nextInt();
                    System.out.print("Turn on or off? (on/off): ");
                    String act = sc.next();
                    if (act.equalsIgnoreCase("on")) hub.turnOn(id);
                    else hub.turnOff(id);
                }
                case 4 -> {
                    System.out.print("Enter thermostat id: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new temperature: ");
                    int t = sc.nextInt();
                    hub.setTemperature(id, t);
                }
                case 5 -> {
                    System.out.print("Enter door id: ");
                    int id = sc.nextInt();
                    System.out.print("Lock or unlock? (lock/unlock): ");
                    String a = sc.next();
                    if (a.equalsIgnoreCase("lock")) hub.lockDoor(id);
                    else hub.unlockDoor(id);
                }
                case 6 -> {
                    System.out.print("Enter device id to schedule OFF: ");
                    int id = sc.nextInt();
                    System.out.print("Enter delay seconds: ");
                    int secs = sc.nextInt();
                    hub.scheduleTurnOff(id, secs * 1000);
                }
                case 7 -> hub.showStatus();
                case 8 -> {
                    System.out.print("Enter temperature threshold (°F): ");
                    int threshold = sc.nextInt();
                    hub.autoCheckTemperatureAndTurnOffLights(threshold);
                }
                case 9 -> {
                    running = false;
                    System.out.println("Exiting. Shutting down scheduler...");
                    hub.shutdown();
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
