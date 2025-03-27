🎓 Student Management System

A full-stack Spring Boot application for managing student records — with CRUD operations, search, pagination, form validation, REST APIs, and a cloud-deployed backend using Docker and MySQL.

---

 🚀 Live Demo

🌐 [Access the App](https://student-management-a843.onrender.com)  


---

🛠️ Tech Stack

- **Backend:** Java 17, Spring Boot 3, Spring Data JPA, Hibernate
- **Frontend:** Thymeleaf
- **Database:** MySQL (hosted on Railway)
- **Build Tool:** Maven
- **Deployment:** Docker + Render

---

 ✨ Features

- ✅ Create, Update, Delete student records
- ✅ Pagination for student list
- ✅ Search by student name
- ✅ Form validations with error display
- ✅ REST APIs for frontend integration
- ✅ Landing page (`/home`)
- ✅ Health check endpoint (`/api/students/ping`)
- ✅ Deployed on Render with cloud MySQL

---

 📂 Project Structure
  student-management/ 
              ├── controller/ 
              ├── model/ 
              ├── repository/ 
              ├── service/ 
              ├── templates/ 
              ├── static/ 
              ├── Dockerfile 
              ├── application.properties 
              └── README.md


---

🔁 REST API Endpoints

| Method | Endpoint              | Description            |
|--------|------------------------|------------------------|
| GET    | `/api/students`        | Get all students       |
| GET    | `/api/students/{id}`   | Get student by ID      |
| POST   | `/api/students`        | Create new student     |
| PUT    | `/api/students/{id}`   | Update student         |
| DELETE | `/api/students/{id}`   | Delete student         |
| GET    | `/api/students/ping`   | Health check           |

---

🐳 Dockerized Deployment

The app is built with Docker using a multi-stage `Dockerfile`:
- Stage 1: Build with Maven
- Stage 2: Run with OpenJDK

Render auto-deploys from GitHub and builds the Docker container.

---

🔧 Environment Variables (set in Render)

```env
SPRING_DATASOURCE_URL=jdbc:mysql://<railway-host>:<port>/<dbname>
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_password



📬 Author
Sai Mithun
📧 saimithunui3@gmail.com
🔗 LinkedIn: https://www.linkedin.com/in/saimithun-s-3a30b6327/

