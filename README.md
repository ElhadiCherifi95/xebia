# Xebia: MowItNow project

Dans le cadre d'un processus de recrutement il est demandé de développer une tondeuse à gazon automatique, destinée aux
surfaces rectangulaires.

## Getting Started

Veuillez éxecuter les commandes suivantes dans le dossier désiré pour rapatrier le projet en local pour d'éventuels tests/développements:
```
git init
git remote add origin https://github.com/lafourit/xebia.git
git pull origin
```
### Prerequisites

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Compiler
* [Maven](https://maven.apache.org/) - Dependency Management

### Installing

Veuillez exécuter les commandes dans le dossier contenant le projet pour packager et lancer le projet.
NB: Veuillez spécifier le chemin du fichier en entrée
```
mvn clean install
java -jar target/MowItNow.jar ''''''chemin du fichier en entrée''''''
```

## Running the tests

Veuillez exécuter les commandes dans le dossier contenant le projet pour lancer la totalité des tests du projet.
```
mvn clean test
```

## Authors

* **Elhadi CHERIFI** - *Initial work* - [lafourit](https://github.com/lafourit)
