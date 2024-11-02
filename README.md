# Système de Gestion des Dons et des Donateurs

## Introduction
Ce projet est une application web pour la gestion des dons au sein d'une association caritative. Elle permet d'organiser et de suivre les dons réalisés par divers donateurs, en associant chaque don à une campagne spécifique. L'objectif principal est de simplifier la gestion des informations des donateurs, des dons et des campagnes.

## Fonctionnalités
- **Gestion des Donateurs** : Ajouter, modifier, visualiser et supprimer des donateurs.
- **Gestion des Dons** : Ajouter, modifier, visualiser et supprimer des dons, chaque don étant lié à un donateur et une campagne.
- **Gestion des Campagnes** : Ajouter, modifier, visualiser et supprimer des campagnes.
- **Affichage des Détails** : Visualisation des détails d'un donateur, incluant la liste de tous les dons qu'il a effectués.

## Conception du Projet

### Structure des Entités

1. **Donateur** : Représente les personnes effectuant des dons. Les attributs incluent le nom, l'adresse et l'email.
2. **Don** : Représente les contributions financières faites par les donateurs. Les attributs incluent le montant, la date et les liens vers le donateur et la campagne correspondante.
3. **Campagne** : Représente les campagnes de collecte de fonds organisées par l'association. Les attributs incluent le nom, la description, les dates de début et de fin, ainsi que l'objectif de collecte.

### Contrôleurs
1. **DonateurController** : Gère les opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) pour les donateurs.
2. **DonController** : Gère les opérations CRUD pour les dons, y compris les relations avec les donateurs et les campagnes.
3. **CampagneController** : Gère les opérations CRUD pour les campagnes.

### Fichiers HTML (Interface Utilisateur)

- **index.html** : Page d'accueil du système, offrant une vue générale et des liens vers les sections Donateurs, Dons et Campagnes.
- **addDon.html** : Formulaire pour ajouter un nouveau don.
- **addDonateur.html** : Formulaire pour ajouter un nouveau donateur.
- **Campagne.html** : Formulaire pour ajouter une nouvelle campagne.
- **detailsDonateur.html** : Page affichant les détails d'un donateur spécifique, incluant la liste de ses dons.
- **editDon.html** : Formulaire pour modifier un don existant.
- **editDonateur.html** : Formulaire pour modifier les informations d'un donateur.
- **listCampagnes.html** : Affichage de la liste de toutes les campagnes.
- **listDonateurs.html** : Affichage de la liste de tous les donateurs.
- **listDons.html** : Affichage de la liste de tous les dons.

### Diagramme de Classe

Voici un aperçu du diagramme de classe basé sur ma conception :
- **Campagne** contient un `id`, `nom`, `description`, `dateDebut`, `dateFin`, `objectif` et une liste de dons associés.
- **Donateur** contient un `id`, `nom`, `adresse`, `email` et une liste de dons associés.
- **Don**   contient un `id`, `montant`, `date` et des références à un `donateur` et une `campagne`.
  ![donation_management_class_diagram](https://github.com/user-attachments/assets/e7ce6f90-7415-42a1-a222-da32bbe8ae02)


## Structure du Projet
Le projet est structuré de manière modulaire avec les packages et répertoires suivants :

- **src/main/java/com/salma/don_Donnateur**
  - **controller** : Contient les contrôleurs `CampagneController`, `DonController`, `DonateurController` pour gérer les opérations CRUD.
  - **entities** : Définit les entités `Campagne`, `Don`, `Donateur` qui sont les classes représentant les tables dans la base de données.
  - **repositories** : Gère l'accès aux données pour les entités via les interfaces de repository.

- **src/main/resources/templates** : Contient les fichiers HTML pour l'interface utilisateur.
- **src/main/resources/application.properties** : Contient la configuration de la base de données et des paramètres de l'application.

## Installation et Exécution

1. **Pré-requis** :
   - Java 17+
   - Maven
   - Base de données MySQL

2. **Configuration de la base de données** :
   - Créez une base de données MySQL nommée `don-donateurs`.
   - Configurez les paramètres de la base de données dans `application.properties`.

3. **Exécution** :
   - Exécutez l'application .
   - Accédez à l'application sur `http://localhost:8080`.

## Vidéo de démonstration:

