# E-commerce Microservices - Order Processing

## 🚀 Project Overview
This project is a **microservices-based E-commerce order processing system** designed to demonstrate **event-driven architecture** using Kafka, Redis, and transaction management with MySQL.

### **🔥 Key Features**
✅ **Product Service** – CRUD operations on products.
✅ **Order Service** – Handles transactions & inventory updates.
✅ **Payment Service** – Simulated payment processing.
✅ **Event-Driven Architecture** – Uses Kafka for asynchronous communication.
✅ **Circuit Breaker Pattern** – Implemented via Resilience4J.
✅ **Dockerized Environment** – Easily deployable via Docker & Docker Compose.

---

## 📌 Tech Stack
- **Backend:** Java, Spring Boot
- **Messaging:** Apache Kafka
- **Cache:** Redis
- **Database:** MySQL
- **Containerization:** Docker, Docker Compose
- **Resilience & Fault Tolerance:** Resilience4J

---

## ⚙️ Prerequisites
Ensure you have the following installed:
- **JDK 17+**
- **Maven** (For building the project)
- **Docker & Docker Compose**
- **Kafka & Zookeeper** (Embedded in Docker setup)

---

## 🛠️ Setup & Run Locally

### **1️⃣ Clone the Repository**
```sh
 git clone https://github.com/DineshK06/ecommerce-microservices.git
 cd ecommerce-microservices
```

### **2️⃣ Start MySQL Database**
```sh
docker-compose -f docker-compose.dev.yml up -d mysql
```

### **3️⃣ Run Services**
Each service runs independently. Start them in separate terminals:

#### **Product Service**
```sh
cd product-service
mvn spring-boot:run
```

#### **Order Service**
```sh
cd order-service
mvn spring-boot:run
```

#### **Payment Service**
```sh
cd payment-service
mvn spring-boot:run
```

> **Note:** Kafka and Redis are automatically started via Docker Compose.

---

## 🐳 Dockerization

### **1️⃣ Build Docker Images**
```sh
docker-compose -f docker-compose.dev.yml build
```

### **2️⃣ Start All Services in Docker**
```sh
docker-compose -f docker-compose.dev.yml up -d
```

### **3️⃣ Stop Services**
```sh
docker-compose -f docker-compose.dev.yml down
```

---

## 🛢️ Database Access (MySQL)
Follow these steps to connect to **ecommerce_db**:

1️⃣ **Ensure MySQL container is running:**
```sh
docker-compose -f docker-compose.dev.yml up -d mysql
```

2️⃣ **Connect to MySQL container:**
```sh
docker exec -it ecommerce-microservices-mysql mysql -u user -p
```
> Enter the password when prompted (use the one from your `.env` configuration).

3️⃣ **Select the Database:**
```sql
USE ecommerce_db;
```

4️⃣ **Show Tables:**
```sql
SHOW TABLES;
```

5️⃣ **Query Data:** (Example: Retrieve all products)
```sql
SELECT * FROM products;
```

---

## 🧪 Testing API Endpoints
API request and response collections are available in the repository. Use **Postman** or **cURL** to test the endpoints.

Example request using **cURL**:
```sh
curl -X GET http://localhost:8080/api/products
```

For full API documentation, refer to the **Postman collection** in the repo.

---

## 🚀 CI/CD & Deployment
- This project is designed for **containerized deployment using Docker**.
- For cloud deployment, integrate with **Kubernetes & Helm Charts** (future enhancement).

---

## 📜 License
This project is **MIT licensed**. See the [LICENSE](LICENSE) file for details.

---

## 🎯 Contribution
Contributions are welcome! Follow these steps:
1. **Fork the repo**
2. **Create a new branch** (`feature/new-feature`)
3. **Commit & push**
4. **Submit a PR**

---

## ✨ Author
👤 **Dinesh Kumar**  
🚀 **GitHub:** [DineshK06](https://github.com/DineshK06)
🚀 **Upwork:** https://www.upwork.com/freelancers/dineshk06
