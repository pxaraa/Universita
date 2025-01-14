/*Creare un programma che legge un file e conta le occorenze di una parola nel seguente modo:
• Il primo processo legge dall’inzio alla metà e conta le occorenze della parola.
• Il secondo processo legge dalla metà fino alla fine e conta le occorenze dell parola.
• Inviano poi il numero di occorenze al processo padre, il quale le somma e le stampa a video.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/stat.h>// per vedere dimensione file ecc..
#include <fcntl.h>//serve per O_RDONLY ecc..

#define SIZE 1024
#define MAX_WORD_LEN 100

int main(int argc, char *argv[]){// argc il num di cose che gli passo, argv le cose che gli passo
    int count=0;
    char buffer[SIZE];
    struct stat st;
    
    if(argc!=3){//il comando "./...." per runnare da terminale + il file + la parola
        fprintf(stderr, "Errore di sintassi. Uso: %s File Parola \n ", argv[0]);
        exit(1); //esco per errore di sintassi
    }

    FILE *fp = fopen(argv[1],"r");// in [0] ce "./.." in [1] ce il file
    if (fp< 0) exit(2);  // Se non può aprirlo, esce
    
    if (stat(argv[1], &st) == -1) {
        perror("stat");
        return 1;
    }
    printf("Dimensione file: %ld byte\n", st.st_size);

    char *line=NULL;
    size_t len=0;
    

    while(getline(&line,&len,fp)!= -1){
    
        if(strstr(line,argv[2])){
            count++;

        }

    }
    printf("le occorrenze sono %d",count);


}