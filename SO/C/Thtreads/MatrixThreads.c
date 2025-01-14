#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#define n 50
#define m 50
 
int mat[n][m];
int somma=0;
int r=0;
 
void *ThreadSommaRiga(void *arg){
	int myr=r++;
	int c;
	for(c=0;c<m;c++){
			somma=somma+mat[myr][c];
		}
	pthread_exit(0);
	}
 
 
int main(int argc, char **argv)
{
	pthread_t tid[n];
	int i,j;
 
	srand(time(0));
 
	for(j=0;j<n;j++){
		for(i=0;i<n;i++){
			mat[i][j]=1+rand()%200; //per avere i numeri random bisogna iniazzializzare srand(time(0));
		}
	}
 
	for(i=0;i<n;i++){
		pthread_create(&tid[i],NULL,ThreadSommaRiga,NULL);
		}
 
	for(i=0;i<n;i++){
		pthread_join(tid[i],NULL);
		}
 
	printf("La somma della matrice è %d\n",somma);
 
	return 0;
}