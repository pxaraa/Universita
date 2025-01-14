#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <fcntl.h>
#define PAROLA_DA_CERCARE "parola_da_cercare" // Sostituisci con la parola da cercare

int main() {
  int pipe1[2]; // Pipe per la comunicazione dal processo padre al processo figlio 1
  int pipe2[2]; // Pipe per la comunicazione dal processo padre al processo figlio 2
  pid_t pid1, pid2; // ID dei processi figli
  int occorrenze_figlio1, occorrenze_figlio2; // Variabili per memorizzare le occorrenze di ciascun figlio
  int occorrenze_totali; // Variabile per memorizzare le occorrenze totali

  // Crea le pipe
  if (pipe(pipe1) == -1 || pipe(pipe2) == -1) {
    perror("pipe");
    exit(1);
  }

  // Crea il processo figlio 1
  pid1 = fork();
  if (pid1 == -1) {
    perror("fork");
    exit(1);
  }

  // Processo padre
  if (pid1 > 0) {
    // Crea il processo figlio 2
    pid2 = fork();
    if (pid2 == -1) {
      perror("fork");
      exit(1);
    }

    // Aspetta i figli e ottieni i loro risultati
    waitpid(pid1, NULL, 0);
    read(pipe1[0], &occorrenze_figlio1, sizeof(int));
    waitpid(pid2, NULL, 0);
    read(pipe2[0], &occorrenze_figlio2, sizeof(int));

    // Calcola le occorrenze totali e stampa il risultato
    occorrenze_totali = occorrenze_figlio1 + occorrenze_figlio2;
    printf("Numero totale di occorrenze di '%s': %d\n", PAROLA_DA_CERCARE, occorrenze_totali);
  }

  // Processo figlio 1 (legge prima metà del file)
  else if (pid1 == 0) {
    int mio_file;
    char riga_file[1024];
    int conta_parole = 0;

    // Apre il file in lettura
    mio_file = open("mio_file.txt", O_RDONLY);
    if (mio_file == -1) {
      perror("open");
      exit(1);
    }

    // Legge la prima metà del file e conta le occorrenze della parola
    while (fgets(riga_file, sizeof(riga_file), mio_file) != NULL) {
      if (strstr(riga_file, PAROLA_DA_CERCARE) != NULL) {
        conta_parole++;
      }
    }

    // Invia il numero di occorrenze al processo padre
    close(pipe1[1]); // Chiude il lato di scrittura della pipe 1
    write(pipe1[0], &conta_parole, sizeof(int)); // Invia le occorrenze al padre
    close(pipe1[0]); // Chiude il lato di lettura della pipe 1
    close(mio_file); // Chiude il file
    exit(0);
  }

  // Processo figlio 2 (legge seconda metà del file)
  else if (pid2 == 0) {
    int mio_file;
    char riga_file[1024];
    int conta_parole = 0;
    off_t metà_file;

    // Apre il file in lettura
    mio_file = open("mio_file.txt", O_RDONLY);
    if (mio_file == -1) {
      perror("open");
      exit(1);
    }

    // Ottiene la dimensione del file e posiziona il puntatore a metà file
    metà_file = lseek(mio_file, 0, SEEK_END);
    metà_file /= 2;
   lseek(mio_file, metà_file, SEEK);
  }
}