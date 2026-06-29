# 🚀 ProgettoOOP Development Guide

Welcome! This guide is designed to help you navigate, develop, and document your Fair (Fiera) Management application. Don't worry if this is your first large project—we'll take it step-by-step.

---

## 🏗️ Architecture: How the Code is Organized
To keep things organized, we use a "layered" approach (Separation of Concerns). Think of it like a restaurant:

- **Model (`src/main/java/model/`)**: The **Ingredients**. These are simple Java classes representing your data (e.g., `Evento`, `Utente`, `Stand`).
- **DAO (`src/main/java/dao/`)**: The **Chef's Recipe**. These interfaces define how to interact with the database.
- **DAO Implementation (`src/main/java/implementazionePostgresDAO/`)**: The **Preparation**. The actual SQL code that talks to your database.
- **Controller (`src/main/java/controller/`)**: The **Manager**. This connects the GUI to the Data, ensuring everything works together.
- **View (`src/main/java/gui/`)**: The **Dining Room**. What the user sees and interacts with (Java Swing).

---

## 🛠️ Your Workflow (Adding a New Feature)
When you want to add something new (e.g., a "Ticket Booking" feature):

1.  **Model**: Create a new class in `model/`.
2.  **DAO Interface**: Define what actions you need (e.g., `getTicket`, `saveTicket`).
3.  **Implement DAO**: Write the SQL queries to make those actions happen in the database.
4.  **Controller**: Add a method to bridge the UI to the database code.
5.  **GUI**: Build a new screen or add buttons/fields to existing screens to use your new feature.

---

## 📝 Documentation: Your Roadmap
Documentation is just as important as the code. Keep it updated as you go!

### Homework 1 (Domain Model)
- Focus: Define what the system represents.
- Deliverable: Class Diagram showing core entities.

### Homework 2 (Detailed Design)
- Focus: How the code actually connects.
- Deliverable: Detailed Class Diagram including Model, Controller, and GUI classes.

### Homework 3 (Final Documentation)
- Focus: How to use it and how it works.
- Deliverable:
    - **Updated Detailed Class Diagram**: Showing all classes.
    - **Sequence Diagrams**: Choose 2-3 important features and map out the step-by-step communication between classes.
    - **User Manual**: A short document explaining how to use your app.
    - **Repo Link**: The URL to your final GitHub repository.

---

## 🔗 Useful Learning Resources
Need help? Check out these beginner-friendly resources:

- **Java Swing (The GUI)**: [Oracle's Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- **UML Diagrams**: [Visual Paradigm UML Guide](https://www.visual-paradigm.com/guide/uml-diagramming/)
- **PostgreSQL**: [Official Documentation](https://www.postgresql.org/docs/)
- **Git (Version Control)**: [Git Documentation](https://git-scm.com/doc)

---

## 🏃 Running the Application
To run your project from the terminal:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="Main"
```

*Pro-tip: Always make sure your PostgreSQL database is running before starting the app!*
