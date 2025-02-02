

---

# **📘 FAQ Management API - Spring Boot + MongoDB + Redis**  

Welcome to the **FAQ Management API**! This is a **Spring Boot REST API** designed to **manage FAQs with multilingual support, caching, and a WYSIWYG editor**. It uses **MongoDB Atlas for storage** and **Redis Cloud for caching** to ensure high performance.  

---

## **✨ Features**  
✅ **Create & Retrieve FAQs** (with multilingual support)  
✅ **Rich Text Formatting** (WYSIWYG Editor using CKEditor)  
✅ **Fast Performance** (Integrated Redis Caching)  
✅ **MongoDB Atlas for Data Storage**  
✅ **RESTful API with JSON responses**  
✅ **Secure & Scalable Deployment (Docker-ready)**  

---

## **📦 Installation Steps**  

### **1️⃣ Clone the Repository**  
```sh
git clone https://github.com/bugremover/FAQ-Management-System.git
cd FAQ-Management-System
```

### **2️⃣ Configure MongoDB & Redis**  
🔹 **MongoDB Atlas**: Create a database & replace `<username>, <password>, <database>` in `application.properties`.  
🔹 **Redis Cloud**: Get a free Redis Cloud account & update your `application.properties`.  

### **3️⃣ Update `application.properties`**
```properties
# ✅ MongoDB Atlas Connection
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<database>?retryWrites=true&w=majority

# ✅ Redis Cloud Configuration
spring.redis.host=your-redis-cloud-endpoint
spring.redis.port=19230
spring.redis.password=your-redis-cloud-password
spring.redis.ssl=true
```

### **4️⃣ Run the Application**  
```sh
mvn spring-boot:run
```
🔹 Server will start on **`http://localhost:8080`**  

---

## **🛠️ API Usage**  

### **🔍 Fetch All FAQs**
```sh
curl -X GET http://localhost:8080/api/faqs
```
🔹 **Response (Example)**  
```json
[
  {
    "id": "1",
    "question": "What is Spring Boot?",
    "answer": "Spring Boot is an open-source Java framework."
  }
]
```

### **➕ Add a New FAQ**
```sh
curl -X POST http://localhost:8080/api/faqs -H "Content-Type: application/json" -d '{
  "question": "How does caching work?",
  "answer": "Caching stores frequently accessed data for faster retrieval."
}'
```
🔹 **Response**  
```json
{
  "id": "2",
  "question": "How does caching work?",
  "answer": "Caching stores frequently accessed data for faster retrieval."
}
```

---

## **🛠️ Running Tests**
To run all unit and integration tests, use:  
```sh
mvn test
```
🔹 Runs **Mockito-based unit tests** & **MockMvc API tests**  

---

## **🐳 Deploy with Docker**
### **1️⃣ Build Docker Image**
```sh
docker build -t faq-api .
```
### **2️⃣ Run Container**
```sh
docker run -p 8080:8080 faq-api
```
🔹 Now access the API at **`http://localhost:8080/api/faqs`** 🎉  

---

## **🤝 Contribution Guidelines**  
🚀 Want to contribute? Follow these steps!  
1. **Fork the repository**  
2. **Create a new branch** (`git checkout -b feature-branch`)  
3. **Make your changes** 🛠️  
4. **Commit with proper messages** (`git commit -m "feat: Added FAQ caching"`)  
5. **Push & Submit a PR** (`git push origin feature-branch`)  
6. 🎉 **Wait for review & merge!**  

---


---

## **💡 Future Improvements**
🔹 Add **authentication** for admin panel  
🔹 Implement **GraphQL API** for optimized queries  
🔹 Introduce **Swagger API Documentation**  

---

## **📞 Need Help?**
For any issues, **open an issue** in the GitHub repository or contact me at **harshavardhan75anc@gmail.com**.  

---

## **🚀 Star this Repo if you like it! ⭐**
💙 Thanks for visiting! Happy coding! 🎉  

---

