# 🕰️ Time Capsule Backend API

A simple Spring Boot REST API for managing digital time capsules. Create, store, and retrieve messages with scheduled access dates.

🌐 **Live API**: [https://pranjal.up.railway.app](https://pranjal.up.railway.app)

## ✨ Features

- **CRUD Operations**: Create, read, update, and delete time capsules
- **RESTful API**: Clean REST endpoints following standard conventions
- **Cloud Deployed**: Hosted on Railway for easy access
- **In-Memory Storage**: Simple ArrayList-based storage for development/testing
- **Spring Boot**: Built with Spring Boot framework for easy setup and deployment

## 🚀 API Endpoints

**Base URL**: `https://pranjal.up.railway.app`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | API welcome message and status |
| GET | `/capsule` | Retrieve all time capsules |
| GET | `/capsule/{id}` | Get a specific capsule by ID |
| POST | `/capsule` | Create a new time capsule |
| PUT | `/capsule` | Update an existing capsule |
| DELETE | `/capsule/{id}` | Delete a capsule by ID |

## 📋 Data Model

Each time capsule contains:
- **Capsule ID**: Unique identifier
- **Title**: Capsule title/name
- **Message**: The message content to be preserved
- **Start Date**: When the capsule was created
- **End Date**: When the capsule should be opened/accessed

## 🧪 Try It Out

**Test the live API with these examples:**

**Check API status:**
```bash
curl https://pranjal.up.railway.app/
```

**Create a new capsule:**
```bash
curl -X POST https://pranjal.up.railway.app/capsule \
  -H "Content-Type: application/json" \
  -d '{
    "capsuleId": 1,
    "title": "My First Capsule",
    "message": "Hello future me!",
    "startDate": "2024-01-01",
    "endDate": "2025-01-01"
  }'
```

**Get all capsules:**
```bash
curl https://pranjal.up.railway.app/capsule
```

**Get specific capsule:**
```bash
curl https://pranjal.up.railway.app/capsule/1
```

## 🛠️ Technology Stack

- **Java**: Programming language
- **Spring Boot**: Framework for building the REST API
- **Spring Web**: For REST controller functionality
- **Railway**: Cloud deployment platform
- **Maven**: Dependency management

## 📁 Project Structure

```
src/main/java/com/example/demo/
├── controller/
│   └── CapsuleController.java    # REST API endpoints
├── service/
│   └── CapsuleService.java       # Business logic layer
└── model/
    └── Capsule.java              # Data model
```

## 🏃‍♂️ Running Locally

### Prerequisites
- Java 8 or higher
- Maven
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### Setup
1. Clone the repository
```bash
git clone https://github.com/pranjal-garg/springnew.git
cd time-capsule-backend
```

2. Run the application
```bash
mvn spring-boot:run
```

3. Access locally at `http://localhost:8080`

## 🔮 Future Enhancements

- [ ] Database integration (JPA/Hibernate)
- [ ] Authentication and authorization
- [ ] Scheduled capsule opening based on end dates
- [ ] File attachments support
- [ ] Email notifications when capsules are ready
- [ ] Input validation and error handling
- [ ] Unit and integration tests
- [ ] API documentation with Swagger/OpenAPI
- [ ] Frontend web application

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

<div align="center">

**🕰️ Preserve your memories for the future 🕰️**

*Built with ❤️ using Spring Boot and deployed on Railway*

</div>
