# 🏠 Smart Home System

![Java](https://img.shields.io/badge/Language-Java-blue) ![SOLID Principles](https://img.shields.io/badge/SOLID-Principles-green) ![Console App](https://img.shields.io/badge/Interface-Terminal-orange)

---

## Project Overview
The **Smart Home System** simulates a connected home environment, allowing users to manage devices like **Lights, Thermostats, and Door Locks** via a **Terminal-based interactive interface**. The project focuses on **clean code, OOP, SOLID principles, and design patterns**, making it **extensible and maintainable**.

---

## Features
- **Dynamic Device Management** – Add or remove devices at runtime  
- **Device Control**:
  - Lights – Turn ON/OFF  
  - Thermostat – Set temperature  
  - Door Locks – Lock/Unlock  
- **Scheduled Tasks** – Perform actions after a delay  
- **Automation Rules** – Example: Turn off all lights if temperature exceeds threshold  
- **Proxy Logging** – Tracks device actions  
- **Interactive Console Menu** – Easy to operate without GUI  

---

## Design Patterns Implemented
- **Factory Pattern** – Dynamically create devices  
- **Proxy Pattern** – Control access and log actions  
- **Observer Pattern** – Monitor device states for automation  
- **Singleton Pattern** – Manage scheduler service  
- **Interface Segregation (ISP)** – Separate interfaces for Switchable, Adjustable, Lockable  

---

## SOLID Principles
- **S** – Single Responsibility: Classes handle one responsibility only  
- **O** – Open/Closed: Easily extendable without modifying existing code  
- **L** – Liskov Substitution: Devices can be used interchangeably via interfaces  
- **I** – Interface Segregation: Only implement interfaces relevant to the device  
- **D** – Dependency Inversion: SmartHomeHub depends on abstractions, not concrete classes  

---

## Getting Started

### Requirements
- Java 20 or higher  
- Terminal/Command Prompt  

### Run the Project
1. Navigate to the `src` folder of the first exercise:
```bash
cd 1stexercise_DesignPatterns

