
###   Observer Pattern – Weather Station

####  Overview
The **Observer Pattern** defines a one-to-many dependency between objects.  
When the state of one object (subject) changes, all its dependents (observers) are notified automatically.

####  Key Classes
- **WeatherStation (Subject)** → maintains weather data and notifies observers.  
- **WeatherObserver (Interface)** → declares the update method.  
- **MobileApp, LEDDisplay (Concrete Observers)** → implement update to display weather.  

####  Use Case in Project
Useful when multiple displays or apps need **live weather updates** dynamically.

####  How it Works
1. Observers register with the `WeatherStation`.  
2. When temperature or humidity updates, `WeatherStation` calls `notifyObservers()`.  
3. All registered observers receive updated data automatically. 
