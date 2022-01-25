# CheckMeAPI

## Histories d'usuaris:

## Preparació: 

1. Per poder treballar amb les llistes haviem creat una classe auxiliar "TList", posant-li com a atributs el ID, el nom i el filtre per fer-ho servir desrpés.
2. A més hem afegit la interface "ListRepository", servei "ListService" i controlador "ListController".

### HU_№1
#### Crear una llista:

La funcio addList() crea la llista de tasques buida amb atributs indicats per l'usuari, fent servir el ResponseEntity i el servei de listService que permet guardar la llista.

_/todolists_

### HU_№2
#### Eliminar una llista:

La funcio deleteList() comprova si existeix la llista segons el seu ID i si existeix, l'elimina. En el cas de que la llista no existeix - retorna "Not found".

_/todolists_

### HU_№3
#### Modificar llistes:

Per poder modificar una llista primer comprova si la llista existeix fent servir el seu ID i si dona "True" - aplica els canvis escrits pel usuari i els guarda a la BBDD.

_/todolists/{idLlista}_

### HU_№4
#### Mostrar llistes:

Per mostrar totes les llistes i el seus continguts utilitzem la funció listLists() que, gràcies al JPA, mostra totes les llistes que tenim guardades en la BBDD. 

_/todolists_

### HU_№5
#### Consultar tots els ítems d’una llista:

Per això utilitzem la funció getList() per obtenir la llista i amb listTasksByLists().obtenim tots els ítems segons l'ID de la llista proporcionat.

_/todolists/{idLlista}/todoitems_

### HU_№6
#### Consultar un ítem per id: 

Per consultar una tasca dins de la llista utilitzem la funció getTaskInList() que, segons els dos IDs que rep (ID llista - ID tasca), primer troba la llista amb el ID_№1 i després, dins d'aquest busca la tasca amb el ID_№2.

_/todolists/{idLlista}/todoitems/{idItem}_

### HU_№7
#### Afegir tasques en llistes:

La funció addTaskInList() situada en el ListController s'aprofita de la funció addTask() que està en el TaskController. En la llista del ID que indica l'usuari crea una tasca amb els atributs introduits. Si la llista no existeix - retorna l'error "Not found"

_/todolists/{idLlista}/todoitems_

### HU_№8
#### Marcar/desmarcar una tasca de llista:

El atribut "done" de tipus boolean ens permet, utilitzant la funció taskDone() canviar el seu valor. Agafa la tasca i, si el "done" està en "false" - el canvia al "true" i al contrari. En aquesta modificació no fa falta passar una nova tasca (format JSON), automàticament canvia el valor de la que l'indiquem amb l'ID.

_/todolists/{idLlista}/todoitems/{idItem}_

### HU_№9
#### Eliminar ítem de llista:

La funció deleteTaskInList() del ListController aprofita la funció deleteTask() del TaskController agafant primer el ID de la llista i després el de la tasca. Si un dels dos no existeix - retorna l'error "Not found".

_/todolists/{idLlista}/todoitems/{idItem}_
