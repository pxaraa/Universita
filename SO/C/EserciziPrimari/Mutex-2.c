//Si scriva un programma con tre thread che risolvono il seguente problema:
//Un buffer di n elementi inizializzato con a -1 viene riempito nel seguente modo:
//    - Il primo thread aggiunge nelle posizioni pari del buffer un numero casuale da 0 a 100.
//    - Il secondo thread aggiunge nelle posizioni dispari del buffer un casuale da 100 a 200.
//    - Il terzo thread somma gli elementi e modifica il buffer nel seguente modo:
//        buff[0] = buff[0], buff[1] = buff[1] + buff[0], buff[2] = buff[1] + buff[2]  quindi aggiungendo il valore attuale + il valore precedente.
//Si proponga una soluzione di mutua esclusione.

//Librerie
#include <pthread.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define bufferSize 10 //definisco la dimensione del buffer

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

int array[10] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}; //inizializzo il buffer con 10 -1

//funzione che verrà eseguita dal primo thread
void generaPari(){

    for(int i = 0; i < bufferSize; i++){

        if(i%2==0){

            //se mi trovo qui dentro significa che la cella è in posizione pari

            //blocco il mutex
            pthread_mutex_lock(&mutex);

            int randomNumber = rand() % 101; //genero un numero casuale da 0 a 100

            array[i] = randomNumber; //inserisco il numero casuale nella cella i-esima

            printf("[Thread pari] - generato il numero %d e inserito nella cella %d\n",randomNumber,i);

            pthread_mutex_unlock(&mutex); //rilascio il mutex
        }
    }
    
    pthread_cond_signal(&cond); //invio un segnale a tutti i thread in attesa che sta rilasciando il mutex
    printf("[Thread pari] - ho lanciato il segnale\n");
    pthread_exit(NULL); //termino il thread
}

//steessa cosa del metodo precedente ma con la differenza che inserisco i numeri nelle celle in posizione dispari
void generaDispari(){

    for(int i = 0; i < bufferSize; i++){

        if(i%2==1){

            pthread_mutex_lock(&mutex);

            int randomNumber = rand() % 101 + 100;

            array[i] = randomNumber;

            printf("[Thread dispari] - generato il numero %d e inserito nella cella %d\n",randomNumber,i);

            pthread_mutex_unlock(&mutex);
        }
    }

    pthread_cond_signal(&cond);
    printf("[Thread dispari] - ho lanciato il segnale\n");
    pthread_exit(NULL);
}

//metodo eseguito dal terzo thread
void sumBuffer(){

    int sum = 0;

    //blocco il mutex
    pthread_mutex_lock(&mutex);

    //con questo loop aspetto che il buffer sia inizializzato
    //se il numero in ultima posizione OPPURE il numero in penultima posizione è -1 allora signfica che i 2 thread non hanno ancora inizializzato tutto il buffer
    //ricordiamoci che i 2 thread riempiono il buffer in ordine lineare ovvero partendo dalla prima cella fino all'ultima
    //quindi in caso di buffer pieno la penultima e ultima cella conterranno un numero diverso da -1
    while(array[bufferSize-1] == -1 || array[bufferSize-2] == -1){

        printf("[Thread sommatore] - Mi sospendo perchè il buffer non è ancora inizializzato\n");

        //mi sospendo finchè non arriva un segnale da uno dei 2 thread
        //ogni volta che arriva un segnale mi sveglio e controllo se il buffer è inizializzato nuovamente
        pthread_cond_wait(&cond,&mutex);
    }

    //sblocco il mutex 
    pthread_mutex_unlock(&mutex);
    
    //ora che il buffer è inizializzato posso procedere con la somma e con la modifica del buffer
    for(int i = 0; i < bufferSize; i++){

        //blocco il mutex
        pthread_mutex_lock(&mutex);

        //se mi trovo nella seconda cella in poi sommo il numero contenuto nella cella i-esima con il numero contenuto nella cella precedente
        if(i > 1){

            printf("[Cella %d] - numero contenuto: %d numero nella cella precedente: %d\n",i,array[i],array[i-1]);
            array[i] = array[i] + array[i-1]; 
        }else{

            //naturalmente la prima cella non ha una cella precedente quindi non devo fare nulla
            printf("[Cella %d] - numero contenuto: %d\n",i,array[i]);
        }

        //sommo il nuovo numero contenuto nella cella i-esima
        printf("[Cella %d] - nuovo numero contenuto: %d\n",i,array[i]);

        //somma della cella i-esima
        sum = sum + array[i];

        //rilascio il mutex
        pthread_mutex_unlock(&mutex);
    }

    //stampo la somma totale del buffer
    printf("Somma totale del buffer: %d\n",sum);
    pthread_exit(NULL);
}

int main(){

    srand(time(NULL));

    pthread_t t1,t2,t3;

    pthread_create(&t1,NULL,generaPari,NULL);
    pthread_create(&t2,NULL,generaDispari,NULL);
    pthread_create(&t3,NULL,sumBuffer,NULL);
    pthread_join(t1,NULL);
    pthread_join(t2,NULL);
    pthread_join(t3,NULL);

    pthread_mutex_destroy(&mutex); //distruzione del mutex
    pthread_cond_destroy(&cond); //distruzione della variabile di condizione

    return 0;
}