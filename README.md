 Online Learning Platform
Plateforme d’apprentissage en ligne basée sur une architecture " microservices Spring Boot ", permettant la gestion des cours, des enseignants et des étudiants.
 Description
Cette application vise à fournir une solution complète pour la gestion d’une plateforme e-learning moderne, incluant :
- la gestion des cours
- l’inscription des étudiants
- le suivi statistique
- la sécurisation via un service d’authentification
- la communication inter-services
Architecture
L’application repose sur une **architecture microservices** avec :

- API Gateway pour le routage
- Service Discovery pour la découverte dynamique
- Séparation claire des responsabilités métier
- Communication REST et WebClient

 Microservices : 
API Gateway
- Point d’entrée unique de l’application
- Routage des requêtes vers les microservices
- Centralisation des appels clients
Discovery Service
- Service de découverte basé sur **Eureka**
- Enregistrement et résolution des microservices
Auth Service
- Gestion de l’authentification et de la sécurité
- Validation des utilisateurs
- Protection des endpoints
Cours Service
Fonctionnalités :
- Gestion des cours
- CRUD cours et enseignants
Technologies :
- Spring Data REST
Inscription Service
Fonctionnalités :
- Inscription des étudiants aux cours
- Gestion des relations étudiants ↔ cours
Technologies :
- Feign Client pour la communication inter-services
 Statistique Service
Fonctionnalités :
- Calcul et exposition des statistiques
- Analyse des données pédagogiques

Technologies :
- WebClient
- Intégration avec des APIs externes (ex : YouTube pour vidéos liées)
 Communication inter-services
- REST APIs
- Feign Client
- WebClient
 Technologies utilisées
- Java 21
- Spring Boot
- Spring Cloud (Gateway, Eureka, OpenFeign)
- Spring Data REST
- Maven
- Lombok
- WebClient
Ordre recommandé de démarrage :

1. Discovery Service  
2. Auth Service  
3. Microservices métier  
4. API Gateway  


## 📁 Structure du projet
