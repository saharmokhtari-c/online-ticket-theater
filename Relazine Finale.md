## RELAZIONE FINALE - Sezione Tecnico-Operativa


## 1. Scelte progettuali effettuate

Il progetto è stato sviluppato seguendo un'architettura layered. Lato Backend, lo sviluppo è iniziato con la definizione delle classi di dominio in Java
(Cliente, Teatro, Spettacolo, Replicha, Biglietto), definendo le relazioni JPA (@OneToMany, @ManyToOne).
Il database relazionale è stato creato su MySQL Workbench delegando ad Hibernate la creazione automatica delle tabelle (ORM), mentre l'inserimento iniziale dei dati è avvenuto tramite script SQL.
Lato Frontend, è stata scelta una struttura pulita e modulare separata in 3 file (Index.html, Style.css e App.js) per garantire la separazione delle responsabilità tra struttura, stile e logica.


## 2. Tecniche utilizzate per la definizione delle procedure, interfaccia grafica e gestione dei dati

Interfaccia Grafica (Frontend): Per la creazione dell'interfaccia utente sono stati utilizzati HTML (per i moduli di inserimento e le tabelle di visualizzazione), CSS3 (per il layout responsive e la formattazione visuale) e JavaScript per la gestione dinamica degli eventi, la validazione dei dati e la comunicazione asincrona con le API REST tramite Fetch API.

Repository Layer: Utilizzo di Spring Data JPA per la gestione e manipolazione dei dati.
Service Layer: Implementazione della logica di business nel BigliettoService (controllo capienza e aggiornamento biglietti).
Controller Layer: Esposizione degli endpoint REST per l'interazione con il frontend.


## 3. Problematiche riscontrate e modalità di risoluzione

Discrepanze nel Naming Conventions (Mappatura ORM): Durante la creazione delle tabelle si sono verificati errori legati all'incompatibilità tra i nomi degli attributi Java e le colonne del DB.
Il problema è stato risolto configurando accuratamente le annotazioni @Table e @Column(name = "...").
Convenzione di Naming dei Metodi nel Repository Layer: Una sfida importante è stata l'apprendimento delle regole dei Derived Query Methods di Spring Data JPA (es.
findByClienteCodClienteAndReplichaCodreplica) e l'uso di query JPQL personalizzate tramite @Query per gestire filtri e ordinamenti dinamici.
