# ProgettoOOP Development Guide

This document provides guidelines for contributing to the Fiera management application.

## Prerequisites

- **Java Development Kit (JDK):** Version 23 or higher.
- **Maven:** For project management and dependencies.
- **PostgreSQL:** For data persistence. Ensure you have the database set up and credentials updated in `src/main/java/database/ConnessioneDatabase.java` if necessary.

## Architecture Overview

The project follows a standard layered architecture:

- **Model (`src/main/java/model/`)**: Plain Java objects (POJOs) representing domain entities (e.g., `Evento`, `Utente`, `Stand`).
- **DAO (`src/main/java/dao/`)**: Interfaces defining data access methods.
- **DAO Implementation (`src/main/java/implementazionePostgresDAO/`)**: Concrete implementations of DAO interfaces using SQL/JDBC to interact with PostgreSQL.
- **Controller (`src/main/java/controller/`)**: Coordinates between the GUI and the Data layer.
- **View (`src/main/java/gui/`)**: Java Swing interfaces for user interaction.

## Development Workflow: Adding a New Feature

When adding a new entity or feature:

1.  **Define the Model:** Create a new class in `src/main/java/model/` with necessary fields, getters, setters, and constructors.
2.  **Define DAO Interface:** Create an interface in `src/main/java/dao/` defining CRUD operations for the new model.
3.  **Implement DAO:** Create a class in `src/main/java/implementazionePostgresDAO/` that implements your DAO interface, using JDBC to execute SQL queries against the database.
4.  **Update Controller:** Add methods to `src/main/java/controller/Controller.java` to act as the bridge between the UI and the DAO.
5.  **Build the GUI:** Create a new JFrame or JPanel in `src/main/java/gui/`.

## GUI Development (Java Swing)

The project uses Java Swing for the graphical user interface.

- **Layout Managers:** Prefer using Layout Managers (`BorderLayout`, `GridBagLayout`, `FlowLayout`) over absolute positioning for responsive and maintainable UIs.
- **Forms:** While the project contains `.form` files (likely for the IntelliJ GUI Designer), you can also write the GUI code manually in Java classes.
- **Event Handling:** Use `ActionListener` or lambda expressions (`e -> ...`) to handle button clicks and other user interactions.
- **Threading:** Always perform long-running database operations (via Controller/DAO) in a background thread to keep the UI responsive. Use `SwingUtilities.invokeLater` to update the GUI from background threads.

## Running the Application

To compile and run the project:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="Main"
```

*Note: Ensure your database connection settings are correct before running.*
