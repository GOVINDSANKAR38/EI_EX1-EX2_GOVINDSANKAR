###   Factory Pattern – Notification System

####  Overview
The **Factory Pattern** provides a method to create objects without exposing the instantiation logic.

####  Key Classes
- **NotificationFactory** → creates instances of notification types.  
- **Notification (Interface)** → base interface.  
- **EmailNotification, SMSNotification, PushNotification** → concrete implementations.  

####  Use Case in Project
Allows creation of different notification types dynamically, without changing client code.

####  How it Works
1. User specifies notification type.  
2. Factory method returns the corresponding object.  
3. Client calls `send()` on the abstract interface.  
