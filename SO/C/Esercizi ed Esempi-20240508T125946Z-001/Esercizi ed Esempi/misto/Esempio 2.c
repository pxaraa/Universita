#include <stdio.h>
#include <stdlib.h>
#inlcude <fcntl.h>
#define N 10
int main(){
	int i, fd1, fd2, pid;
	fd1=open("pub.txt",O_CREAT|O_WRONLY,0777);
	pid=fork);
	if(pid==0){
		fd2=open("priv.txt",O_CREAT|O_WRONLY,0777);
		for(i=0;i<N;i++){
			write(fd1,"figlio",6);
			usleep(100);
			write(fd2,"figlio",6);
		}
		close(fd2);
	}
	else if(pid>0){
		for(i=0;i<N,i++){
			write(fd1,"padre",5);
			usleep(100);
		}
		close(fd1);
		}
	}