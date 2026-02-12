# Inventory Management System

## Description
This is a simple web-based inventory management system for a manufacturing company.  
It allows the user to manage products, raw materials, and the association between them, as well as simulate production based on available stock.  

The system prioritizes products with higher value when suggesting production quantities.

---

## Features
- CRUD operations for **Products**
- CRUD operations for **Raw Materials**
- CRUD operations to **associate raw materials to products**
- View **available products for production** based on current stock
- Calculates **maximum producible quantity** and **total production value**
- Front-end built with HTML, CSS, and JavaScript
- Back-end API built with Spring Boot and PostgreSQL
- Endpoints and database fields use **English** naming

---

## Technologies Used
- **Back-end:** Java, Spring Boot
- **Front-end:** HTML, CSS, JavaScript
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **API format:** RESTful JSON

---

## Project Structure

inventory/
├─ src/main/java/com/lucasferrari/inventory/
│ ├─ controller/ # REST Controllers
│ ├─ dto/ # Data Transfer Objects
│ ├─ entity/ # JPA Entities
│ ├─ repository/ # Spring Data Repositories
│ └─ service/ # Business logic
├─ src/main/resources/
│ └─ static/ # Front-end HTML, CSS, JS
├─ application.properties
├─ pom.xml
└─ README.md


---

## API Endpoints

- **Products**
  - `GET /products` – List all products
  - `POST /products` – Create a product
  - `GET /products/{id}` – Get product by ID
  - `DELETE /products/{id}` – Delete product

- **Raw Materials**
  - `GET /raw-materials` – List all raw materials
  - `POST /raw-materials` – Create a raw material
  - `GET /raw-materials/{id}` – Get raw material by ID
  - `DELETE /raw-materials/{id}` – Delete raw material

- **Product-Raw Material Association**
  - `POST /product-raw-materials` – Link raw material to product
    - Params: `productId`, `rawMaterialId`, `requiredQuantity`
  - `GET /product-raw-materials/product/{productId}` – List raw materials linked to a product
  - `DELETE /product-raw-materials/{id}` – Delete a link

- **Production**
  - `GET /production/available` – List products available for production with quantity and total value

---

## How to Run

1. Clone this repository:

```bash
git clone <your-repo-url>
cd inventory
```
2. Make sure PostgreSQL is installed and running. Create a database named 
inventory_db:
```bash
CREATE DATABASE inventory_db;
```

3. Configure your database credentials in src/main/resources/application.properties:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db
spring.datasource.username=postgres
spring.datasource.password=<your-password>
```
4. Build and run the Spring Boot application:
```bash
mvn spring-boot:run
```
5. Open the front-end pages in your browser:

- **index.html** – Main menu
- **raw-materials.html** – Manage raw materials
- **products.html** – Manage products
- **product-raw-materials.html** – Link raw materials to products
- **production.html** – Simulate production
- The application runs by default on http://localhost:8080

## Notes
- **Products are prioritized by price when calculating production.**
- **Raw materials must have enough stock to be used in production.**
- **Front-end uses vanilla JS and relative API paths.**
- **All database tables and API fields use English naming for consistency.**

## Author
- Lucas Ferrari da Costa
- GitHub: https://github.com/Lucasksasa
