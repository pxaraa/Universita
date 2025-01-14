//Un processo padre genera due processi figli.
//Il primo processo figlio invia al padre un numero casuale da 0 a 100.
//Il padre legge questo numero, lo moltiplica per un k causale e lo manda al secondo figlio.
//Il secondo figlio legge il numero inviato dal padre e lo stampa a video.

//Librerie
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
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

    //creo 2 figli istanziando 2 variabili di tipo pid_t
    pid_t primoF,secondoF;

    //questa istruzione va messa all'inizio del main ogni volta che si vuole utilizzare la funzione random
    srand(time(NULL));

    //istanzio le 2 pipe (ogni pipe è un array di interi)
    //la prima pipe verrà utilizzata per comunicare dal primo figlio al padre il numero generato
    //la seconda pipe verrà utilizzata per comunicare dal padre al secondo figlio il numero generato dal primo figlio moltiplicato per un numero casuale (k)
    int pipePrimo[2],pipeSeconda[2];

    //creo le pipe
    pipe(pipePrimo);
    pipe(pipeSeconda);

    primoF = fork(); //creo il primo figlio

    //controllo in caso di errore, se si genera un errore nella fork() child1 conterrà un valore < 0
    if(primoF < 0){
        printf("Errore nella creazione del primo figlio\n");
    }

    //se la funzione fork() va a buon fine conterrà il valore 0 nel figlio 
    if(primoF == 0){


        //codice primo figlio

        //chiudo il canale di lettura
        close(pipePrimo[READ]);

        while(1){

            //genero il numero randomico
            int number = rand() % 100;

            //comunico il numero al padre tramite la pipe utilizzando la funzione WRITE
            //la funzione WRITE accetta come parametri:
            //pipe e canale nel quale si vuole scrivere/leggere
            //numero che voglio inviare
            //dimensione del numero sizeof(int)
            write(pipePrimo[WRITE],&number,sizeof(number));

            printf("[Primo] - Ho inviato il numero %d\n", number);

            sleep(1);
        }

        
    }else{

        //codice del padre

        //genero il secondo figlio
        secondoF = fork();

        //controllo errori
        if(secondoF < 0){
            printf("Errore nella creazione del secondo figlio\n");
        }

        if(secondoF == 0){

            //codice secondo figlio

            //chiudo il canale di scrittura visto che non lo utilizzerò ma dovrò leggere
            close(pipeSeconda[WRITE]);

            //loop
            while(1){
                
                //variabile intera in cui salverò il numero ricevuto dal padre
                int numberReceivedFromFather;
                
                //leggo il numero inviato dal padre utilizzando la funzione READ
                //la funzione READ accetta come parametri:
                //pipe e canale nel quale si vuole scrivere/leggere
                //dove salvare il numero letto
                //dimensione del numero sizeof(int)
                read(pipeSeconda[READ],&numberReceivedFromFather,sizeof(int));

                printf("[Secondo] - Ho ricevuto il numero %d\n",numberReceivedFromFather);

                sleep(1);
            }
        }else{

            //codice del padre

            //chiudo il canale di scrittura della prima pipe e il canale di lettura della seconda pipe
            //chiudo il canale di scrittura della prima pip perchè dovrò solo leggere il numero inviato dal primo figlio
            //chiudo il canale di lettura della seconda pipe perchè dovrò solo scrivere il numero da inviare al secondo figlio
            close(pipePrimo[WRITE]);
            close(pipeSeconda[READ]);

            while(1){
                
                //variabile intera in cui salverò il numero ricevuto dal primo figlio
                int numberReceived;

                //leggo il numero inviato dal primo figlio utilizzando la funzione READ
                read(pipePrimo[READ],&numberReceived,sizeof(int));

                //genero un numero casuale da 0 a 10 per il quale moltiplicherò il numero ricevuto
                int k = rand() % 10;

                //moltiplico il numero ricevuto per k
                int newNumber = k*numberReceived;

                //comunico il numero al secondo figlio tramite la pipe utilizzando la funzione WRITE
                write(pipeSeconda[WRITE],&newNumber,sizeof(newNumber));

                printf("[Padre] - Numero ricevuto: %d - K generato: %d  - Nuovo numero: %d\n",numberReceived,k,newNumber);

                sleep(1);
            }
        }

    }



    return 0;
}