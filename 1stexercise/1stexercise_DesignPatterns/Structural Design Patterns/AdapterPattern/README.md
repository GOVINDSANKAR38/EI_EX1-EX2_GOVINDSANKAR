###   Adapter Pattern – Payment Gateway Integration

####  Overview
The **Adapter Pattern** allows incompatible interfaces to work together by converting one interface into another.

####  Key Classes
- **PaymentGateway (Interface)** → expected payment interface.  
- **PayPalGateway** → native implementation.  
- **StripeAPI, GPayAPI, PaytmAPI** → third-party APIs with different methods.  
- **StripeAdapter, GPayAdapter, PaytmAdapter** → adapters that implement PaymentGateway.  

####  Use Case in Project
Integrates multiple payment APIs under a single, consistent interface.

####  How it Works
1. User selects a payment method.  
2. Adapter wraps the third-party API.  
3. Client calls `pay()` method uniformly, regardless of underlying API.  
