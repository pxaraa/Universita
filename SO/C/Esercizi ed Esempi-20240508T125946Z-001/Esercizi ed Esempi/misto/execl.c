#include <stdio.h>
#include <stdlib.h>

/*
#include <unistd.h>
#include <sys/types.h>
*/

/* Sostituzione dell'immagine del processo(codice, stack, dati)
   il numero di processi non cambia ma il codice del processo
   chiamante la exec è sostituito.
   Non ritorna nulla
*/
int main(void){

	pid_t ret;
	int stato;
	ret = fork();
	printf("pid = %d\n", getpid() );

	if(ret == 0){
		//figlio
		execl("./nuovo", "saluti", "dal processo", "padre", (char*)0);
		printf("exec fallita\n"); 
		exit(1);
		/* le istruzioni che seguono la chiamata ad execl, verranno eseguite 
		solo se non sono state sovrascritte dal nuovo 
		programma, cioè solo se si è verificato un errore durante
		l'esecuzione, e il controllo è stato ripassato al chiamante (execl).
		printf e exit eseguite solo in caso di errore
		*/
	} else if( ret > 0){
		printf("sono il padre con pid = %d\n",getpid() );
		ret = wait(&stato); //il processo padre la chiama e passa allo stato di bloccato		
	} else{
		printf("Errore fork\n");
	}

}