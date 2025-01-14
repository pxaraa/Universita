//Scrivere un programma in C con tre thread che operano su due array di dimensione N inizialmente a 0.
//
//Il primo thread scrive in un array A numeri casuali tra 1 e 150, scrivendo un numero per volta in posizioni randomiche.
//Il secondo thread scrive in un array B numeri cassuali tra 150 e 300, scrivendo un numero per volta in posizioni randomiche.
//Il terzo thread controlla se entrambi gli array sono stati inizializzati, in caso affermativo calcola il massimo in A e in B, calcola il minimo in A e in B. Infine determina il max{max(A), max(B)} e il min{min(A), min(B)}.

#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <stdio.h>

#define BUFFER_SIZE 10

int arrayA[BUFFER_SIZE] = {0,0,0,0,0,0,0,0,0,0}; //array A inizializzato a 0
int arrayB[BUFFER_SIZE] = {0,0,0,0,0,0,0,0,0,0}; //array B inizializzato a 0

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER; //creo e inizializzo il mutex
pthread_cond_t cond = PTHREAD_COND_INITIALIZER; //creo e inizializzo la variabile di condizione

//funzione che controlla se l'array è stato inizializzato
//se trova il numero 0 restituisce 0 quindi signfica l'array non è stato inizializzato
//altrimenti restituisce 1
int checkArray(int *array){

    for(int i = 0; i < BUFFER_SIZE; i++){

        if(array[i] == 0){
            return 0;
        }
    }
    return 1;
}

//funzione che stampa l'array
int printArray(int *array){

    for(int i = 0; i < BUFFER_SIZE; i++){

        printf("[%d] -> %d\n",i,array[i]);
    }
    printf("\n");
}

//funzione che verrà eseguita dal primo thread
void primoThread(){

    while(1){

        //blocco il mutex
        pthread_mutex_lock(&mutex);

        //scelgo una posizione randomica nell'array
        int position = rand() % 11;

        //genero un numero casuale da 1 a 150    
        int number = rand() % 150 + 1;

        arrayA[position] = number; //inserisco il numero casuale generato nella posizione randomica generata

        printf("[Primo] - Ho scritto il numero %d in posizione %d\n",number,position);


        pthread_cond_signal(&cond); //invio un segnale a tutti i thread in attesa che sta rilasciando il mutex
        pthread_mutex_unlock(&mutex); //rilascio il mutex

        sleep(1);
    }
}

//stessa cosa per il secondo thread ma scruve nell'array B e genera numeri da 150 a 300 invece che da 1 a 150
void secondoThread(){

    while(1){

        pthread_mutex_lock(&mutex);

        int position = rand() % 11;

        int number = rand() % 150 + 1;

        arrayB[position] = number;

        printf("[Secondo] - Ho scritto il numero %d in posizione %d\n",number,position);

        pthread_cond_signal(&cond);
        pthread_mutex_unlock(&mutex);

        sleep(1);
    }
}

//metodo eseguito dal terzo thread
void terzoThread(){

    pthread_mutex_lock(&mutex);

    //in questo while devo aspettare che entrambi gli array siano stati inizializzati
    //quindi controllo se la funzione checkArray restituisce 0 per entrambi gli array
    while(checkArray(arrayA) == 0 || checkArray(arrayB) == 0){

        //se mi trovo qui dentro significa che almeno uno dei due array non è stato inizializzato
        printf("[Terzo] - Aspetto...\n");
        printArray(arrayA);
        printArray(arrayB);

        //aspetto che qualcuno mi invii un segnale per sbloccarmi e ricontrollare se gli array sono stati inizializzati
        pthread_cond_wait(&cond,&mutex);
    }

    //se mi trovo qui dentro significa che entrambi gli array sono stati inizializzati

    printf("[Terzo] - Trovo il massimo\n");

    //Stampo gli array
    printArray(arrayA);
    printArray(arrayB);

    //trovo il massimo e il minimo in A e B
    int maxA,minA,maxB,minB;

    //inzializzo maxA e maxB al primo valore dell'array
    maxA = arrayA[0];
    maxB = arrayB[0];

    //inizializzo minA e minB al primo valore dell'array
    minA = arrayA[0];
    minB = arrayB[0];

    //questa funzione trova il massimo e il minimo in A e B
    //scorro il buffer e confronto ogni elemento con il massimo e il minimo attuale
    for(int i = 1; i < BUFFER_SIZE;i++){

        //se l'elemento i-esimo è maggiore del massimo attuale allora lo sostituisco
        if(arrayA[i] > maxA){
            maxA = arrayA[i];
        }

        //stessa cosa per il massimo di B
        if(arrayB[i] > maxB){
            maxB = arrayB[i];
        }  
    
        //stessa cosa per il minimo A
        if(arrayA[i] < minA){
            minA = arrayA[i];
        }

        //stessa cosa per il minimo di B
        if(arrayB[i] < minB){
            minB = arrayB[i];
        }
    }

    printf("[Terzo] - Il massimo in A e: %d\n",maxA);
    printf("[Terzo] - Il minimo in A e: %d\n",minA);
    printf("[Terzo] - Il massimo in B e: %d\n",maxB);
    printf("[Terzo] - Il minimo in B e: %d\n",minB);

    //trovo il massimo e il minimo tra i due array
    int maxTotal,minTotal;

    //confronto i massimi e i minimi trovando il il massimo tra maxA e maxB e il minimo tra minA e minB
    if(maxA > maxB){
        maxTotal = maxA;
        printf("Il valore totale massimo e: %d\n",maxTotal);
    }else if(maxA < maxB){
        maxTotal = maxB;
        printf("Il valore totale massimo e: %d\n",maxTotal);
    }else{

        //caso in cui sono uguali
       printf("I massimi sono uguali\n");
    }

    if(minA < minB){
        minTotal = minA;
        printf("Il valore totale minimo e: %d\n",minTotal);
    }else if(minB < minA){
        minTotal = minB;
        printf("Il valore totale minimo e: %d\n",minTotal);
    }else{

        //caso in cui sono uguali
       printf("I minimi sono uguali\n");
    }

    //rilascio il mutex
    pthread_mutex_unlock(&mutex);

    //termino il thread
   exit(0);
}

int main(){

    srand(time(NULL));

    pthread_t t1,t2,t3;

    pthread_create(&t1,NULL,primoThread,NULL);
    pthread_create(&t2,NULL,secondoThread,NULL);
    pthread_create(&t3,NULL,terzoThread,NULL);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);
    pthread_join(t3,NULL);

    return 0;
}

