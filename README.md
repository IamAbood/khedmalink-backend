# KhedmaLink Backend

KhedmaLink Backend is the server-side component of the KhedmaLink platform, providing RESTful APIs to connect freelancers and recruiters, manage projects, users, requests, and more. It is built with Java and Spring Boot.

## Project Structure

- **This repository:** Java Spring Boot backend (REST API)
- **Mobile App:** [khedmalink-app](https://github.com/IamAbood/khedmalink-app)
- **Website:** [khedmalink-website](https://github.com/IamAbood/khedmalink-website)

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/IamAbood/khedmalink-backend.git
cd khedmalink-backend
```

### 2. Prerequisites

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/install.html)
- (Optional) [MySQL](https://www.mysql.com/) or your preferred database

### 3. Configure the Application

Edit `src/main/resources/application.properties` to set your database connection and other environment-specific settings.

### 4. Run Database Migrations

If you need to set up the database schema, use the provided `khedma_link.sql` file:

```bash
# Example for MySQL
mysql -u <username> -p <database_name> < khedma_link.sql
```

### 5. Build and Run the Application

```bash
./mvnw spring-boot:run
```
Or, if you have Maven installed globally:
```bash
mvn spring-boot:run
```

The backend will start on the default port (usually 8080). You can test the API using tools like Postman or cURL.

### 6. (Optional) Run with IntelliJ IDEA

1. Open IntelliJ IDEA and select **Open**.
2. Navigate to the cloned `khedmalink-backend` directory and open it.
3. Let IntelliJ import the Maven project and download dependencies.
4. Open `KhedmaLinkApplication.java` (in `src/main/java/com/abod/khedma_link/`).
5. Right-click the file and select **Run 'KhedmaLinkApplication.main()'**.

---

## Brief Explanation

KhedmaLink Backend powers the core logic and data management for the KhedmaLink platform. It provides endpoints for:

- Project posting and management
- User registration, authentication, and profiles
- Request handling (e.g., job applications, team invites)
- Ratings and reviews
- Notifications and messaging

The backend is designed to be consumed by the Flutter mobile app and the web frontend.

---

## Related Repositories

- **Mobile App:** [khedmalink-app](https://github.com/IamAbood/khedmalink-app)
- **Website:** [khedmalink-website](https://github.com/IamAbood/khedmalink-website)

---

## License

This project is licensed under the MIT License. 