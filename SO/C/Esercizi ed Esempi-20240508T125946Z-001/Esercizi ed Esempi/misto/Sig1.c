#include <signal.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/type.h>
void gestore (int signum){
	static int cont = 0;
	printf("Processo con pid %d; ricevuti n.%d segnali %d \n", getpid(), ++cont, signum);
}
int main(){
	pid_t pid;
	signal(SIGUSR1, gestore);
	pid = fork();
	if(pid==0) //processo figlio
		for (; ;) pause();
	else //processo padre
		for( ; ;){
			kill(pid, SIGUSR1);
			sleep(1);
		}
} 
