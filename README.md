## **How to Run the Application**
### **Prerequisites**
Ensure you have the following installed:
- **Java 17+**
- **Gradle**
- **Postman / cURL** for API testing

---

### **Clone the Repository**
```bash
git clone https://github.com/justaspaz/deeper.git
```

### **Build the Project**
```bash
./gradlew build
```
### **Start the application**
```bash
./gradlew bootRun
```

## **Architerure overview**

```bash
📦 org.example.deeper
 ┣ 📂 controller   # REST API endpoints
 ┃ ┗ 📂 model      # Request/Response DTOs
 ┣ 📂 service      # Business logic layer
 ┣ 📂 config       # Security & Filter Configurations
 ┗ 📂 entity       # Entity models for persistence
```
### **Controller Layer (`FigureController`, `StatsController`)**
- Handles **HTTP requests**.
- Calls the **service layer** to process data.
- Exposes **REST endpoints** for clients.
---

### **Service Layer (`IntersectionService`)**
- Contains **core business logic**.
- Calculates **intersections between a line and a square**
---

### **Security (`SecurityConfig`)**
- **Enables Basic Authentication** for `/stats/system-stats`.
- Allows `/figures/intersect` as **publicly accessible**.
- Tracks **active requests using `AtomicInteger`**.
---


## **How to use**
### **POST `/figures/intersect`**
#### **Body:**
```json
{
  "line": { "x1": -5, "y1": 5, "x2": 15, "y2": 5 },
  "square": { "x": 0, "y": 10, "w": 10, "h": 10 }
}
```
### **GET `/stats/system-stats`**
#### **Use Basic Authentication (admin:password)**
```bash
curl -u admin:password -X GET http://localhost:8080/stats/system-stats
```


