# Génie Logiciel — Projets Spring Boot

## Description

Ce dépôt contient une série de **travaux pratiques réalisés dans le cadre du module de Génie Logiciel**.

L'objectif global est de construire progressivement une application **E-commerce backend en Java avec Spring Boot**, en passant par plusieurs architectures :

1. **TP1 — Monolithe simple (CRUD REST API)**
2. **TP2 — Monolithe modulaire**
3. **TP3 — Architecture distribuée (microservices)**

Chaque TP introduit **de nouveaux concepts d’architecture logicielle** et améliore la structure du projet.

---

# Structure du Repository

Le repository est organisé par TP :

```
TP_GeniLogiciel
│
├── TP1
│   └── Monolith REST API
│
├── TP2
│   └── Modular Monolith Architecture
│
├── TP3
│   └── Distributed Architecture (Microservices)
│
├── README.md
└── .gitignore
```

Chaque dossier contient **le code source et les instructions spécifiques au TP**.

---

# Technologies Utilisées

Les différents TP utilisent les technologies suivantes :

* Java
* Spring Boot
* Spring Data JPA
* Spring Data REST
* Hibernate
* PostgreSQL
* Lombok
* Maven
* Postman

Les TP suivants introduiront également :

* MapStruct
* DTO Pattern
* Modular Architecture
* Microservices Architecture

---

# TP1 — API REST Monolithique

## Objectif

Construire une **API REST simple pour gérer des produits d’un système e-commerce**.

Ce TP permet de comprendre :

* l’architecture d’une application Spring Boot
* la création d’API REST
* l’utilisation de Spring Data JPA
* la connexion à une base de données PostgreSQL
* la gestion des relations entre entités

---

## Architecture du TP1

Le projet suit une architecture en couches :

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

Structure :

```
com.ecommerce.monolith.product
│
├── controller
│   └── ProductController
│
├── service
│   └── ProductService
│
├── repository
│   └── ProductRepository
│
└── model
    ├── Product
    └── Category
```

---

## Base de Données

Le TP utilise **PostgreSQL**. Assurer vous lire le fichier **application.propreties**  pour le mettre a jour avant de lancer l'app.

Schéma simplifié :

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

---

## Endpoints API

### Produits

| Méthode | Endpoint             | Description           |
| ------- | -------------------- | --------------------- |
| GET     | `/api/products`      | Liste des produits    |
| GET     | `/api/products/{id}` | Détail d'un produit   |
| POST    | `/api/products`      | Création d'un produit |
| PUT     | `/api/products/{id}` | Mise à jour           |
| DELETE  | `/api/products/{id}` | Suppression           |

---

### Catégories

Les catégories sont exposées automatiquement via **Spring Data REST**.

| Méthode | Endpoint           |
| ------- | ------------------ |
| GET     | `/categories`      |
| POST    | `/categories`      |
| GET     | `/categories/{id}` |
| DELETE  | `/categories/{id}` |

---

## Exemple de Requête

Créer un produit :

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

## Lancer le Projet

### 1. Cloner le repository

```
git clone https://github.com/your-username/TP_GeniLogiciel.git
```

---

### 2. Configurer PostgreSQL

Créer la base de données :

```
CREATE DATABASE ecommerce;
```

---

### 3. Configurer `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4. Lancer l'application

```
mvn spring-boot:run
```

L'API sera accessible sur :

```
http://localhost:8080
```

---

# TP2 — Monolithe Modulaire

⚠️ **En cours de développement**

Le TP2 vise à restructurer l'application monolithique en **modules métier distincts** afin d'améliorer la maintenabilité et préparer une transition vers une architecture microservices.

Concepts introduits :

* Modular Monolith
* DTO Pattern
* Mapper Pattern
* Service Interface + Implementation
* MapStruct
* Domain Boundaries

Structure prévue :

```
com.ecommerce.monolith
│
├── product
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   ├── dto
│   └── mapper
│
├── order
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   ├── dto
│   └── mapper
```

Cette architecture permet de **séparer les domaines métier** et facilite une future migration vers des **microservices indépendants**.

---

# TP3 — Architecture Distribuée

⚠️ **À venir**

Le TP3 introduira une **architecture distribuée basée sur des microservices**.

Objectifs :

* découper l'application en services indépendants
* communication entre services
* API Gateway
* service discovery
* gestion des bases de données par service

---

# Auteur

Thierno Mamoudou BAH

Projet réalisé dans le cadre du module **Génie Logiciel**.
