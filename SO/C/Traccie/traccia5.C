//Scrivere un programma che esegue la moltiplicazione tra matrici 3x3 usando la programmazione parallela.
//Il primo processo figlio computa la prima colonna.
//Il secondo processo figlio computa la seconda colonna.
//Il processo padre computa la terza colonna e riceve dai figli i due vettori colonna computati e compone la matrice finale e la stampa.
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#define READ 0
#define WRITE 1

int main(){
    int matrice[3][3];
    pid_t p1,p2;
    int pipe1[2],pipe2[2];
    pipe(pipe1);
    pipe(pipe2);
    
    p1=fork();
    if(p1==0){//figlio 1
        srand(getpid());
        int array1[3];
        for (int i;i<3;i++){
            
            int num = rand()% 50;
            array1[i]=num;
            

        }
        close(pipe1[0]);
        write(pipe1[1],array1,(sizeof(int))*3);
        close(pipe1[1]);
    }
    if(p1>0){
        p2=fork();
        
        if(p2==0){//figlio2
        srand(getpid());
            
            int array2[3];
            for (int i;i<3;i++){
                
                int num = rand()% 50;
                array2[i]=num;
                
            }
            close(pipe2[0]);
            write(pipe2[1],array2,(sizeof(int))*3);
            close(pipe2[1]); 
        }
        if(p2>0){//padre
            close(pipe1[1]);
            close(pipe2[1]);
            srand(getpid());
            int arr1_r[3],arr2_r[3];
            
            for(int i=0; i<3;i++){
                matrice[i][2]=rand()% 50;
            }
            read(pipe1[0],arr1_r,(sizeof(int))*3);
            read(pipe2[0],arr2_r,(sizeof(int))*3);

            for (int i=0;i<3;i++){
                matrice[i][0]=arr1_r[i];
                
            }
            for (int i=0 ;i<3;i++){
                matrice[i][1]=arr2_r[i];
                
            }
            for (int i=0;i<3;i++){
                for (int j;j<3;j++){

                    printf("%d ",matrice[i][j]);

                }
                printf("\n");
                
            }
            close(pipe1[0]);
            close(pipe1[1]);
            exit(0);
        
        }


        
    }
    
    
}