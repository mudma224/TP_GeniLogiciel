# TP_GeniLogiciel
# TP1
# E-Commerce Product API — Spring Boot

## 📌 Description

Ce projet est une **API REST développée avec Spring Boot** permettant de gérer des produits dans un système e-commerce simple.

L'application implémente un **CRUD complet (Create, Read, Update, Delete)** pour les produits et introduit également une **relation entre entités avec JPA** à travers une catégorie de produits.

Le projet utilise **PostgreSQL comme base de données** et expose les endpoints REST testables avec **Postman**.

Ce TP a pour objectif de comprendre :

* l’architecture d’une application **Spring Boot**
* la gestion des **entités JPA**
* les relations entre entités (**ManyToOne**)
* l’utilisation de **Spring Data JPA**
* l’exposition d’API REST
* l’utilisation de **Spring Data REST**

---

# 🏗 Architecture du projet

Le projet suit l’architecture classique **Spring Boot en couches** :

```
Client HTTP (Postman)
        │
        ▼
Controller (API REST)
        │
        ▼
Service (Logique métier)
        │
        ▼
Repository (Accès aux données)
        │
        ▼
PostgreSQL Database
```

Structure des packages :

```
com.ecommerce.monolith
│
├── product
│   ├── controller
│   │      ProductController
│   │
│   ├── service
│   │      ProductService
│   │
│   ├── repository
│   │      ProductRepository
│   │      CategoryRepository
│   │
│   └── model
│          Product
│          Category
```

---

# ⚙️ Technologies utilisées

* Java 17+
* Spring Boot
* Spring Data JPA
* Spring Data REST
* Hibernate
* PostgreSQL
* Lombok
* Maven
* Postman

---

# 🗄 Base de données

Base de données utilisée : **PostgreSQL**

Schéma :

```
categories
---------
id
name
```

```
products
---------
id
name
description
price
stock
category_id
```

Relation :

```
Product → ManyToOne → Category
```

Un produit appartient à **une catégorie**, tandis qu'une catégorie peut contenir **plusieurs produits**.

---

# 📦 Entités

## Product

Représente un produit dans le système e-commerce.

Attributs :

| Champ       | Type       | Description          |
| ----------- | ---------- | -------------------- |
| id          | Long       | Identifiant          |
| name        | String     | Nom du produit       |
| description | String     | Description          |
| price       | BigDecimal | Prix                 |
| stock       | Integer    | Quantité disponible  |
| category    | Category   | Catégorie du produit |

Validation :

* `@NotBlank`
* `@NotNull`
* `@Positive`
* `@PositiveOrZero`

---

## Category

Représente une catégorie de produits.

| Champ | Type   |
| ----- | ------ |
| id    | Long   |
| name  | String |

---

# 🔗 API Endpoints

## Produits

| Méthode | Endpoint             | Description             |
| ------- | -------------------- | ----------------------- |
| GET     | `/api/products`      | Liste tous les produits |
| GET     | `/api/products/{id}` | Récupère un produit     |
| POST    | `/api/products`      | Créer un produit        |
| PUT     | `/api/products/{id}` | Modifier un produit     |
| DELETE  | `/api/products/{id}` | Supprimer un produit    |

Exemple de requête POST :

```json
{
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 1200,
  "stock": 10,
  "category": {
    "id": 1
  }
}
```

---

## Catégories (Spring Data REST)

Les catégories sont exposées automatiquement via **Spring Data REST**.

| Méthode | Endpoint           |
| ------- | ------------------ |
| GET     | `/categories`      |
| POST    | `/categories`      |
| GET     | `/categories/{id}` |
| DELETE  | `/categories/{id}` |

---

# ▶️ Lancer le projet

## 1️⃣ Cloner le projet

```
git clone https://github.com/ton-username/ecommerce-api.git
```

---

## 2️⃣ Configurer PostgreSQL

Créer la base de données :

```
CREATE DATABASE ecommerce;
```

Créer le schéma :

```
CREATE SCHEMA ecommerce_app;
```

---

## 3️⃣ Configurer `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 4️⃣ Lancer l'application

```
mvn spring-boot:run
```

L'API sera accessible sur :

```
http://localhost:8080
```

---

# 🧪 Tests avec Postman

Les endpoints peuvent être testés avec **Postman**.

Exemple :

```
GET http://localhost:8080/api/products
```

---

# 🎯 Objectifs pédagogiques

Ce TP permet de comprendre :

* la création d'une **API REST avec Spring Boot**
* l'utilisation de **Spring Data JPA**
* la gestion des **entités et relations**
* la connexion avec **PostgreSQL**
* l'exposition automatique d'API avec **Spring Data REST**

---
