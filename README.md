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

#### Some functional informations

La tondeuse peut être programmée pour parcourir l'intégralité de la surface.
La position de la tondeuse est représentée par une combinaison de coordonnées (x,y) et d'une
lettre indiquant l'orientation selon la notation cardinale anglaise (N,E,W,S). La pelouse est
divisée en grille pour simplifier la navigation.

Par exemple, la position de la tondeuse peut être « 0, 0, N », ce qui signifie qu'elle se situe
dans le coin inférieur gauche de la pelouse, et orientée vers le Nord.

Pour contrôler la tondeuse, on lui envoie une séquence simple de lettres. Les lettres possibles
sont « D », « G » et « A ». « D » et « G » font pivoter la tondeuse de 90° à droite ou à gauche
respectivement, sans la déplacer. « A » signifie que l'on avance la tondeuse d'une case dans la
direction à laquelle elle fait face, et sans modifier son orientation.

Si la position après mouvement est en dehors de la pelouse, la tondeuse ne bouge pas,
conserve son orientation et traite la commande suivante.

On assume que la case directement au Nord de la position (x, y) a pour coordonnées (x, y+1).

Chaque tondeuse se déplace de façon séquentielle, ce qui signifie que la seconde tondeuse ne
bouge que lorsque la première a exécuté intégralement sa série d'instructions.

Lorsqu'une tondeuse achève une série d'instruction, elle communique sa position et son
orientation.

#### Prepare the configuration file

Pour programmer la tondeuse, on lui fournit un fichier d'entrée construit comme suit :

● La première ligne correspond aux coordonnées du coin supérieur droit de la pelouse, celles
du coin inférieur gauche sont supposées être (0,0)

● La suite du fichier permet de piloter toutes les tondeuses qui ont été déployées. Chaque
tondeuse a deux lignes la concernant :
  ● La première ligne donne la position initiale de la tondeuse, ainsi que son orientation. La
    position et l'orientation sont fournies sous la forme de 2 chiffres et une lettre, séparés
    par un espace
  ● La seconde ligne est une série d'instructions ordonnant à la tondeuse d'explorer la
    pelouse. Les instructions sont une suite de caractères sans espaces.

#### Launching

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
