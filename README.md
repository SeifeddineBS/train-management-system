# Spring Boot Train Management System

## Project Overview

This project is a **Train Management System** built with **Spring Boot**. It allows users to manage trains, voyages, and voyageurs (travelers). Users can perform operations such as adding trains, voyages, voyageurs, assigning voyages to trains, assigning trains to voyageurs, and checking available seats. The project exposes a series of RESTful APIs for interacting with these entities.

## Features

- **Add a Voyage:** Create and add a new voyage to the system.
- **Add a Train:** Create and add a new train to the system.
- **Add a Voyageur:** Create and add a new traveler (voyageur) to the system.
- **Assign Train to Voyage:** Assign a specific train to a voyage.
- **Assign Train to Voyageur:** Assign a train to a traveler based on departure and arrival stations.
- **List Trains with Available Seats:** Retrieve trains that have free seats available.
- **List Indirect Trains:** Get indirect trains between two stations.
- **Unassign Voyageur from Train:** Remove travelers from a train.

## Technologies Used

- **Java**
- **Spring Boot** (for building the REST APIs)
- **Maven** (for dependency management)
- **Spring Data JPA** (for database interaction)
- **Hibernate** (ORM for managing persistence)
- **H2/ MySQL** (for database, depending on configuration)

## Prerequisites

- Java 11 or later
- Maven 3.6+
- IDE (e.g., IntelliJ IDEA or Eclipse)

## Installation and Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/train-management-system.git
   cd train-management-system
   ```

2. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**
   Once the application is running, you can access the API through `http://localhost:8083/SpringMVC/`.

## API Endpoints

### Voyage Endpoints
- **POST** `/ajouterVoyage`
  - Adds a new voyage.
  - Request Body: `Voyage`
  
### Train Endpoints
- **POST** `/ajouterTrain`
  - Adds a new train.
  - Request Body: `Train`
  
- **GET** `/TrainPlacesLibres/{nomgdpt}`
  - Fetches the number of available seats on trains departing from a given station.
  - Path Variable: `nomgdpt` (departure station name)

### Voyageur Endpoints
- **POST** `/ajouterVoyageur`
  - Adds a new traveler (voyageur).
  - Request Body: `Voyageur`
  
- **PUT** `/affecterTrainAVoyageur/{idc}/{nomgdpt}/{nomgarr}/{heuredept}`
  - Assigns a train to a voyageur based on the departure and arrival stations.
  - Path Variables: 
    - `idc` (voyageur ID)
    - `nomgdpt` (departure station)
    - `nomgarr` (arrival station)
    - `heuredept` (departure time)

### Train and Voyage Assignments
- **PUT** `/affecterTrainAVoyage/{idtr}/{idvyg}`
  - Assigns a train to a voyage.
  - Path Variables:
    - `idtr` (train ID)
    - `idvyg` (voyage ID)

- **GET** `/ListerTrainsIndirects/{nomgdpt}/{nomgarr}`
  - Lists indirect trains between two stations.
  - Path Variables:
    - `nomgdpt` (departure station)
    - `nomgarr` (arrival station)

- **PUT** `/DesaffecterVoyageursTrain/{nomgdpt}/{heuredept}`
  - Unassigns voyageurs from a train based on departure station and time.
  - Path Variables:
    - `nomgdpt` (departure station)
    - `heuredept` (departure time)

## Project Structure

- **`controller/RestControllerVoyageur.java`:** Contains the REST API endpoints for managing voyageurs, voyages, and trains.
- **`entities/`:** Contains the entity classes for `Voyageur`, `Train`, `Voyage`, and `Ville`.
- **`services/`:** Service interfaces and implementations for managing the business logic related to voyages, trains, and voyageurs.
- **`repository/`:** Data access layer for interacting with the database.