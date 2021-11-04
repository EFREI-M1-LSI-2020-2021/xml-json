# JSON Path des éléments suivants : 
- Tous les membres de la structure JSON 
```
$
```

- Les  auteurs de tous les  livres 
```
$..book[*]['author']
```

- Tous les  livres 
```
$..book[*]
```

- Les prix de tous les livres  
```
$..book[*]['price']
```

- Le 1er  livre 
```
$..book[0]
```

- Les deux derniers livres  
```
$..book[-2:]
```

- Tous les livres avec le numéro isbn 
```
$..book[?(@.isbn)]
```

- Tous les livres plus chers que 10

```
$.store.book[?(@.price > 10)]
```