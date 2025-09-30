import java.util.Scanner;

interface PaymentGateway {
    void pay(int amount);
}

class PayPalGateway implements PaymentGateway {
    public void pay(int amount) { 
        System.out.println("Paid Rs " + amount + " via PayPal"); 
    }
}

class StripeAPI {
    public void makePayment(double amt) { 
        System.out.println("Paid Rs " + amt + " via Stripe"); 
    }
}

class GPayAPI {
    public void sendPayment(double amt) { 
        System.out.println("Paid Rs " + amt + " via GPay"); 
    }
}

class PaytmAPI {
    public void doPayment(double amt) { 
        System.out.println("Paid Rs " + amt + " via Paytm"); 
    }
}

class StripeAdapter implements PaymentGateway {
    private StripeAPI stripe = new StripeAPI();
    public void pay(int amount) { stripe.makePayment(amount); }
}

class GPayAdapter implements PaymentGateway {
    private GPayAPI gpay = new GPayAPI();
    public void pay(int amount) { gpay.sendPayment(amount); }
}

class PaytmAdapter implements PaymentGateway {
    private PaytmAPI paytm = new PaytmAPI();
    public void pay(int amount) { paytm.doPayment(amount); }
}

public class PaymentAppAdapterPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Available payment methods: paypal, stripe, gpay, paytm");
        System.out.print("Enter payment method: ");
        String method = sc.nextLine();

        System.out.print("Enter amount to pay: ");
        int amount = sc.nextInt();

        PaymentGateway payment;

        switch (method.toLowerCase()) {
            case "paypal" -> payment = new PayPalGateway();
            case "stripe" -> payment = new StripeAdapter();
            case "gpay" -> payment = new GPayAdapter();
            case "paytm" -> payment = new PaytmAdapter();
            default -> {
                System.out.println("Invalid payment method!");
                sc.close();
                return;
            }
        }

        payment.pay(amount);
        sc.close();
    }
}
