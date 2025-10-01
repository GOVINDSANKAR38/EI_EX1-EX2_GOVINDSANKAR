###   Decorator Pattern – Pizza Order App

####  Overview
The **Decorator Pattern** attaches additional responsibilities to an object dynamically without changing its structure.

####  Key Classes
- **Pizza (Interface)** → base pizza.  
- **BasicPizza** → concrete pizza implementation.  
- **PizzaDecorator (Abstract)** → base decorator.  
- **Cheese, Olives, Mushrooms, Peppers, Jalapenos** → concrete decorators.  

####  Use Case in Project
Allows users to **add multiple toppings** dynamically and calculate total cost without modifying base pizza class.

####  How it Works
1. Base pizza is created.  
2. Toppings wrap the pizza object dynamically.  
3. Each decorator modifies description and cost.  
