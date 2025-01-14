//Due processi leggono dallo stesso file che si trova all'interno di una directory, (es. directory/input.txt).
//Il primo processo legge dall'inizio del file fino a metà, 
//Il secondo legge dalla metà in poi. 
//I figli mandano il contenuto al padre
//Il padre lo stampa nel seguente formato: [PID_FIGLIO] -> TESTO

//Librerie
#include <stdio.h>
#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>
#include <sys/types.h>
#include <fcntl.h>


#define filePath "directory/input.txt" //definisco la costante filePath con il valore directory/input.txt che rappresenta il percorso del file da leggere

//definizione della costante READ con il valore 0
//definizione della costante WRITE con il valore 1
#define READ 0 
#define WRITE 1

int main(){

    //creo 2 figli istanziando 2 variabili di tipo pid_t
    pid_t p1,p2;

    //istanzio le 2 pipe (ogni pipe è un array di interi)
    int pipe1[2],pipe2[2];

    //creo le pipe
    pipe(pipe1);
    pipe(pipe2);

    //struttura per ottenere le informazioni del file
    struct stat fileInfo;

    //ottengo le informazioni del file passando il percorso del file e la struttura creata prima
    stat(filePath,&fileInfo);
    
    //creo una variabile di tipo off_t (intero a 64 bit) per memorizzare la dimensione del file
    off_t dimensione = fileInfo.st_size;

    //calcolo la metà della dimensione del file creando una variabile di tipo off_t e assegnandogli la dimensione del file diviso 2
    off_t meta = dimensione / 2;

    //creo il primo figlio
    p1 = fork();

    //controllo in caso di errore, se si genera un errore nella fork() child1 conterrà un valore < 0
    if(p1 < 0){
        printf("Errore nella fork 1!\n");
    }

    if(p1 == 0){

        //codice primo figlio

        //creo una variabile di tipo int per memorizzare il file descriptor del file che sto per aprire
        //apro il file in sola lettura specificando il percorso del file come primo parametro e la costante O_RDONLY come secondo parametro (O_RDONLY indica che il file verrà aperto in sola lettura)
        //nella variabile fd1 memorizzo il file descriptor del file aperto (sarebbe un identificatore univoco del file aperto, in pratica un numero intero che identifica il file aperto all'interno del sistema operativo)
        int fd1 = open(filePath,O_RDONLY);

        //creo un buffer di caratteri dove memorizzerò i caratteri letti nella prima metà del file dal primo figlio
        //siccome il primo figlio legge la prima metà del file, il buffer avrà dimensione META
        char buffer1[meta];

        //lettura della prima meta del file
        //rdCount conterrà il numero di caratteri letti
        //leggo attraverso la funzione read() specificando come primo parametro il file descriptor del file aperto, come secondo parametro il buffer dove memorizzare i caratteri letti e come terzo parametro la dimensione del buffer
        int rdCount;
        rdCount = read(fd1,buffer1,meta);

        //controllo errori di lettura
        if(rdCount <= 0){
            printf("[Primo processo] - Errore nella lettura del file\n");
        }else{

            //se la lettura è andata a buon fine stampo il numero di caratteri letti
            printf("[Primo processo] - Ho letto %d caratteri\n",rdCount);
        }

        //invio i caratteri letti (contenuti nel buffer) al padre
        //chiudo la pipe in lettura visto che dovrò solo scrivere
        close(pipe1[READ]);

        //ottengo il pid del primo figlio
        int pid = getpid();

        //invio il pid al padre attraverso la pipe
        write(pipe1[WRITE],&pid,sizeof(pid));

        //invio il buffer contenente i caratteri letti al padre attraverso la pipe
        write(pipe1[WRITE],&buffer1,meta);

        printf("[Primo processo] - Ho scritto nella pipe verso il padre\n");


    }else{

        //codice padre

        //creo il secondo figlio
        p2 = fork();

        //controllo errori
        if(p2 < 0){
            printf("Errore nella fork 2\n");
        }

        if(p2 == 0){

            //codice secondo figlio

            //apro il file in sola lettura (come nel primo figlio)
            int fd2 = open(filePath,O_RDONLY);

            //buffer per la memorizzazione dei caratteri letti nella seconda meta del file
            char buffer2[meta];

            //lettura della seconda meta del file
            //siccome devo leggere dalla metà in poi posiziono il "cursore" all'esatta metà del file
            //come primo parametro passo il file descriptor del file aperto, 
            //come secondo parametro la posizione in cui posizionare il cursore (meta)
            //come terzo parametro la costante SEEK_SET che indica che il cursore verrà posizionato all'inizio del file
            lseek(fd2,meta,SEEK_SET);
            
            //leggo i caratteri dalla seconda meta del file e li memorizzo nel buffer2
            int rdCount;
            rdCount = read(fd2,buffer2,meta);

            //controllo errori di lettura
            if(rdCount <= 0){
                printf("[Secondo processo] - Errore nella lettura del file\n");
            }else{

                //se la lettura è andata a buon fine stampo il numero di caratteri letti
                printf("[Secondo processo] - Ho letto %d caratteri\n",rdCount);
            }

            //chiudo la pipe in lettura
            close(pipe2[READ]);

            //ottengo il pid del secondo figlio
            int pid = getpid();

            //invio il pid al padre attraverso la pipe
            write(pipe2[WRITE],&pid,sizeof(pid));
            //invio il buffer contenente i caratteri letti al padre attraverso la pipe
            write(pipe2[WRITE],&buffer2,meta);

            printf("[Secondo processo] - Ho scritto nella pipe verso il padre\n");

        }else{

            //codice padre

            //chiudo le pipe in scrittura
            close(pipe1[WRITE]);
            close(pipe2[WRITE]);

            //creo 2 buffer di caratteri per memorizzare i caratteri ricevuti dai figli
            char bufferReceived1[meta],bufferReceived2[meta];

            //creo 2 variabili di tipo intero per memorizzare i pid dei figli
            int pidFiglio1, pidFiglio2;

            //leggo i pid dalle 2 pipe
            read(pipe1[READ],&pidFiglio1,sizeof(int)); //leggo il pid del primo figlio e lo memorizzo nella variabile pidFiglio1
            read(pipe2[READ],&pidFiglio2,sizeof(int)); //stessa cosa per il secondo figlio

            //leggo i caratteri inviati dai figli
            read(pipe1[READ],&bufferReceived1,meta); //leggo i caratteri inviati dal primo figlio e li memorizzo nel buffer bufferReceived1
            read(pipe2[READ],&bufferReceived2,meta); //stessa cosa per il secondo figlio

            //stampo i caratteri ricevuti dai figli
            printf("[Padre] - Il PRIMO figlio (pid %d) mi ha inviato questo testo --> %s\n",pidFiglio1, bufferReceived1);
            printf("[Padre] - Il SECONDO figlio (pid %d) mi ha inviato questo testo --> %s\n",pidFiglio2, bufferReceived2);

        }


    }



    return 0;
}