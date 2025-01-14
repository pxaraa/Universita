//Scrivere un programma C che segue le seguenti specifiche. Il processo eseguito, inizialmente crea un buffer come array di 11 numeri interi, inizializzati a zero. In seguito genera tre thread utilizzando le librerie POSIX secondo le seguenti specifiche:
//
//Il primo thread sceglie casualmente una cella del buffer e vi scrive il numero +1, qualsiasi sia il valore presente nella cella.
//Il secondo thread sceglie casualmente una cella del buffer e vi scrive il numero -1, qualsiasi sia il valore presente nella cella.
//Il terzo thread controlla se tutte le celle del buffer sono state inizializzate. In caso positivo, determina se il numero di celle contententi un valore pari a +1 è maggiore di quelle con -1 e termina tutti e tre i thread. Mentre un thread ha accesso al buffer, nessun altro thread deve accedervi. Una volta che un thread ha acceduto in lettura o scrittura al buffer, deve attendere un numero di secondi random tra 0 e 3


//Librerie
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

#define BUFFER_SIZE 11 //definisco la dimensione del buffer

int buffer[BUFFER_SIZE] = {0,0,0,0,0,0,0,0,0,0,0}; //inizializzo il buffer con 11 zeri

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER; //creo il mutex e lo inizializzo
pthread_cond_t cond = PTHREAD_COND_INITIALIZER; //creo la variabile di condizione e la inizializzo

//metodo che controlla che il buffer sia stato inizializzato ovvero che non contenga zeri
//restituisce 1 se è stato inizializzato
//0 se NON è stato inizializzato
int checkIfBufferIsInitialized(){

    for(int i = 0; i < BUFFER_SIZE; i++){
        if(buffer[i] == 0){
            return 0;
        }
    }
    return 1;
}


//metodo che stampa il buffer
void printBuffer(){

    for(int i = 0; i < BUFFER_SIZE; i++){
        printf("[%d] -> %d\n",i,buffer[i]);
    }
}

//meotodo che verrà eseguito dal primo thread
int primaRoutine(){

    //loop
    while(1){

        //blocco il mutex
        pthread_mutex_lock(&mutex);

        //scelgo la posizone in cui devo scrivere il valore (casualmente)
        int position = rand() % BUFFER_SIZE;

        //scrivo il valore 1 nella posizione scelta
        buffer[position] = 1;

        printf("[Primo] - Ho scritto 1 nella posizione %d\n",position);

        //invia un segnale a tutti i thread in attesa che sta rilasciando il mutex
        pthread_cond_signal(&cond);

        //sblocco il mutex
        pthread_mutex_unlock(&mutex);
        
        //genero un numero casuale tra 0 e 3 e aspetto quel numero di secondi
        int sleeptime = rand() % 4;

        sleep(sleeptime);
    }
}

//metodo che verrà eseguito dal secondo thread
//fa la stessa cosa del primo thread ma scrive -1 invece di 1
int secondaRoutine(){

    while(1){

        pthread_mutex_lock(&mutex);

        int position = rand() % BUFFER_SIZE;

        buffer[position] = -1;

        printf("[Secondo] - Ho scritto -1 nella posizione %d\n",position);

        pthread_cond_signal(&cond);
        pthread_mutex_unlock(&mutex);

        int sleeptime = rand() % 4;

        sleep(sleeptime);
    }
}

//metodo che verrà eseguito dal terzo thread 
int terzaRoutine(){

    //blocco il mutex
    pthread_mutex_lock(&mutex);

    //con questo loop aspetto che il buffer sia inizializzato
    //quindi ogni volta eseguo la funzione checkIfBufferIsInitialized() e se ritorna 0 significa che il buffer non è inizializzato e quindi aspetto
    while(checkIfBufferIsInitialized() == 0){
        
        //se mi trovo qua dentro significa che il buffer non è inizializzato e devo aspettare che i 2 thread lo inizializzino
        printf("[Terzo] - Buffer non inizializzato attendo\n");

        //stampo semplicemente il buffer
        printBuffer();

        //mi metto in attesa tramite la variabile di condizione sul mutex
        //ogni volta che verrà lanciata una SIGNAL sulla variabile di condizione verrò risvegliato
        pthread_cond_wait(&cond,&mutex);
    }

    //se mi trovo qui significa che il buffer è stato inizializzato

    //contatore per i positivi e i negativi
    int contatorePositivi = 0;
    int contatoreNegativi = 0;

    //conto i positivi e i negativi
    for(int i = 0; i < BUFFER_SIZE; i++){

        if(buffer[i] == 1){
            contatorePositivi++;
        }else{
            contatoreNegativi++;
        }
    }

    //stampo i contatori
    printf("Contatore positivi: %d\n",contatorePositivi);
    printf("Contatore negativi: %d\n",contatoreNegativi);
    printBuffer();
}

int main(){

    //istanzio i 3 thread
    pthread_t p1,p2,p3;

    //creo i 3 thread assegnando ad ognuno la propria funzione da eseguire
    pthread_create(&p1,NULL,primaRoutine,NULL);
    pthread_create(&p2,NULL,secondaRoutine,NULL);
    pthread_create(&p3,NULL,terzaRoutine,NULL);

    //aspetto che i 3 thread terminino
    //questo perchè se il main termina i thread vengono terminati
    //quindi prima che il main termini aspetto che i thread abbiano finito
    pthread_join(p1,NULL);
    pthread_join(p2,NULL);
    pthread_join(p3,NULL);

    return 0;
}