//Generare due processi figli che comunicano con il padre.
//Uno dei processi genera numeri casuali [0-100] ed invia al padre solo i numeri pari.
//L’altro processo genera numeri casuali [0-100] ed invia al padre solo i numeri dispari.
//Il padre fa la loro somma e quando la somma > 190, termina l’esecuzione dei figli.

//Librerie
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <time.h>
//ciao luchino sei molto bello
//definizione della costante READ con il valore 0
//definizione della costante WRITE con il valore 1
//le pipe sono array di interi di dimensione 2 e per leggere e scrivere si deve indicare quale canale (quale slot dell'array) si vuole utilizzare
//lo slot 0 della pipe viene utilizzato per leggere, quindi PIPE[READ] sarebbe PIPE[0]
//lo slot 1 della pipe viene utilizzato per scrivere, quindi PIPE[WRITE] sarebbe PIPE[1]
#define READ 0 
#define WRITE 1 

int main(){

    //questa istruzione va messa all'inizio del main ogni volta che si vuole utilizzare la funzione random
    //serve ad inizializzare la funzione casuale
    srand(time(NULL));

    //creo 2 figli istanziando 2 variabili di tipo pid_t
    pid_t child1,child2;

    //istanzio le 2 pipe (ogni pipe è un array di interi)
    int pipe1[2],pipe2[2];

    pipe(pipe1); //creo la pipe 1
    pipe(pipe2); //creo la pipe 2

    //creo il primo figlio
    child1 = fork();

    //controllo in caso di errore, se si genera un errore nella fork() child1 conterrà un valore < 0
    if(child1 < 0){
        printf("Errore nella creazione del primo processo\n");
    }

    //se la funzione fork() va a buon fine conterrà il valore 0 nel figlio 
    if(child1 == 0){
        
        //codice eseguito dal primo figlio

        //utilizzo la pipe per scrivere il numero generato al padre (quindi utilizzerò il canale WRITE)
        //chiudo quindi il canale di lettura READ visto che non lo utilizzerò
        close(pipe1[READ]);

        while(1){ //loop

            //genero il numero da 0 a 100 (scrivo 101 perchè viene esratto fino all'ultimo numero - 1)
            int number = rand() % 101;
            printf("[Primo figlio] - Ho generato il numero: %d\n",number);

            //devo comunicare al padre solo i numeri pari quindi controllo se il numero generato è pari
            if(number % 2 == 0){

                //numero pari quindi:
                //comunico il numero al padre tramite la pipe utilizzando la funzione WRITE
                //la funzione WRITE accetta come parametri:
                //pipe e canale nel quale si vuole scrivere/leggere
                //numero che voglio inviare
                //dimensione del numero sizeof(int)
                write(pipe1[WRITE],&number,sizeof(number));
                printf("[Primo figlio] - Ho scritto il numero: %d nella prima pipe\n",number);
            }
            sleep(1);
            //
        }

    }else{

        //codice padre
    
        //genero il secondo figlio
        child2 = fork();

        //controllo errori
        if(child2 < 0){
            printf("Errore nella creazione del secondo processo\n");
        }

        if(child2 == 0){

            //codice secondo figlio

            //chiudo la pipe in lettura
            close(pipe2[READ]);
            
            while(1){

                //genero il numero
                int number = rand() % 101;
                printf("[Secondo figlio] - Ho generato il numero: %d\n",number);

                //controllo che il numero sia dispari
                if(number % 2 == 1){

                    //comunico il numero al padre
                    write(pipe2[WRITE],&number,sizeof(number));
                    printf("[Secondo figlio] - Ho scritto il numero: %d nella seconda pipe\n",number);
                }

                sleep(1);
            }
        }
        else{

            //codice del padre

            //utilizzerò queste 2 pipe per comunicare con il padre
            //devo LEGGERE i numeri inviati dai figli quindi chiudo i canali di SCRITTURA (che non mi serviranno)
            close(pipe1[WRITE]);
            close(pipe2[WRITE]);

            //creo 3 variabili intere
            //number 1 conterrà il numero ricevuto dal primo figlio
            //number 2 il numero del secondo figlio
            //sum la somma dei 2 numeri ricevuti per controlla se la somma > 190
            int number1,number2,sum;

            while(1){

                //leggo i 2 numeri da entrambi i figli
                read(pipe1[READ],&number1,sizeof(number1)); //leggo il primo numero dal primo figlio e lo metto nella variabile number1
                read(pipe2[READ],&number2,sizeof(number2)); //stessa cosa per il secondo

                //print
                printf("[Padre] - Ho letto %d dalla prima pipe\n",number1);
                printf("[Padre] - Ho letto %d dalla seconda pipe\n",number2);

                //somma dei 2 numeri ricevuti
                sum = number1 + number2;

                //controllo se la somma è > 190
                if(sum > 190){
                    printf("La somma è %d termino i figli\n", sum);

                    //con la funzione KILL invio un segnale ad uno specifico processo, quindi la utilizzo per terminare i processi figli (visto che la somma è > 190)
                    //la funzione kill accetta come primo paramtro il pid del figlio a cui inviare il segnale
                    //come secondo param il segnale da inviare
                    kill(child1,SIGTERM); // invio il segnale SIGTERM al primo figlio specificando il pid del primo figlio nel primo parametro
                    kill(child2,SIGTERM); //uguale per il secondo

                    //esco dal programma
                    exit(1);
                }

            }
        }
    }

    return 0;
}



