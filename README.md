# Génie Logiciel — Projets Spring Boot

## Description

Ce dépôt contient une série de **travaux pratiques réalisés dans le cadre du module de Génie Logiciel**.

L'objectif est de construire progressivement une application **E-commerce backend en Java avec Spring Boot**, en faisant évoluer son architecture :

1. **TP1 — Monolithe simple (CRUD REST API)**
2. **TP2 — Monolithe modulaire**
3. **TP3 — Architecture distribuée (microservices)**

Chaque TP introduit **de nouveaux concepts d’architecture logicielle** et améliore la qualité du code.

---

# Structure du Repository

```
TP_GeniLogiciel
│
├── TP1
│   └── monolith
│
├── TP2
│   └── modular_monolith
│
├── TP3
│   └── microservices (à venir)
│
├── README.md
└── .gitignore
```

---

# Technologies Utilisées

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Data REST
* Hibernate
* PostgreSQL
* Lombok
* Maven
* Postman
* MapStruct

---

# TP1 — Monolithe REST API

## Objectif

Construire une **API REST simple pour gérer des produits**.

---

## Architecture

```
Controller → Service → Repository → Database
```

---

## Modules

```
product
├── controller
├── service
├── repository
└── model
```

---

## Base de Données

Schéma :

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

---

## Endpoints principaux

| Méthode | Endpoint           |
| ------- | ------------------ |
| GET     | /api/products      |
| GET     | /api/products/{id} |
| POST    | /api/products      |
| PUT     | /api/products/{id} |
| DELETE  | /api/products/{id} |

---

# TP2 — Monolithe Modulaire ✅

## Objectif

Refactorer l'application en une architecture **modulaire par domaine métier**.

---

## Concepts introduits

* DTO Pattern
* Mapper Pattern
* MapStruct
* Service Layer propre
* Séparation des responsabilités
* Communication inter-modules

---

## Architecture globale

```
Controller → Service → Mapper → Repository → Database
```

---

## Structure

```
com.ecommerce.monolith

├── product
├── customer
└── order
```

---

## Modules détaillés

### 🔹 Product

```
product
├── controller
├── service
├── repository
├── model
├── dto
└── mapper
```

---

### 🔹 Customer

```
customer
├── controller
├── service
├── repository
├── model
├── dto
└── mapper
```

---

### 🔹 Order

```
order
├── controller
├── service
├── repository
├── model
├── dto
└── mapper
```

---

## 🔗 Relations métier

```
Customer → 1..* → Order
Order → 1 → Product
```

---

## ⚠️ Règle d’architecture importante

Les modules ne communiquent **jamais directement via les repositories** :

```
OrderService → ProductService ✅
OrderService → CustomerService ✅
```

```
OrderService → ProductRepository ❌
OrderService → CustomerRepository ❌
```

👉 Cela garantit un **faible couplage** et prépare l’architecture microservices.

---

## Exemple — Création d’une commande

### Requête

```json
{
  "quantity": 2,
  "productId": 1,
  "customerId": 1
}
```

---

### Réponse

```json
{
  "id": 1,
  "quantity": 2,
  "productId": 1,
  "customerId": 1
}
```

---

## Endpoints principaux

### Products

```
/api/products
```

### Customers

```
/api/customers
```

### Orders

```
/api/orders
```

---

## Ce que ce TP apporte

* Architecture modulaire claire
* Code maintenable et évolutif
* Séparation entre API et modèle interne
* Préparation aux microservices

---

# TP3 — Architecture Microservices 🚧

## Objectif

Transformer le monolithe modulaire en **architecture distribuée**.

---

## Concepts à venir

* Microservices
* API Gateway
* Service Discovery
* Communication inter-services
* Base de données par service

---

# Lancer les Projets

## 1. Cloner le repository

```
git clone https://github.com/your-username/TP_GeniLogiciel.git
```

---

## 2. Configurer PostgreSQL

```
CREATE DATABASE ecommerce;
CREATE SCHEMA IF NOT EXISTS ecommerce_app AUTHORIZATION postgres; 
SET search_path TO ecommerce_app, public;
```

---

## 3. Configuration (`application.properties`)

```
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.default_schema=ecommerce_app
```

---

## 4. Lancer l'application

```
mvn spring-boot:run
```

---

## Accès API

```
http://localhost:8080
```

---

# Auteur

**Thierno Mamoudou BAH**

Projet réalisé dans le cadre du module **Génie Logiciel**.
