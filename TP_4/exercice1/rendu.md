# Exercice 1

## 1.
La racine du document.
```
/
```

## 2.
Les éléments CCC qui ont comme balise mère la racine.
```
/AAA/CCC
```

## 3.
Les éléments BBB qui ont comme balise mère DDD et balise grand-mère la
racine (AAA).
```
AAA/DDD/BBB
```

## 4.
Tous les éléments BBB quel qu’il soit leur position dans le fichier.
```
//BBB
```

## 5.
Tous les BBB fils de DDD.
```
//DDD/BBB
```

## 6.
Tous les fils de la racine.
```
/AAA/*
```

## 7.
Tous les éléments BBB qui ont au moins un ancêtre.
```
//*/BBB
```

## 8.
Tous les éléments BBB qui ont trois ancêtres.
```
*/*/*/BBB
```

## 9.
Tous les éléments dans le document.
```
/*
```

## 10.
Le premier fils BBB de la racine du document.
```
/AAA/BBB[1]
```

## 11.
Le dernier fils BBB de quelconque balise.
```
//BBB[last()]
```

## 12.
Tous les attributs ID peu importe leur localisation dans les balises.
```
//@id
```

## 13.
Les balises BBB qui ont un attribut NOM.
```
//BBB[@nom]
```

## 14.
Les balises BBB qui ont un atribut NOM de valeur « toto ».
```
//BBB[@nom = 'toto']
```

## 15.
Toutes les balises BBB qui ont au moins un attribut.
```
//BBB[@*]
```

## 16.
Toutes les balises BBB qui n’ont pas d’attributs.
```
//BBB[not(@*)]
```

## 17.
Tous les noeuds QQQ ayant l’attribut ID=’q1’
```
//QQQ[@id='q1']
```

## 18.
Tous les éléments qui ont deux fils BBB.
```
//*[count(BBB)=2]
```

## 19.
Tous les éléments qui ont deux fils.
```
//*[count(*) = 2]
```

## 20.
Tous le éléments qui ont un nom qui commence par ‘B’ (starts-with(name(),'B'))
```
//*[(starts-with(name(),'B'))]
```

## 21.
Tous les éléments qui ayant la lettre C dans leur nom (contains(name(),'C'))
```
//*[contains(name(),'C')]
```

## 22.
Tous les éléments ayant un nom de longueur 3 (string-length(name()) = 3)
```
//*[(string-length(name()) = 3)]
```

## 23.
Tous les éléments BBB ou CCC.
```
//BBB | //CCC
```

## 24.
Le parent d’une balise BBB.
```
//BBB/..
```

## 25.
Tous les EEE fils de AAA et tous les BBB.
```
//AAA/EEE | //BBB
```

## 26.
Les parents de type AAA d’un élément DDD.
```
//DDD/../../AAA
```

## 27.
Les voisins précédents de DDD. Les voisins suivant de DDD.
```
//DDD/preceding::* | //DDD/following::*
```

## 28.
Tous les ancêtres des tous les éléments QQQ.
```
//QQQ/..
```

## 29.
Tous les descendants des tous les éléments FFF.
```
//FFF/*
```

## 30.
L’élément suivant de XXX.
```
//XXX/following-sibling::*[1]
```

## 31.
L’élément précédant XXX.

```
//XXX/preceding-sibling::*[1]
```

## 32.
Si FFF est fils de AAA alors chercher tous les éléments descendants de FFF et
l’élément FFF lui-même.
```
/AAA/FFF/* | /AAA/FFF
```

## 33.
Tous les éléments BBB de deux en deux (fils du même élément).
```

```

## Contenu du XML 

```xml
<AAA>
  <BBB />
  <BCD />
  <CCC>
    <BBB nom='titi' />
    <BBB nom='toto' />
  </CCC>
  <BBB />
  <BBB />
  <XXX />
  <DDD>
    <BBB />
    <EEE />
  </DDD>
  <FFF id='123'>
    <BBB id='abc' />
    <QQQ id='q1'>
      <BBB />
      <ZZZ />
    </QQQ>
    <QQQ id='q2' />
  </FFF>
  <CCC />
</AAA> 
```

# Exercice 2

# Exercice 3