#include <stdio.h>
#include <stdlib.h>
/*
sono le librerie che si possono usare per far eseguire il programma!
#include <unistd.h>
#include <sys/types.h>
*/

// CREAZIONE DI UN PROCESSO FIGLIO

int main(void){

	pid_t ret;
	ret = fork();
	/* fork ritorna il pid del figlio al padre, il valore 0 
	al figlio e -1 in caso di errore. In base a questo è possibile
	separare il codice del padre da quello del figlio.
	*/

	if(ret == -1){
		printf("Errore nella fork \n");
		exit(0);
	} else if(ret == 0){
		//codice del figlio
		printf("figlio con pid = %d\n", getpid());
	}else {
		//codice del padre
		printf("figlio con pid = %d \n", getpid());
	}
	//codice eseguito da entrambi i processi, padre e figlio
	printf("Questa istruzione printf è eseguita da pid = %d \n", getpid());

}