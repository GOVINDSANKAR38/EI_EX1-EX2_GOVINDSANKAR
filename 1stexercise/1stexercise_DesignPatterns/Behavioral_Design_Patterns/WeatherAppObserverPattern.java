import java.util.*;

interface WeatherObserver {
    void update(double temp, double humidity);
}


class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private double temperature, humidity;

    public void addObserver(WeatherObserver o) { observers.add(o); }
    public void removeObserver(WeatherObserver o) { observers.remove(o); }

    public void setMeasurements(double temp, double humidity) {
        this.temperature = temp;
        this.humidity = humidity;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver o : observers) o.update(temperature, humidity);
    }
}


class MobileApp implements WeatherObserver {
    public void update(double temp, double humidity) {
        System.out.println("Mobile App: Temp = " + temp + "°C, Humidity = " + humidity + "%");
    }
}

class LEDDisplay implements WeatherObserver {
    public void update(double temp, double humidity) {
        System.out.println("LED Display: Temp = " + temp + "°C, Humidity = " + humidity + "%");
    }
}


public class WeatherAppObserverPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeatherStation station = new WeatherStation();

        System.out.println("Select observers to add:");
        System.out.print("Add Mobile App? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) station.addObserver(new MobileApp());

        System.out.print("Add LED Display? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) station.addObserver(new LEDDisplay());

        System.out.println("Enter weather data.");

        while (true) {
            System.out.print("Enter temperature: ");
            double temp = sc.nextDouble();
            if (temp == -1) break;

            System.out.print("Enter humidity: ");
            double humidity = sc.nextDouble();
            if (humidity == -1) break;

            station.setMeasurements(temp, humidity);
        }

        System.out.println("Weather Station stopped.");
        sc.close();
    }
}
