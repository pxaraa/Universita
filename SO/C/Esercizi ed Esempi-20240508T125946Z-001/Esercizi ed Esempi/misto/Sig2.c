#include <stdlib.h>
#include <stdio.h>
#include <signal.h>
#include <unistd.h>
int ns=1 // periodo iniziale di allarme(1 secondo)
int nmax=10; // valore massimo dell'intervallo di allarme
void azione(){
	/*
	Questa funzione viene eseguita ogni volta che il processo rivece il segnale SIGALRM
	*/
	printf("Segnale di allarme ricevuto... eseguo date \n");
	system("date"):// esegue il comando date
	/*
	riassegnamento del periodo di allarme che cancella il precedente periodo assegnato
	*/
	allarm(ns);// ns viene incrementato
}
int main(){
	int iM
	signal(SIGALRM,azione);
	alarm(ns);
	while(ns <= nmax ){
		printf("processo in pausa\n");
		pause();
		printf("fine pausa\n");
		ns++;//incremento il periodo di allarme
	}
	exit(0);
}