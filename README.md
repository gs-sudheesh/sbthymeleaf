Spring Boot Thymeleaf H2 Demo App

This is a simple demo application that integrates Spring Boot, Thymeleaf for server-side rendering, H2 as an in-memory database, and Bootstrap for CSS styling. The application demonstrates basic CRUD operations in a web-based environment.

Features

	•	Spring Boot backend with Thymeleaf as the template engine
	•	H2 in-memory database for data persistence
	•	HTML views styled with Bootstrap
	•	Basic CRUD functionality through a user-friendly interface

Technologies Used

	•	Spring Boot - Backend framework
	•	Thymeleaf - Template engine for dynamic HTML rendering
	•	H2 Database - In-memory database for easy setup
	•	Bootstrap - CSS framework for responsive design
	•	HTML/CSS - For the user interface

Prerequisites

	•	Java 17 or higher
	•	Maven

Getting Started

1. Clone the Repository

git clone https://github.com/yourusername/spring-boot-thymeleaf-h2-demo.git
cd sbthymeleaf

2. Build the Project

Use Maven to build the project:

mvn clean install

3. Run the Application

mvn spring-boot:run

The application will start running at http://localhost:8080.

4. Access the H2 Database Console

Visit the H2 console at http://localhost:8080/h2-console. The default JDBC URL is jdbc:h2:mem:testdb.


Usage

	1.	Landing Page - Lists all items in the database (As in-memory database is used, no data will be shown on boot-up).
	2.	Add User page - Allows adding a new user to the list.



Additional Information

	•	To change the default port, update the server.port property in application.properties.
	•	H2 is an in-memory database; the data is not persistent across restarts. For production use, replace it with a more permanent database like PostgreSQL or MySQL.
