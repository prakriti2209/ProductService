Product Service — Ecommerce Backend

This is the product management service of my e-commerce microservices project.
Main project: https://github.com/prakriti2209/Ecommerce-Microservices

What it does:
Admin can add, update and delete products.
Users can view all available products.
All endpoints are secured — JWT token required in Authorization header.

Port: 8081
Database: MySQL (ProductService)

How to test in Postman:
1. First login from Auth Service to get JWT token
2. In Postman, go to Authorization tab
3. Select Bearer Token and paste the JWT token
4. Now call any product endpoint

API endpoints:
POST /products — add product (ADMIN only)
GET /products — get all products (ADMIN and USER)
PUT /products/update/{id} — update product (ADMIN only)
DELETE /products/delete/{id} — delete product (ADMIN only)
