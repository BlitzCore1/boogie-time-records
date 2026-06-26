# Boogie Time Records Store E-Commerce API

## Project Description

This project is a backend API for an e-commerce Record Store application. The frontend website was provided as part of the starter files, and my main responsibility was to work as the backend developer by improving the Spring Boot API, connecting endpoints to the database, fixing existing bugs, and adding new features.

The Record Store allows users to browse music-related products, view product categories, log in, manage a shopping cart, and interact with the store through a connected frontend website.

## Tech Stack

- Java
- Spring Boot
- MySQL
- Spring Security / JWT Authentication
- REST APIs
- JPA Repositories
- IntelliJ IDEA
- Insomnia
- Swagger UI
- Git / GitHub

## Features Implemented

### Phase 1: Categories Controller

I implemented the category endpoints so users can view product categories and category details. Admin users can manage category data through protected API endpoints.

Completed functionality includes:

- View all categories
- View category by ID
- View products by category
- Add a category as an admin
- Update a category as an admin
- Delete a category as an admin

### Phase 2: Product Bug Fixes

I fixed bugs in the product search and product update functionality.

Completed fixes include:

- Product search/filtering now returns the correct results
- Product filtering works with category, price range, and subcategory
- Product updates now correctly save changes to the database
- Product stock values update correctly

### Phase 3: Shopping Cart

I implemented shopping cart functionality for logged-in users.

Completed functionality includes:

- View the current user’s shopping cart
- Add a product to the cart
- Increase quantity when adding the same product again
- Update the quantity of an existing cart item
- Clear all items from the current user’s cart
- Return the updated cart after cart changes

### Phase 4: User Profile

I implemented user profile functionality so logged-in users can view and update their profile information.

Completed functionality includes:

- View current user profile
- Update current user profile
- Connect profile data to the logged-in user

## API Endpoints Worked On

### Categories

| Method | Endpoint                    | Description              |
| ------ | --------------------------- | ------------------------ |
| GET    | `/categories`               | Get all categories       |
| GET    | `/categories/{id}`          | Get category by ID       |
| GET    | `/categories/{id}/products` | Get products by category |
| POST   | `/categories`               | Add new category         |
| PUT    | `/categories/{id}`          | Update category          |
| DELETE | `/categories/{id}`          | Delete category          |

### Shopping Cart

| Method | Endpoint                     | Description                     |
| ------ | ---------------------------- | ------------------------------- |
| GET    | `/cart`                      | Get current user’s cart         |
| POST   | `/cart/products/{productId}` | Add product to cart             |
| PUT    | `/cart/products/{productId}` | Update product quantity in cart |
| DELETE | `/cart`                      | Clear current user’s cart       |

### Profile

| Method | Endpoint   | Description                 |
| ------ | ---------- | --------------------------- |
| GET    | `/profile` | Get current user profile    |
| PUT    | `/profile` | Update current user profile |

## How to Run the Project

### 1. Set Up the Database

Open MySQL Workbench and run the Record Store database script from the starter files.

Use the Record Store database script that matches the Record Store frontend.

### 2. Open the API Project

Open the API project in IntelliJ IDEA.

Make sure the database connection settings match your local MySQL username, password, and database name.

### 3. Run the Spring Boot Application

Start the backend API from IntelliJ.

The API should run on:

```text
http://localhost:8080