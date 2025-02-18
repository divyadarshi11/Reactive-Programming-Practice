# Reactive Programming - Practice Project

## Overview
This project is a hands-on practice for reactive programming using *Spring WebFlux* and *Project Reactor. It includes multiple examples covering key concepts like **Mono, Flux, Backpressure, Publishers, and Schedulers* to understand reactive streams and non-blocking execution.

## Technologies Used
- *Spring WebFlux* - Reactive web framework for non-blocking applications
- *Project Reactor* - Reactive programming library
- *Spring Boot* - Framework for building Java applications
- *Java 17+* - Recommended for best performance
- *Maven* - Build tools

## Project Structure
This repository contains multiple Java files, each demonstrating different aspects of reactive programming:

### *1. BackPressureExample.java*
   - Demonstrates how backpressure works in a reactive stream.
   - Shows how to control data flow between producer and consumer.

### *2. ListSetVsMonoFluxExample.java*
   - Compares different data structures (List, Set) with reactive types like *Mono* and *Flux*.
   - Explores performance differences and usage scenarios.

### *3. MonoFluxConversionExample.java*
   - Covers conversion between *Mono* and *Flux*.
   - Explains when to use each reactive type effectively.

### *4. MonoFluxExample.java*
   - Basic examples of *Mono* and *Flux*.
   - Demonstrates how to create and subscribe to reactive streams.

### *5. Monofluxexample2.java*
   - Additional advanced examples of using *Mono* and *Flux*.

### *6. PublisherExample.java*
   - Explains how to create a *Publisher* and subscribe to data streams.
   - Highlights different types of publishers in Project Reactor.

### *7. ReactiveProgrammingApplication.java*
   - Entry point for the application.
   - Configures and runs the reactive programming setup.

### *8. ReactiveStreamExample.java*
   - Provides detailed examples of working with *reactive streams*.
   - Implements data streaming with *Flux* and *Mono*.

### *9. SchedulersExample.java*
   - Demonstrates different *Schedulers* in Project Reactor.
   - Explains how to switch between *immediate, boundedElastic, parallel, and single* schedulers.

## Setup and Running the Project
### Prerequisites
- Install *Java 17+*
- Install *Maven*
- Install *Postman* (optional for API testing)

### Steps to Run
1. Clone the repository:
   git clone <repo-url>
   cd <project-folder>
   
2. Build the project:
   mvn clean install
   
3. Run the application:
   mvn spring-boot:run
   
## Kafka Demo Project
This demo project demonstrates how to set up and use Apache Kafka for messaging and event-driven systems. The project consists of:
Kafka Producer: Sends messages to a Kafka topic.
Kafka Consumer: Consumes messages from a Kafka topic.
Kafka Broker: Acts as the message queue where producers send messages and consumers read them.

## Running Steps
1. Install Kafka
Download Kafka from the official Apache Kafka website.
Extract the Kafka binaries and navigate to the Kafka directory.

3. Start Zookeeper (Required for Kafka)
Kafka relies on Zookeeper for managing distributed systems.
You can start Zookeeper using the following command:
bin/zookeeper-server-start.sh config/zookeeper.properties

5. Start Kafka Broker
Once Zookeeper is running, start the Kafka broker:
bin/kafka-server-start.sh config/server.properties

6. Create a Kafka Topic
Before producing and consuming messages, create a Kafka topic.
For example:
bin/kafka-topics.sh --create --topic demo-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

8. Running the Kafka Producer
Navigate to the producer directory:
cd producer
Run the Kafka producer:
java -jar producer.jar
This will send messages to the demo-topic.

10. Running the Kafka Consumer
Navigate to the consumer directory:
cd consumer
Run the Kafka consumer:
java -jar consumer.jar
The consumer will connect to the Kafka broker and consume messages from demo-topic.
11. Verify
After running both the producer and consumer, check the consumer logs. The messages sent from the producer should be displayed by the consumer

## Learning Resources
- [Spring WebFlux Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)
- [Project Reactor](https://projectreactor.io/docs/core/release/reference/)
- [Kafka](https://www.linkedin.com/learning/apache-kafka-essential-training)
  

