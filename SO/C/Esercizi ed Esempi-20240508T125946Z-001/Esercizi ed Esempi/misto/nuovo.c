#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main(int argc, char *argvs[]){

	int i;
	printf("Processo chiamato da execl con PID = %d  e PPID = %d \n", getpid(), getppid());
	for(i = 0; i < argc; i++){
		printf("%s\n",argvs[i] ); //visualizza i parametri d'ingresso	
	}
	printf("\n");
}
