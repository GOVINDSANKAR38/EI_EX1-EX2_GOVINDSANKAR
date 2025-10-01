###   Singleton Pattern – Database Connection Pool

####  Overview
The **Singleton Pattern** ensures only one instance of a class exists globally and provides a single point of access.

####  Key Classes
- **DatabaseConnection** → manages a pool of database connections.  

####  Use Case in Project
Ensures only **one database connection pool** exists across the application.

####  How it Works
1. Private constructor prevents direct instantiation.  
2. Static `getInstance()` method returns the single instance.  
3. Connection methods manage allocation and release of connections.
