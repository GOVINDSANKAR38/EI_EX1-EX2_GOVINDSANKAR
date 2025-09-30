#Smart Home System
Problem

Simulate a smart home environment with devices such as lights, thermostats, and door locks. The system allows controlling these devices via commands through a console-based interface.

Features

Add and remove devices dynamically

Turn lights on/off

Set thermostat temperature

Lock/unlock doors

Schedule device actions (e.g., turn off after N seconds)

Automation: turn off all lights if the temperature exceeds a threshold

Logging of device actions via proxy

Design Patterns Used

Factory Pattern – for creating devices dynamically

Proxy Pattern – to control access and log device actions

Observer Pattern – for automation triggers (optional)

Singleton (ScheduledExecutorService) – for scheduling tasks

Interface Segregation – devices implement only relevant capabilities

Usage

The console menu displays options to:

Add/Remove devices

Turn on/off devices

Set thermostat temperature

Lock/unlock doors

Schedule device actions

Run automation checks

Input the required IDs, commands, or values as prompted.

The program continues running until you select the Exit option.
