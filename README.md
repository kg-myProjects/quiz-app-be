# Quiz App Backend
This is the backend of the Mini-Quiz application built with Spring Boot, Hibernate, and MariaDB.

## Setup & Run
1. **Start MariaDB via Docker Compose**
   In the root of the project (where `docker-compose.yml` is located), run:

   ```bash
   docker-compose up -d
   ```
2. This will start a MariaDB container with the following settings:
   Database: quizdb
   Username: root
   Password: password
   Port: 3306
3. The backend will connect to this database automatically using the application.yml configuration.
4. Start the backend
   You can run the backend in your IDE (Spring Boot application) or via Gradle:
    ```bash
    ./gradlew bootRun
   ```
5. The backend will:
   Connect to MariaDB
   Automatically create tables
    ```yaml
    spring.jpa.hibernate.ddl-auto: create-drop
   ```
6. Seed initial categories and questions
7. Log SQL queries to console
   ```yaml
   spring.jpa.show-sql: true
   ```

**Note: create-drop means that each time you restart the backend,
old tables are dropped and new ones are created. 
Seed data is re-inserted automatically.**

## Test the backend

1. Default test user and seed-data are available (hardcode)
2. API endpoints:
   GET /api/categories – list all categories with progress
   GET /api/categories/{id}/next-question – get next question in category
   POST /api/questions/{id}/answer – submit answer and get correctness
