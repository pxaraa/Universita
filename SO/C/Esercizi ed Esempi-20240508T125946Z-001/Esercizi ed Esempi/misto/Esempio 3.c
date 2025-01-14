#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#inlcude <fcntl.h>
#include <string.h>
struct Persona{
	int id;
	char cognome[40];
	char nome[20];
	char telè[16];
}persona;
int main(){
	int fd,size,i=0,n;
	size = sizeof(persona);
	fd=open)"./persone.dc",O_CREAT|O_RDWR);
	persona.id=10;
	strcpy(persona.cognome,"Perin");
	strcpy(persona.nome,"Stefania");
	strcpy(persona.tel,"06102030");
	lseek(fd,size*i,SEEK_SET);
	write(fd,&persona,size);
	i++;
	persona.id=11;
	strcpy(persona.cognome,"Rossini");
	strcpy(persona.nome,"Mario");
	strcpy(persona.tel,"338112233");
	lseek(fd,size*i,SEEK_SET);
	write(fd,&persona,size);
	i++;
	persona.id=12;
	strcpy(persona.cognome,"White");
	strcpy(persona.nome,"Roger");
	strcpy(persona.tel,"021112233");
	lseek(fd,size*i,SEEK_SET);
	write(fd,&persona,size);
	close(fd);
	fd=open("./persone.db",O_RDONLY);
	i=1; //mi posizione per la lettura del primo record
	lseek(fd,size*i,SEEK_SET);
	read(fd,&persona,size);
	printf("cognome %s \n",persona,cognome);
	close(fd);
}