import java.util.Scanner;
import java.util.List;

interface Pizza {
    String getDescription();
    double getCost();
}


class BasicPizza implements Pizza {
    public String getDescription() { return "Basic Pizza"; }
    public double getCost() { return 200; }
}


abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() { return pizza.getDescription(); }
    public double getCost() { return pizza.getCost(); }
}


class Cheese extends PizzaDecorator {
    public Cheese(Pizza p) { super(p); }
    public String getDescription() { return pizza.getDescription() + ", Cheese"; }
    public double getCost() { return pizza.getCost() + 50; }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza p) { super(p); }
    public String getDescription() { return pizza.getDescription() + ", Olives"; }
    public double getCost() { return pizza.getCost() + 30; }
}

class Mushrooms extends PizzaDecorator {
    public Mushrooms(Pizza p) { super(p); }
    public String getDescription() { return pizza.getDescription() + ", Mushrooms"; }
    public double getCost() { return pizza.getCost() + 40; }
}

class Peppers extends PizzaDecorator {
    public Peppers(Pizza p) { super(p); }
    public String getDescription() { return pizza.getDescription() + ", Peppers"; }
    public double getCost() { return pizza.getCost() + 35; }
}

class Jalapenos extends PizzaDecorator {
    public Jalapenos(Pizza p) { super(p); }
    public String getDescription() { return pizza.getDescription() + ", Jalapenos"; }
    public double getCost() { return pizza.getCost() + 45; }
}

public class FoodOrderAppDecoratorPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pizza order = new BasicPizza();

        System.out.println("Welcome to Pizza Order App!");
        System.out.println("Base pizza cost: Rs.200");

        List<String> toppings = List.of("Cheese", "Olives", "Mushrooms", "Peppers", "Jalapenos");

        while (true) {
            System.out.println("\nAvailable toppings:");
            for (int i = 0; i < toppings.size(); i++) {
                System.out.println((i + 1) + ". " + toppings.get(i));
            }
            System.out.println("0. Finish order");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 0) break;

            switch (choice) {
                case 1 -> order = new Cheese(order);
                case 2 -> order = new Olives(order);
                case 3 -> order = new Mushrooms(order);
                case 4 -> order = new Peppers(order);
                case 5 -> order = new Jalapenos(order);
                default -> System.out.println("Invalid choice! Try again.");
            }

            System.out.println("Current order: " + order.getDescription() + " Rs." + order.getCost());
        }

        System.out.println("\nFinal Order: " + order.getDescription() + " Rs." + order.getCost());
        System.out.println("Thank you for ordering!");
        sc.close();
    }
}
