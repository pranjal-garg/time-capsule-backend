# 🕰️ Time Capsule Backend API

A simple Spring Boot REST API for managing digital time capsules. Create, store, and retrieve messages with scheduled access dates.

🌐 **Live API**: [https://pranjal.up.railway.app](https://pranjal.up.railway.app)  
📱 **Flutter App**: [https://github.com/pranjal-garg/time-capsule-flutter](https://github.com/pranjal-garg/time-capsule-flutter) *(UI Complete - Backend Integration In Progress)*

## ✨ Features

- **CRUD Operations**: Create, read, update, and delete time capsules
- **RESTful API**: Clean REST endpoints following standard conventions
- **Cloud Deployed**: Hosted on Railway for easy access
- **In-Memory Storage**: Simple ArrayList-based storage for development/testing
- **Spring Boot**: Built with Spring Boot framework for easy setup and deployment
- **Mobile Ready**: Designed to work seamlessly with the Flutter mobile application

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
│   ├── HomeController.java       # Root endpoint handler
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
git clone https://github.com/pranjal-garg/time-capsule-backend.git
cd time-capsule-backend
```

2. Run the application
```bash
mvn spring-boot:run
```

3. Access locally at `http://localhost:8080`

## 🔮 Future Enhancements

### Backend Improvements
- [ ] Database integration (JPA/Hibernate)
- [ ] Authentication and authorization
- [ ] Scheduled capsule opening based on end dates
- [ ] File attachments support
- [ ] Email notifications when capsules are ready
- [ ] Input validation and error handling
- [ ] Unit and integration tests
- [ ] API documentation with Swagger/OpenAPI
- [ ] Rate limiting and security headers

### Mobile Integration
- [x] Flutter mobile application *(UI complete - integration in progress)*
- [ ] Push notification endpoints for mobile app
- [ ] Image/media upload endpoints
- [ ] User authentication for multi-user support
- [ ] Offline sync capabilities

## 📱 Mobile Application

A Flutter mobile app is currently being developed to provide a user-friendly interface for creating and managing time capsules. 

**Current Status:**
- ✅ **UI Complete**: Beautiful, intuitive interface finished
- 🔄 **Backend Integration**: Currently connecting the app to this API
- 📋 **Planned**: Push notifications, offline support, media attachments

**Features:**
- Intuitive capsule creation and management
- Beautiful UI for viewing stored memories
- Notification system for capsule opening dates
- Offline support with sync capabilities

**Repository**: [Time Capsule Flutter App](https://github.com/pranjal-garg/time-capsule-flutter)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines
- Follow Spring Boot best practices
- Add unit tests for new features
- Update API documentation
- Consider mobile app compatibility when making changes

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Spring Boot community for excellent framework
- Railway for reliable hosting
- Flutter team for mobile development inspiration

---

<div align="center">

**🕰️ Preserve your memories for the future 🕰️**

*Built with ❤️ using Spring Boot and deployed on Railway*

**[🌐 Live API](https://pranjal.up.railway.app) | [📱 Flutter App](https://github.com/pranjal-garg/time-capsule-flutter) | [⭐ Star this repo](https://github.com/pranjal-garg/time-capsule-backend)**

</div>
