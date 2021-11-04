# TP1 Jean-Michel REMEUR, Thomas LACAZE LSI-1

## Exo 1

### Proposer un arbre XML pour représenter le film décrit ci-dessus (Les brigades du tigre).

Voici notre proposition d'arbre pour le film `Les bridages du tigre`:
```xml
<film title='Les Brigades du Tigre' kind='Policier' director='Jérôme Cornuau'
    year='2005' description='Les aventures du commissaire Valentin et des inspecteurs Terrasson et Pujol, 
    membres des Brigades mobiles, corps spécial de la police française créé avant la Première Guerre mondiale.'>
    <actors>
        <actor>C. Cornillac</actor>
        <actor>D. Kruger</actor>
        <actor>E. Baer</actor>
    </actors>
    <languages>
        <lang>VF (en Français)</lang>
    </languages>
    <notes>
        <presse>3/5</presse>
        <spectateurs>3/5</spectateurs>
    </notes>
    <schedules>
        <day name='Mer'>
            <hour>14:00</hour>
            <hour>16:40</hour>
            <hour>19:40</hour>
            <hour>22:10</hour>
        </day>
        <day name='Sam'>
            <hour>14:00</hour>
            <hour>16:40</hour>
            <hour>19:40</hour>
            <hour>22:10</hour>
        </day>
        <day name='Jeu'>
            <hour>14:00</hour>
            <hour>19:40</hour>
            <hour>22:10</hour>
        </day>
        <day name='Ven'>
            <hour>14:00</hour>
            <hour>19:40</hour>
            <hour>22:10</hour>
        </day>
        <day name='Lun'>
            <hour>14:00</hour>
            <hour>19:40</hour>
            <hour>22:10</hour>
        </day>
        <day name='Mar'>
            <hour>14:00</hour>
            <hour>19:40</hour>
            <hour>22:10</hour>
        </day>
        <day name='Dim'>
            <hour>10:20</hour>
            <hour>14:00</hour>
            <hour>16:40</hour>
            <hour>20:20</hour>
        </day>
    </schedules>
</film>
```
__Voir annexe Exercice1/exo1.xml__

### Quels éléments faut-il ajouter pour construire un document XML représentant l'ensemble du programme d'un cinéma?

Il faudra rajouter un élément tel que `Films` pour avoir la liste des films qui sont présentés au cinéma.
On peut aussi rajouter un élément `Cinéma` au dessus de `Films` et rajouter des attributs tel que lieu, les horarires ou les prix.


Voici un exemple
```xml
<cinema>
    <films>
        <film>
        </film>
    </films>
</cinema>
```

### Proposer une DTD pour valider les arbres XML représentant les programmes de cinéma. Votre DTD devra imposer les contraintes suivantes :

```dtd
<!ELEMENT film (actors,languages,notes,schedules)>
<!ATTLIST film
  description CDATA #IMPLIED
  director CDATA #IMPLIED
  kind NMTOKEN #IMPLIED
  title CDATA #REQUIRED
  year CDATA #IMPLIED>

<!ELEMENT actors (actor)+>
<!ATTLIST actors>

<!ELEMENT languages (lang)>
<!ATTLIST languages>

<!ELEMENT notes (presse?|spectateurs?)*>
<!ATTLIST notes>

<!ELEMENT schedules (day)+>
<!ATTLIST schedules>

<!ELEMENT actor (#PCDATA)>
<!ATTLIST actor>

<!ELEMENT lang (#PCDATA)>
<!ATTLIST lang>

<!ELEMENT presse (#PCDATA)>
<!ATTLIST presse>

<!ELEMENT spectateurs (#PCDATA)>
<!ATTLIST spectateurs>

<!ELEMENT day (hour)+>
<!ATTLIST day
  name NMTOKEN #REQUIRED>

<!ELEMENT hour (#PCDATA)>
<!ATTLIST hour>
```
__Voir annexe Exercice1/exo1.dtd__

### Proposer une DTD qui soit la moins restrictive possible pour valider les arbres XML représentant les programmes de cinéma. Cette dernière doit prendre en compte les éléments décrivant un film dans n'importe quel ordre.

Il y a plusieurs possibilité pour ne pas prendre en l'ordre des éléments.

```dtd
(year|title|author|weblink|comments?)*
```
Avec des pipes et une étoiles à la fin, cependant cette solution permet aussi de dupliquer des mêmes éléments.

```dtd
((year|title|author|weblink|comments?) | (title|year|author|weblink|comments?))
```
On peut mettre toutes les ordres possibles, cela est assez long lorsque l'on a de nombreux sous éléments.

Nous avons choisi de prendre la première syntax car elle est plus courte et consise.

__Voir annexe Exercice1/exo1_flex.dtd__

## Exo 2

### Proposez  une  DTD  qui  respecte  l’ordre  d’apparition des  balises  énumérées dans le fichier XML

__Voir annexe Exercice2/biblio.dtd__

### Proposez une DTD, moins restrictive, qui n’impose pas cet ordre. Expliquez vos choix sous la forme de commentaires dans la DTD

__Voir annexe Exercice2/biblio_flex.dtd__


## Pour les GEEKS

__Voir annexe Geeks/__