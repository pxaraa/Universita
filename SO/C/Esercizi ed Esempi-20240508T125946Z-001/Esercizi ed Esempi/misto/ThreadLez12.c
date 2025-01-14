#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define FINE (-1)
#define MAX 20
#define DIM 10

typedef struct {
	pthread_mutex_t M;
	pthread_cond_t PIENO;
	pthread_cond_t VUOTO;
	int messaggio [DIM];
	int leggi , scrivi;
	int cont;
}buffer_t;

buffer_t buf;
//firma funzioni
void init(buffer_t *buf);
void produci( buffer_t *buf, int mes);
int consuma(buffer_t *buf);
//definizioni funzioni
void init(buffer_t *buf){
	pthread_mutex_init(&buf->M,NULL);
	pthread_cond_init(&buf->PIENO, NULL);
	pthread_cond_init(&buf->VUOTO, NULL);
	buf->cont = 0;
	buf->leggi = 0;
	buf->scrivi = 0;
}
void produci(buffer_t *buf, int mes){
	//entro nella sezione critica e blocco, grazie al SO, gli interrupt 
	pthread_mutex_lock(&buf->M);
	if(buf->cont==DIM) //mi chiedo se il buffer è pieno
		pthread_cond_wait(&buf->PIENO, &buf->M);
	//Scriviamo il messaggio e aggiorniamo lo stato del messaggio
	buf->messaggio[buf->scrivi]= mes;
	buf->cont++;
	buf->scrivi++;
	// dato che la gestone del buffer è circolare allora dobbiamo mettere delle condizioni 
	// specifiche per far si che sia rispettata
	if(buf->scrivi==DIM)
		buf->scrivi=0;
	//risvegliamo un thread consumatore sospeso se ci sono nella coda
	pthread_cond_signal(&buf->VUOTO);
	pthread_mutex_unlock(&buf->M);
	// ormai ho finito di operare nella sezione critica e faccio l'unlock del mutex.
}
int consuma(buffer_t *buf){
	int mes;
	pthread_mutex_lock(&buf->M);
	if(buf->cont==0)//mi chiedo se il buffer è vuoto
		pthread_cond_wait(&buf->VUOTO, &buf->M);
	//vado a leggere il messaggio e aggiorno lo stato del buffer
	mes = buf->messaggio[buf->leggi];
	buf->cont--;
	buf->leggi++;
	//tengo sempre conto del fatto della gestione circolare
	if(buf->leggi>=DIM)
		buf->leggi=0;
	//risveglio thread produttori sospesi se ci sono nella coda
	pthread_cond_signal(&buf->PIENO);
	pthread_mutex_unlock(&buf->M);
	return mes;
}
void *produttore(void *arg){
	int n;
	for(n=0; n<MAX; n++){
		printf("produttore %d -> %d \n",(int)arg,n);
		produci(&buf,n);
		sleep(1);
	}
	produci(&buf, FINE);
}
void *consumatore(void *arg){
	int d;
	while(1){
		d=consuma(&buf);
		if(d==FINE)
			break;
		printf("		%d <- consumatore %d\n",d,(int)arg);
		sleep(2);
	}
}
int main(){
	int i;
	int nprod=1, ncons=1;
	pthread_t prod[nprod], cons[ncons];
	init(&buf);
	//creiamo i thread
	for(i=0; i<nprod; i++)
		pthread_create(&prod[i], NULL, produttore, (void*)i);
	for(i=0; i<ncons; i++)
		pthread_create(&cons[i], NULL, consumatore, (void*)i);
	//i thread hanno fatto il loro lavoro, adesso possiamo attendere che finiscano 
	//il loro flusso di esecuzione
	for(i=0; i<nprod; i++)
		pthread_join(prod[i], NULL);
	for(i=0; i<ncons; i++)
		pthread_join(cons[i], NULL);
	return 0;
}

















