/*Creare due processi che stampano messaggi a video. Il primo processo stampa "Processo 1: " seguito da un numero incrementale.
 Il secondo processo stampa "Processo 2: " seguito da un numero incrementale. I numeri incrementali devono essere diversi per ogni processo.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sched.h>
#include <sys/wait.h> // Include the necessary header file


int main() {
  pid_t pid1, pid2;

  // Creare il primo processo figlio
  pid1 = fork();
  if (pid1 < 0) {
    perror("Errore nella creazione del processo figlio 1");
    exit(1);
  }

  if (pid1 == 0) { // Primo processo figlio
    int i = 0;
    while (1) {
      printf("Processo 1: %d\n", i++);
      sleep(1);
    }
  }

  // Creare il secondo processo figlio
  pid2 = fork();
  if (pid2 < 0) {
    perror("Errore nella creazione del processo figlio 2");
    exit(1);
  }

  if (pid2 == 0) { // Secondo processo figlio
    int i = 0;
    while (1) {
      printf("Processo 2: %d\n", i++);
      sleep(1);
    }
  }

  // Attendere la terminazione dei processi figlio

  waitpid(pid1, NULL, 0);
  waitpid(pid2, NULL, 0);

  return 0;
}
