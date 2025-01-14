//Sei thread, uno scrittore e 5 lettori. Lo scrittore scrive su un buffer numeri dispari da 0 a 50 nelle posizioni pari e numeri pari da 50 a 100 nelle posizioni dispari. 
//I lettori leggono coppie di numeri (paro, disparo), li somma e li stampa.
#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

#define BUFFER_SIZE 10

int buffer[BUFFER_SIZE];

sem_t semaphoreLettore; //Semaforo per i lettori
sem_t semaphoreScrittore; //Semaforo per lo scrittore

//funzione eseguita dallo scrittore
//lo scrittore dopo aver scritto i numeri nel buffer, deve rimanere sospeso
void *scrittoreFunzione() {

    sem_wait(&semaphoreScrittore); //blocco il semaforo dello scrittore 

    //scrivo i numeri nel buffer
    for (int i = 0; i < BUFFER_SIZE; i++) {


        if (i % 2 == 0) {

            //se la posizione è pari scrivo un numero dispari in quella posizione
            int num = rand() % 51;

            //finche il numero generato è pari genero un altro numero (perche devo scrivere un numero dispari)
            while (num % 2 == 0) {
                num = rand() % 51;
            }

            //scrivo il numero dispari nella posizione i
            buffer[i] = num;
            printf("[Scrittore] - Ho inserito il numero %d in posizione %d\n", num, i);

        } else {

            //stessa cosa per i numeri pari (devo scrivere un numero pari in una posizione dispari)
            int num = rand() % 50 + 101;
            while (num % 2 != 0) {
                num = rand() % 50 + 101;
            }
            buffer[i] = num;
            printf("[Scrittore] - Ho inserito il numero %d in posizione %d\n", num, i);
        }
    }

    // ATTENZIONE
    //non devo rilasciare il semaforo dello scrittore perchè altrimenti lo scrittore potrebbe riattivarsi e scrivere nuovamente nel buffer
    //quindi faccio la post (up) solamente sul semafori dei lettori
    //fino ad adesso i lettori sono stati sospesi poichè il semaforo dei lettori è stato iniziato a 0 quindi i lettori non possono procedere finchè il valore del semaforo non è > 0
    sem_post(&semaphoreLettore);

    //termino il thread
    pthread_exit(0);
}

//funzione eseguita dai lettori
void *lettoreFunzione(void *i) {

    while (1) {

        //blocco il semaforo dei lettori eseguendo la wait quindi decrementando il valore del semaforo
        //ricordiamoci che se il valore del semaforo è 0 il thread si sospende
        sem_wait(&semaphoreLettore);

        printf("Sono il lettore");  

        //il lettore deve leggere una coppia di numeri (pari, dispari) e stampare la loro somma
        //ricordiamoci che i numeri pari sono contenuti nelle posizioni dispari e i numeri dispari nelle posizioni pari del buffer

        // leggo il numero dispari
        int positionPari = rand() % 10; //estraggo una posizione casuale dalla quale leggere il numero pari
        int numeroEstratto = buffer[positionPari]; //leggo il numero dalla posizione estratta
        
        //se il numero estratto è dispari estraggo un altro numero finche non estraggo un numero pari
        while ((numeroEstratto % 2) != 0) {
            int positionPari = rand() % 10;
            printf("[Estrazione pari] - Ho estratto il numero %d dalla posizione %d\n",buffer[positionPari],positionPari);
        }
        
        //numero pari estratto
        int numeroPari = buffer[positionPari];

        // ora leggo il numero pari (in una posizione dispari)
        int positionDispari = rand() % 10;
        while ((buffer[positionDispari] % 2) == 0) {
            int positionDispari = rand() % 10;
            printf("[Estrazione dispari] - Ho estratto il numero %d dalla posizione %d\n",buffer[positionPari],positionPari);
        }
        //numero dispari estratto
        int numeroDispari = buffer[positionDispari];

        //stampo i numeri estratti
        printf("\n[Lettore: %d] - Ho letto il numero pari: %d\n", i, numeroPari);
        printf("\n[Lettore: %d] - Ho letto il numero dispari: %d\n", i, numeroDispari);

        //eseuguo la somma dei numeri
        int sum = numeroPari + numeroDispari;

        //stampo la somma
        printf("\n[Lettore: %d] - Somma dei numeri %d\n", i, sum);

        //rilascio il semaforo dei lettori (incremento il valore del semaforo)
        sem_post(&semaphoreLettore);
    }
    pthread_exit(0);

    // sem_post(&semaphoreLettore);
}

int main() {

    srand(time(NULL));

    pthread_t lettori[5]; //Creo 5 thread lettori
    pthread_t scrittore; //Creo un thread scrittore

    //ATTENZIONE
    sem_init(&semaphoreScrittore, 0, 1); //inizializzo il semaforo dello scrittore a 1 (il valore 1 è > 0 quindi il thread non si sospende e può partire subito)
    
    //ATTENZIONE: inizializzo il semaforo dei lettori a 0 (il valore 0 è < 0 quindi il thread si sospende e quindi i lettori non possono partire finchè il valore del semaforo non è > 0)
    //questo perchè il semaforo dei lettori deve essere bloccato finchè lo scrittore non ha scritto nel buffer
    //quando lo scrittore ha scritto il buffer incrementa il valore del semaforo dei lettori e quindi i lettori possono partire
    sem_init(&semaphoreLettore, 0, 0); 

    //Creo il thread scrittore
    pthread_create(&scrittore, NULL, scrittoreFunzione, NULL);

    //Creo i thread lettori
    for (int i = 0; i < 5; i++) {
        pthread_create(&lettori[i], NULL, lettoreFunzione, (void *)i);
    }

    //Attendo la terminazione dei thread
    pthread_join(scrittore, NULL);
    for (int i = 0; i < 5; i++) {
        pthread_join(lettori[i], NULL);
    }

    return 0;
}