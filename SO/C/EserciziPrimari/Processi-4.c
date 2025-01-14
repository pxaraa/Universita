//Scrivere un programma che esegue la moltiplicazione tra matrici 3x3 usando la programmazione parallela.
//Il primo processo figlio computa la prima colonna.
//Il secondo processo figlio computa la seconda colonna.
//Il processo padre computa la terza colonna e riceve dai figli i due vettori colonna computati e compone la matrice finale e la stampa.

//Librerie
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

//definizione della costante READ con il valore 0
//definizione della costante WRITE con il valore 1
//le pipe sono array di interi di dimensione 2 e per leggere e scrivere si deve indicare quale canale (quale slot dell'array) si vuole utilizzare
//lo slot 0 della pipe viene utilizzato per leggere, quindi PIPE[READ] sarebbe PIPE[0]
//lo slot 1 della pipe viene utilizzato per scrivere, quindi PIPE[WRITE] sarebbe PIPE[1]
#define READ 0
#define WRITE 1

int main(){

    //questa istruzione va messa all'inizio del main ogni volta che si vuole utilizzare la funzione random
    srand(time(NULL));

    //creo 2 figli istanziando 2 variabili di tipo pid_t
    pid_t primo, secondo;

    //istanzio le 2 pipe (ogni pipe è un array di interi)
    int pipePrima[2], pipeSeconda[2];

    //creo la matrice 3x3
    int matrice[3][3];

    //creo le pipe
    pipe(pipePrima);
    pipe(pipeSeconda);

    //creo il primo figlio
    primo = fork();

    //controllo in caso di errore, se si genera un errore nella fork() primo conterrà un valore < 0
    if(primo < 0){
        printf("Errore nella creazione del primo figlio\n");
    }

    if(primo == 0){

        //codice eseguito dal primo figlio

        //utilizzo la pipe per scrivere il numero generato al padre (quindi utilizzerò il canale WRITE)
        //chiudo quindi il canale di lettura READ visto che non lo utilizzerò
        close(pipePrima[READ]);


        //creo un array di 3 elementi dove memorizzare i numeri generati
        int array[3];

        //ciclo per generare 3 numeri casuali e memorizzarli nell'array
        for(int i = 0; i < 3; i++){
            array[i] = rand() % 100;
            printf("[Primo] - Ho generato il numero %d\n",array[i]);
        }

        //invio l'array contenente i numeri generati al padre
        //sizeof(int)*3 rappresenta la dimensione dell'array (siccome l'array è di 3 elementi e ogni elemento è di tipo int, la dimensione sarà 3*sizeof(int))
        write(pipePrima[WRITE],&array,(sizeof(int))*3);
    }else{

        secondo = fork();
        if(secondo < 0){
            printf("Errore nella creazione del secondo figlio\n");
        }

        if(secondo == 0){

            //codice eseguito dal secondo figlio

            //utilizzo la pipe per scrivere il numero generato al padre (quindi utilizzerò il canale WRITE)
            //chiudo quindi il canale di lettura READ visto che non lo utilizzerò
            close(pipeSeconda[READ]);


            //creo un array di 3 elementi dove memorizzare i numeri generati
            int array[3];
            for(int i = 0; i < 3; i++){
                array[i] = rand() % 100;
                printf("[Secondo] - Ho generato il numero %d\n",array[i]);
            }

            //invio l'array contenente i numeri generati al padre
            write(pipeSeconda[WRITE],&array,(sizeof(int))*3);
        }else{

            //codice eseguito dal padre

            //chiudo i canali di scrittura delle pipe visto che non li utilizzerò (devo solo leggere i numeri generati dai figli)
            close(pipePrima[WRITE]);
            close(pipeSeconda[WRITE]);

            //il padre deve computare la terza colonna quindi genero 3 numeri casuali e li memorizzo nella terza colonna della matrice
            for(int i = 0; i < 3; i++){
                matrice[i][2] = rand() % 100;
                printf("[Padre] - Ho generato il numero %d\n",matrice[i][2]);
            }

            //adesso devo leggere i numeri generati dai figli e memorizzarli nelle prime 2 colonne della matrice
            //i figli inviano i numeri generati attraverso le pipe
            //i numeri inviati dai figli sono degli array di 3 elementi quindi devo leggere 2 array di 3 elementi (uno per ogni figlio)
            int primoArrayRicevuto[3],secondoArrayRicevuto[3];

            //leggo gli array inviati dai figli
            read(pipePrima[READ],&primoArrayRicevuto,(sizeof(int)*3));
            read(pipeSeconda[READ],&secondoArrayRicevuto,(sizeof(int)*3));

            //copio i numeri presenti nel primo array ricevuto nella prima colonna della matrice (questo array è stato inviato dal primo figlio)
            for(int i = 0; i < 3; i++){ 
                matrice[i][0] = primoArrayRicevuto[i];
            }

            //copio i numeri presenti nel secondo array ricevuto nella seconda colonna della matrice (questo array è stato inviato dal secondo figlio)
            for(int i = 0; i < 3; i++){
                matrice[i][1] = secondoArrayRicevuto[i];
            }

            //stampo la matrice
            printf("Stampo la matrice\n");
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    printf("%d ",matrice[i][j]);
                }
                printf("\n");
            }
        }
    }

    return 0;
}