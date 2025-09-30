import java.util.Scanner;

class DatabaseConnection {
    private static DatabaseConnection instance;
    private int connections;
    private int maxConnections;

    private DatabaseConnection(int maxConnections) {
        this.maxConnections = maxConnections;
        this.connections = maxConnections;
        System.out.println("Database Connection Pool created with " + maxConnections + " connections");
    }
    public static synchronized DatabaseConnection getInstance(int maxConnections) {
        if (instance == null) {
            instance = new DatabaseConnection(maxConnections);
        } else {
            System.out.println("Singleton already initialized with " + instance.maxConnections + " connections");
        }
        return instance;
    }

    public synchronized boolean getConnection() {
        if (connections > 0) {
            connections--;
            System.out.println("Connection granted. Remaining: " + connections);
            return true;
        }
        System.out.println("No connections available!");
        return false;
    }

    public synchronized void releaseConnection() {
        if (connections < maxConnections) {
            connections++;
            System.out.println("Connection released. Remaining: " + connections);
        } else {
            System.out.println("All connections are already free.");
        }
    }
}

public class DatabaseAppSingletonPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of connections for the pool: ");
        int maxConnections = sc.nextInt();
        DatabaseConnection pool1 = DatabaseConnection.getInstance(maxConnections);
        pool1.getConnection();
        pool1.getConnection();
        DatabaseConnection pool2 = DatabaseConnection.getInstance(10);
        pool2.releaseConnection();

        System.out.println("Same instance? " + (pool1 == pool2));

        sc.close();
    }
}

