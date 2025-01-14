/*Creare un processo padre e due processi figlio. Il processo padre crea i due processi figlio e poi attende che entrambi terminino. 
I processi figlio stampano un messaggio a video ciascuno e poi terminano.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main() {
  pid_t pid1, pid2;

  // Creare il primo processo figlio
  pid1 = fork();
  if (pid1 < 0) {
    perror("Errore nella creazione del processo figlio 1");
    exit(1);
  }

  if (pid1 == 0) { // Primo processo figlio
    printf("Processo figlio 1: Ciao!\n");
    exit(0);
  }

  // Creare il secondo processo figlio
  pid2 = fork();
  if (pid2 < 0) {
    perror("Errore nella creazione del processo figlio 2");
    exit(1);
  }

  if (pid2 == 0) { // Secondo processo figlio
    printf("Processo figlio 2: Ciao!\n");
    exit(0);
  }

  // Attendere la terminazione dei processi figlio
  waitpid(pid1, NULL, 0);
  waitpid(pid2, NULL, 0);

  printf("Processo padre: I processi figlio sono terminati.\n");

  return 0;
}
