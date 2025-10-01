
### 🔹 Strategy Pattern – Trip Cost Calculator

#### 📖 Overview
The **Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable.  
It allows the algorithm to vary independently from the clients that use it.

#### 🏗 Key Classes
- **TravelStrategy (Interface)** → defines `calculateCost`.  
- **CarTravel, TrainTravel, FlightTravel** → concrete strategies implementing cost calculation.  
- **Trip** → context class that uses a strategy to calculate cost.  

#### 💡 Use Case in Project
Allows the user to select different travel modes dynamically, calculating trip costs without changing Trip class logic.

#### ⚙️ How it Works
1. `Trip` holds a reference to `TravelStrategy`.  
2. User selects travel mode at runtime.  
3. `Trip` delegates cost calculation to the selected strategy.  

