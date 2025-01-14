#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <string.h>


//	PROCESSO PRODUTTORE

int main(void){

	const int SIZE = 4096; //dimensione del segmento condiviso
	const char *nome = "/MEMCOND"; //nome del segmento

	void *shm_ptr; // puntatore al segmento condiviso

	/* dati scritti in memoria condivisa */
	const char *string_0 = "Saluti";
	const char *string_1 = "a tutti!";
	int shm_fd; //file descriptor

	/* crea il segmento di memoria condivisa */
	shm_fd = shm_open(nome, O_CREAT|RDWR, 0666);
	//in caso di successo shm_open restituisce un numero intero
	//che identifica il descrittore del segmento di memoria condivisa
	ftruncate(shm_fd, SIZE); //ridimensiona il segmento (inizialmente di dim. nulla)

	/* memory map del segmento */
	shm_ptr = mmap(0, SIZE, PROT_WRITE, MAP_SHARED, shm_fd, 0);
	//mmap crea un file mappato in memoria corrispondente al segmento condiviso e
	//restituisce un puntatore al file che è utilizzato per accedere al segmento condiviso
	sprintf(shm_ptr, "%s", string_0); //scrive nel segm.
	shm_ptr += strlen(string_0);
	sprintf(shm_ptr, "%s", string_1);
	shm_ptr += strlen(string_1);
	return 0;

}