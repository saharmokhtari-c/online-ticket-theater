# 🎭 Theater Ticket Booking System (TeatroBooking)

A web-based application designed for browsing, selecting, and booking theater performance tickets across theaters in Italy. Developed as part of the technical-operational exam (Prova Tecnico-Operativa).

---

## 🛠️ Tech Stack

* *Backend:* Java 17+, Spring Boot (Spring MVC, Spring Data JPA)
* *Frontend:* HTML5, CSS3, JavaScript (ES6+)
* *Database:* MySQL
* *Build Tool:* Maven

---

## ✨ Key Features

* *Customer Authentication:* Secure client login using a unique Client Code (Codice Cliente).
* *Interactive Navigation:* Main menu dashboard to access system operations smoothly.
* *Shows & Replicas Overview:* Comprehensive view of shows per theater including:
  * Theater details and venue capacity
  * Show title, author, director, and pricing
  * Replica date and unique replica identification code
* *Ticket Reservation (BIGLIETTI):* Form interface allowing users to place bookings with:
  * Automatic progressive operation code (Codice Operazione)
  * Payment method selection (Carta di Credito or Bonifico)
  * Ticket quantity selection
* *Booking History Grid:* Structured data summary displaying customer details, show metadata, replica dates, payment methods, and venue details.

---

## 🗄️ Database Architecture

The application uses the biglietteria MySQL schema containing 5 core tables:

* *teatri*: Stores theater information including location, contact details, and seat capacity.
* *spettacoli*: Holds metadata for theatrical shows (title, author, director, price).
* *repliche*: Manages specific show schedules, dates, and replica codes.
* *clienti*: Contains customer records and authentication identifiers.
* *biglietti*: Stores ticket reservation transactions, payment methods, and quantities.

---

## 🚀 Getting Started

### Prerequisites

* *Java JDK 17* or higher
* *MySQL Server*
* *Maven* (or the included Maven Wrapper mvnw)

### Installation & Execution

1. *Clone the repository:*
   bash
   git clone https://github.com/your-username/project_biglietteria_final.git
   cd project_biglietteria_final
   

2. *Database Configuration:*
   Ensure the biglietteria schema is created in MySQL, then configure your credentials in src/main/resources/application.properties:
   properties
   spring.datasource.url=jdbc:mysql://localhost:3306/biglietteria
   spring.datasource.username=YOUR_MYSQL_USERNAME
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   

3. *Run the Application:*
   Using Windows Command Prompt / Terminal:
   cmd
   mvnw.cmd spring-boot:run
   

4. *Access in Browser:*
   Open your browser and visit: http://localhost:8080

---

## 📂 Project Structure

text
project_biglietteria_final/
├── src/
│   ├── main/
│   │   ├── java/            # Controllers, Entities, Repositories, Services
│   │   └── resources/
│   │       ├── static/      # CSS styles, JavaScript scripts
│   │       ├── templates/   # HTML views
│   │       └── application.properties
├── .gitignore
└── pom.xml                  # Maven dependencies