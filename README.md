# Java Design Patterns & Smart Home System  

This repository contains **two Java console applications** demonstrating **Behavioral, Creational, and Structural design patterns** along with **SOLID principles**.  
Both projects use **interactive terminal input** to showcase practical applications of design patterns in real-world scenarios.

---
##  Exercise 1- Design Patterns Examples 

![Java](https://img.shields.io/badge/Language-Java-blue) ![Console App](https://img.shields.io/badge/Interface-Terminal-orange)

---

## Project Overview
This project demonstrates **Behavioral, Creational, and Structural design patterns** in Java. Each pattern is implemented with **interactive console input**, making it easy to test and understand their usage in real-world scenarios.  

---

## Features
- **Behavioral Patterns**:
  - Strategy Pattern – Calculate trip cost based on travel mode  
  - Observer Pattern – Monitor weather data in real-time  

- **Creational Patterns**:
  - Singleton Pattern – Manage a database connection pool  
  - Factory Pattern – Dynamically create notifications (Email/SMS/Push)  

- **Structural Patterns**:
  - Decorator Pattern – Add toppings dynamically to a pizza order  
  - Adapter Pattern – Use multiple payment gateways (PayPal, Stripe, GPay, Paytm) through a unified interface  

---

## Getting Started

### Requirements
- Java 20 or higher  
- Terminal/Command Prompt  

#### Compile and Run
1. Navigate to the folder:
### cd 1stexercise_DesignPatterns


##   Exercise 2 – Smart Home System

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

1. Navigate to the `2ndexercise_DesignPatterns` folder of the 2nd exercise and run the application:

```bash

cd 2ndexercise_DesignPatterns

java Main



