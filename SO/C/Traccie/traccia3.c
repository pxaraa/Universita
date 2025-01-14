/*Un processo padre genera due processi figli.
• Il primo processo figlio invia al padre un numero casuale da 0 a 100.
• Il padre legge questo numero, lo moltiplica per un k causale e lo manda al secondo figlio.
• Il secondo figlio legge il numero inviato dal padre e lo stampa a video.*/

#include <stdio.h>//standard di input/output (I/O) come printf e scanf
#include <stdlib.h>//memory allocation, random number generation, and string conversion.
#include <unistd.h>//low-level system operations, such as process management, file operations, and system calls.
#define READ 0
#define WRITE 1

int main(){
    __pid_t p1,p2;
    int pipe1[2];
    int pipe2[2];
    pipe(pipe1);
    pipe(pipe2);
    int num=0;

    p1=fork();
    if (p1==0){//figlio 1
        srand(getpid());
        num=rand()%101;
        close(pipe1[0]);
        write(pipe1[1],&num, sizeof(num));

        exit(0);
    }

    if(p1>0){ //padre
        close(pipe1[1]);
        read(pipe1[0],&num,sizeof(num));
        int k=rand()%11;
        int n=num *k;
        close(pipe2[0]);
        write(pipe2[1],&n,sizeof(n));
        close(pipe2[1]);

        p2=fork();
        if (p2==0){//figlio 2
            close(pipe2[0]);
            read(pipe2[1],&n,sizeof(n));
            printf("il numero di mio padre è: %d\n", n);
            exit(0);
        }
    }
    return 0;
}