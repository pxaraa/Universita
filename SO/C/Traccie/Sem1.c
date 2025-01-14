/*Due thread, il produttore inserisce numeri pari da 0 a 100 in posizioni 
pari, e numeri dispari da 100 a 200 in posizioni dispari all’interno di 
un buffer di N elementi, iniziliazzato a -1, il consumatore legge dal buffer un
numero pari e un numero dispari, li somma e stampa la loro somma.*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define N 10

sem_t mutex;
sem_t empty;
sem_t full;
int buffer[N]={-1};

void insert_num(){
    for(int i=0;i<N;i++){
        srand(getpid());
        int num=0;
        if (buffer[i]%2==0){
            num= rand()%101;
            if(num%2==0){
                buffer[i]=num;
            }
        }
        else {
            buffer[i]=num;
            }  
    }
}

void print_buffer(){
    for(int i=0; i<N; i++){
        printf("%d",buffer[i]);
    }

}


void *producer (void*arg){
    while(1){
        sem_wait(&empty);
        sem_wait(&mutex);
        instert_num();
        sem_post(&mutex);
        sem_post(&full);
    }
}

void *consumer(void *arg){
    while(1){
        sem_wait(&full);
        sem_wait(&mutex);
        print_buffer();
        sem_post(&mutex);
        sem_post(&empty);
    }
}
int main(){
    pthread_t prod, cons;

    sem_init(&mutex,0,1);
    sem_init(&empty,0,N);
    sem_init(&mutex,0,0);

    pthread_create(&prod,NULL,*producer,NULL);
    pthread_create(&prod,NULL,*consumer,NULL);
}
