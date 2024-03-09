### EmployeeManager
Un azienda è interessata a realizzare un applicativo per l'inserimento e la tracciatura del proprio personale. Un dipendente è caratterizzato da un nome, cognome, data di nascita, email e numero di telefono. Può inoltre ricoprire una sola mansione tra le seguenti:
** *dirigente, sviluppatore, risorse umane* **

Le mansioni sono collegate a informazioni aggiuntive associate al dipendente:
   - **dirigente**: è caratterizzato da un reparto e da un codice rappresentativo del team che sovrintende e da un livello di responsabilità[1,2,3]
   - **sviluppatore**: è caratterizzato da un reparto, un team di appartenza e un linguaggio(java, golang, react..)
   - **tester**: è caratterizzato da un reparto e da un team di appartenza
   - **risorse umane**: è caratterizzato da una mansione

**Table of Contents**

[TOCM]

Caratteristiche applicativo
=============

Realizzare un programma che permetta il salvataggio del personale(in memoria, storage non richiesto ma gradito) e la sua visualizzazione tramite un interfaccia grafica come segue:
![](https://i.ibb.co/3fXLXpD/example-employee-manager.png)

- Il programma deve rimanere sempre attivo fintanto che non viene invocata la exit
- I comandi devono essere case-insensitive
- Al termine di una richiesta lo schermo deve essere ripulito di tutto l'output precedente

Specifiche Operazioni
=============
Di seguito saranno riportate le specifiche di ogni operazione

Add Employee
-------------
Deve permettere l'inserimento di un dipendente fornendo tutte le informazioni necessarie solo se non è già presente(coppia nome-cognome univoca). Se è già presente deve inviarmi una stringa informativa prima di riportarmi alla schermata iniziale

Search Employee
-------------
Si richiede la stampa di tutti gli attributi per i quali è possibile svolgere una ricerca, gli attributi attesi sono:
- qualunque informazione di qualunque tipologia di utente
- la tipologia di utente

Si deve poter selezionare uno degli attributi, inserirne il valore e svolgere la ricerca su tutti i dati. Se un impiegato non possiete l'attributo richiesto deve essere ignorato, ogni operazione ci si aspetta sia assistita(si deve avere una lista di tutti gli attributi selezionabili prima di inserirlo e nel caso l'attributo faccia parte di un enumazione, devo sapere in anticipo quali sono i valori inseribili). Se un attributo/valore non esiste devo essere avvertito e subito data la possibilità di svolgere una nuova ricerca(senza tornare alla pagina principale).  Prima di mostrarmi i risultati l'applicativo mi deve richiedere se ho terminato l'operazione o desidero applicare un nuovo filtro, stavolta solo sui risultati ottenuti dallo step precedente

Update Employee
-------------
Deve permettere la selezione di un singolo dipendente da aggiornare fornendo nome e cognome. Se non presente mi deve riportare alla pagina iniziale, viceversa mi deve permettere di scegliere un attributo e modificargli il valore. Sarà possibile modificare solo un attributo alla volta, tuttavia l'operazione deve terminare solo su esplicita richiesta in modo da permettere all'utente di modificare più attributi senza dover effettuare una nuova ricerca

**[NOTA BENE: si deve poter modificare anche la tipologia di dipendente con tutto quello che ne consegue]**

Delete Employee
-------------
Deve permettere l'eliminazione di un dipendente fornendo il suo nome e cognome
