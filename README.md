Catalogue Project

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


##ER Diagram
  CATEGORY ||--o{ CATEGORY_ATTRIBUTE : has
  CATEGORY_ATTRIBUTE ||--o{ CATEGORY_ATTRIBUTE_OPTION : has
  PRODUCT }o--|| CATEGORY : belongs_to
  PRODUCT ||--o{ PRODUCT_ATTRIBUTE_VALUE : has
  CATEGORY_ATTRIBUTE ||--o{ PRODUCT_ATTRIBUTE_VALUE : defines

  CATEGORY {
    bigint id PK
    string name
    string code
    text   description
    bigint parent_id FK
  }

  CATEGORY_ATTRIBUTE {
    bigint id PK
    bigint category_id FK
    string name
    string code
    string data_type        // STRING, TEXT, INT, DECIMAL, BOOL, DATE, DATETIME, ENUM, JSON
    bool   required
    bool   variant
    string unit
    decimal min
    decimal max
  }

  CATEGORY_ATTRIBUTE_OPTION {
    bigint id PK
    bigint attribute_id FK
    string value
    string label
  }

  PRODUCT {
    bigint id PK
    bigint category_id FK
    string sku
    string title
    text   description
    decimal price
    string currency
    datetime created_at
    datetime updated_at
  }

  PRODUCT_ATTRIBUTE_VALUE {
    bigint product_id FK
    bigint attribute_id FK
    string  value_str
    decimal value_num
    bool    value_bool
    json    value_json
    PK "product_id, attribute_id"
  }

##Class Diagram

  class Category { +Long id +String name +String code +String description +Category parent }
  class CategoryAttribute { +Long id +Category category +String name +String code +DataType dataType +boolean required +boolean variant +String unit +BigDecimal min +BigDecimal max }
  class CategoryAttributeOption { +Long id +CategoryAttribute attribute +String value +String label }
  class Product { +Long id +Category category +String sku +String title +String description +BigDecimal price +String currency }
  class ProductAttributeValue { +Product product +CategoryAttribute attribute +String valueStr +BigDecimal valueNum +Boolean valueBool +String valueJson }

  class CategoryRepository
  class CategoryAttributeRepository
  class CategoryAttributeOptionRepository
  class ProductRepository
  class ProductAttributeValueRepository

  class CategoryService {
    +Category createCategory(Category)
    +void addAttribute(Long, AttributeCreateRequest)
    +CategoryAttributeOption addOption(Long, AttributeOptionCreateRequest)
  }

  class ProductService {
    +Product create(ProductCreateRequest)
  }

  class CategoryController
  class ProductController

  Category "1" --> "0..*" CategoryAttribute
  CategoryAttribute "1" --> "0..*" CategoryAttributeOption
  Product "*" --> "1" Category
  Product "1" --> "0..*" ProductAttributeValue
  CategoryAttribute "1" --> "0..*" ProductAttributeValue

  CategoryService --> CategoryRepository
  CategoryService --> CategoryAttributeRepository
  CategoryService --> CategoryAttributeOptionRepository
  ProductService --> ProductRepository
  ProductService --> ProductAttributeValueRepository

##API Endpoints

##Category Management

POST /categories → Create category
GET /categories → List categories

##Attribute Management

POST /categories/{id}/attributes → Add attribute
POST /attributes/{id}/options → Add attribute option
GET /attributes?categoryId={id} → Get attributes for category

##Product Management

POST /products → Create product with attribute values
GET /products → List products

