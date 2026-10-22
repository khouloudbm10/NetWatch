<<<<<<< HEAD

# NetWatch — Network Monitoring & Diagnostics

NetWatch is a Java-based network diagnostics project
designed to explore host reachability, TCP connectivity,
connection timing, and basic troubleshooting.

## Features

- Hostname resolution and IP address display
- Basic host reachability checks
- TCP connection testing for a specified port
- Connection timing measurements
- Input validation and error handling
- CSV diagnostic reports (planned enhancement)

## Technologies

- Java 17
- Java Networking API
- TCP/IP fundamentals
- Git and GitHub

## Requirements

- JDK 17 or compatible version
- Terminal or Java IDE

## Run

Compile:

    javac -d out src/NetWatch.java

Execute:

    java -cp out NetWatch

Follow the prompts to enter a hostname or IP address
and one TCP port.

## Learning Objectives

- Understand hostname resolution
- Explore TCP client connections
- Measure connection latency
- Interpret connectivity failures
- Practice Java exception handling

## Limitations

A failed connection does not prove that a host is offline
or that a port is closed. Firewalls, routing, and service
availability can affect results.

Use only on systems you own or are authorized to test.

## Roadmap

- [ ] CSV report export
- [ ] Repeated monitoring
- [ ] Historical availability statistics
- [ ] Java Swing dashboard
- [ ] Automated tests
=======
# NetWatch
Java-based network monitoring and TCP diagnostics tool
>>>>>>> 