//Si richiede di implementare un programma in linguaggio C che utilizzi il metodo delle fork per la comunicazione tra processi.
//Il programma dovrà creare un file di testo e poi creare due processi figli. 
//Uno dei processi figli dovrà scrivere una sequenza di N numeri interi pari da 0 a 9 nel file
//mentre l'altro processo figlio dovrà scrivere una sequenza di N numeri interi dispari da 0 a 9, 
//attraverso la funzione seek va a scriverli subito dopo la sequenza degli N numeri pari nello stesso file.
//Il processo padre dovrà leggere i dati dal file e stamparli a video. 

//Librerie
#include <sys/types.h> 
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <time.h>

//definizione della costante READ con il valore 0
//definizione della costante WRITE con il valore 1
//le pipe sono array di interi di dimensione 2 e per leggere e scrivere si deve indicare quale canale (quale slot dell'array) si vuole utilizzare
//lo slot 0 della pipe viene utilizzato per leggere, quindi PIPE[READ] sarebbe PIPE[0]
//lo slot 1 della pipe viene utilizzato per scrivere, quindi PIPE[WRITE] sarebbe PIPE[1]
#define READ 0
#define WRITE 1

//costante per il nome del file
#define fileName "inputNumbers.txt"

int main(){

    //questa istruzione va messa all'inizio del main ogni volta che si vuole utilizzare la funzione random
    //serve ad inizializzare la funzione casuale
    srand(time(NULL));

    //creo 2 figli istanziando 2 variabili di tipo pid_t
    pid_t p1,p2;

    //utilizzerò queste pipe per inviare un segnale di OK in modo tale che gli altri processi possano partire
    int pipeFiglio[2], pipePadre[2];

    //creo le pipe
    pipe(pipeFiglio);
    pipe(pipePadre);

    //creo il file
    printf("[Padre] - Creo il file\n");

    //creo il file passando come parametro il nome del file e i permessi di scrittura
    //0700 indica che il file è visibile solo al proprietario e che può essere scritto e letto
    int fd = creat(fileName, 0700); //fd è un intero che conterrà il file descriptor ovvero l'identificativo del file
    close(fd);
    printf("[Padre] - Ho creato e chiuso il file\n");


    //creo il primo figlio
    p1 = fork();
    if(p1 < 0){
        printf("Errore nella creazione della prima fork!\n");
    }

    if(p1 == 0){

        //codice primo figlio

        //chiudo la pipe in lettura
        close(pipeFiglio[READ]);

        //apro il file in scrittura
        //O_WRONLY indica che il file verrà aperto in scrittura
        int fd1 = open(fileName,O_WRONLY);
        printf("[Primo figlio] - Apro il file in scrittura\n");

        //controllo se l'apertura del file è andata a buon fine
        if(fd1 < 0){
            printf("[Primo figlio] - Errore nell'apertura del file in scrittura\n");
        }

        int counter = 0; //contatore per i numeri scritti
        int charCounter = 0; //contatore per i caratteri scritti
        while(counter < 9){

            int number = rand() % 10; //genero un numero da 0 a 9 

            if((number % 2) == 0){
                
                //numero pari quindi lo scrivo nel file

                char buffer[20];  // Usiamo un buffer di dimensione sufficiente per contenere la rappresentazione del numero come stringa
                int length = sprintf(buffer, "%d", number); // Converto il numero in stringa e memorizzo la lunghezza della stringa

                //scrivo il numero nel file (il numero è contenuto nel buffer e la lunghezza è length)
                write(fd1,&buffer,length);

                //incremento il contatore dei numeri scritti
                counter++;
                printf("[Primo figlio] - Ho scritto il numero %d nel file\n",number);
                
                

                //conto quanti caratteri ho scritto
                if(number < 10){

                    //ovviamente se il numero è minore di 10 avrò scritto un solo carattere
                    charCounter++;
                }else{

                    //se il numero è maggiore di 10 avrò scritto 2 caratteri perchè il numero è composto da 2 cifre
                    charCounter += 2;
                }
            }
        }

        printf("[Primo figlio] - Chiudo il file e inivio l'ok al secondo figlio\n");

        //chiudo il file
        close(&fd1);
        
        //mando il numero di caratteri letti al secondo figlio così che possa partire
        write(pipeFiglio[WRITE],&charCounter,sizeof(charCounter));
    }else{

        //codice padre

        //creo il secondo figlio
        p2 = fork();
        if(p2 < 0){
            printf("Errore nella creazione della seconda fork\n");
        }
        if(p2 == 0){
            //codice secondo figlio

            //chiudo la pipe in scrittura, questa pipe serve per ricevere dal primo figlio il numero di caratteri scritti
            close(pipeFiglio[WRITE]);

            //chiudo la pipe in lettura, questa pipe serve per mandare l'ok al padre che significa che ho finito di scrivere e può leggere
            close(pipePadre[READ]);

            //aspetto il numero di caratteri scritti dal primo figlio
            int charWrited;
            read(pipeFiglio[READ],&charWrited,sizeof(charWrited)); //leggo il numero di caratteri scritti dal primo figlio

            //parto
            printf("[Secondo figlio] - Apro il file in scrittura\n");

            //apro il file in scrittura
            int fd2 = open(fileName,O_WRONLY);

            //posizione il cursore dopo i caratteri scritti dal primo figlio
            lseek(fd2,charWrited,SEEK_SET);

            //comincio a scrivere i numeri
            int counter = 0;

            //devo scrivere 9 numeri
            while(counter < 9){
                
                //genero il numero
                int number = rand() % 10;

                if((number % 2) != 0){

                    //numero dispari quindi lo scrivo nel file
                
                    char buffer[20];  // Usiamo un buffer di dimensione sufficiente per contenere la rappresentazione del numero come stringa
                    int length = sprintf(buffer, "%d", number);

                    write(fd2,&buffer,length);
                    counter++;
                    printf("[Secondo figlio] - Ho scritto il numero %d nel file\n",number);
                }
            }

            //chiudo il file e mando l'ok al padre
            printf("[Secondo figlio] - Chiudo il file e mando l'ok al padre\n");
            close(&fd2);

            //l'ok sarebbe un intero con valore 1 che quando viene ricevuto dal padre significa che il secondo figlio ha finito di scrivere e il padre può leggere
            int ok = 1;
            write(pipePadre[WRITE],&ok,sizeof(int));

        }else{

            //codice padre

            //chiudo la pipe in scrittura visto che devo leggere l'ok
            close(pipePadre[WRITE]);

            printf("[Padre] - Leggo l'ok dal secondo processo figlio\n\n");

            //quando verrà ricevuto l'ok significa che il secondo figlio ha finito di scrivere e il padre può leggere
            int ok;
            read(pipePadre[READ],&ok,sizeof(ok));

            //apro e leggo il file
            int fd3 = open(fileName,O_RDONLY);

            //charRead viene utilizzato per leggere i caratteri dal file, viene initializzato a 1 per entrare nel ciclo perchè la funzione read ritorna 0 quando ha finito di leggere
            int charRead = 1;
            while(charRead > 0){

                //leggo un carattere alla volta
                char buffer[1];

                //il terzo parametro della funzione read indica quanti caratteri voglio leggere
                //i caratteri letti verranno memorizzati nel buffer
                charRead = read(fd3,&buffer,1);

                printf("[Padre] - Ho letto il numero %s\n",buffer);
            }

            printf("[Padre] - Ho finito di leggere chiudo il file\n");
            close(fd3);
        }
  
    }

    return 0;
}