**Catalogue Project**

A **Spring Boot + Maven** application designed to manage **products and categories** efficiently.  
This project follows a layered architecture (Controller → Service → Repository → Entity) and can be extended into a complete e-commerce or inventory system.  

## 🚀 Features
- ✅ Manage **Categories** (Add, Update, Delete, View)  
- ✅ Manage **Products** under categories  
- ✅ RESTful API endpoints with Spring Boot  
- ✅ Maven-based project for easy build & dependency management  
- ✅ MySQL (or any JPA-supported DB) integration  
- ✅ Follows **best practices**: Layered architecture, DTOs, and Repository pattern  

## 🛠️ Tech Stack
- **Backend:** Java 22, Spring Boot  
- **Build Tool:** Maven  
- **Database:** MySQL (can be switched to PostgreSQL, H2, etc.)  
- **Version Control:** Git & GitHub  

The project structure separates:

Controller → API layer
Service → Business logic
Repository → DB interaction
Entity → Database models
DTO → Request/Response objects
Exception → Error handling
Enums → Constants for fixed values

## ⚙️ Setup & Run

### 1️⃣ Clone the Repository

git clone https://github.com/SS-Barath/catalogue.git
cd catalogue

2️⃣ Build with Maven

mvn clean install

3️⃣ Run the Application

mvn spring-boot:run

4️⃣ Access API
Base URL: http://localhost:8080

Example Endpoints:

GET /categories
POST /categories
GET /products
POST /products

📖 API Examples
Create a Category

POST /categories
{
  "name": "Electronics",
  "description": "Gadgets and devices"
}

Create a Product

POST /products
{
  "name": "Smartphone",
  "price": 25000,
  "categoryId": 1
}

