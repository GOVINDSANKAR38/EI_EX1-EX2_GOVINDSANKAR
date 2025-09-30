import java.util.Scanner;

interface TravelStrategy {
    double calculateCost(double distance);
}

class CarTravel implements TravelStrategy {
    public double calculateCost(double distance) { return distance * 8; }
}

class TrainTravel implements TravelStrategy {
    public double calculateCost(double distance) { return distance * 2.5; }
}

class FlightTravel implements TravelStrategy {
    public double calculateCost(double distance) { return 5000 + distance * 10; }
}

class Trip {
    private TravelStrategy strategy;
    private double distance;

    public Trip(double distance) { this.distance = distance; }

    public void setStrategy(TravelStrategy strategy) { this.strategy = strategy; }

    public void showCost() {
        if (strategy == null) {
            System.out.println("No travel strategy selected!");
            return;
        }
        System.out.println("Trip cost: Rs " + strategy.calculateCost(distance));
    }
}

public class TravelAppStrategyPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter trip distance: ");
        double distance = sc.nextDouble();
        sc.nextLine(); 

        Trip trip = new Trip(distance);

        System.out.println("Choose travel mode: car, train, flight");
        System.out.print("Enter mode: ");
        String mode = sc.nextLine();

        switch (mode.toLowerCase()) {
            case "car" -> trip.setStrategy(new CarTravel());
            case "train" -> trip.setStrategy(new TrainTravel());
            case "flight" -> trip.setStrategy(new FlightTravel());
            default -> {
                System.out.println("Invalid travel mode!");
                sc.close();
                return;
            }
        }

        trip.showCost();
        sc.close();
    }
}
