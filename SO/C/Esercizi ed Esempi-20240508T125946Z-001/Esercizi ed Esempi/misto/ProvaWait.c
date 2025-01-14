#include <stdio.h>
#include <stdlib.h>

/*
#include <sys/types.h>
#include <unistd.h>
*/


/* La variabile stato contiene lo stato del processo figlio quanto termina
   Più precisamente, nel caso di terminazione volontaria, la variabile stato 
   conterrà nel suo byte più significativo il valore che il processo figlio
   ha passato al parametro stato chiamando exit(), mentre nel byte meno significativo
   conterrà il numero del segnale che ha causato la terminazione forzata
*/

int main(void){

	pid_t ret, pid;
	int stato;
	ret = fork();

	if(ret == 0) {
		//codice del figlio
		printf("sono il figlio pid: %d\n", getpid() );
		sleep(10); //sospensione 10 secondi
		exit(2); //valore che il padre leggerà in stato
	} else if(ret > 0){
		//codice del padre
		pid = wait(&stato);
		printf("processo figlio pid: %d terminato\n",pid );
		if(stato < 256)
			printf("terminazione forzata: segnale numero = %d\n",stato );
		else 
			printf("terminazione volontaria stato: %d\n",stato >>8 ); //shift verso destra di 8 posizioni
	}else{
		printf("fork fallita\n");
	}
}