#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <string.h>


//	PROCESSO CONSUMATORE

int main(void){

	const int SIZE = 4096; //dimensione del segmento condiviso
	const char *nome = "/MEMCOND"; //nome del segmento
	int shm_fd; //file descriptor
	void *shm_ptr; // puntatore al segmento condiviso

	/* accesso al segmento in lettura */
	shm_fd = shm_open(nome, O_RDONLY, 0666);

	/* memory map del segmento */
	shm_ptr = mmap(0, SIZE, PROT_READM, MAP_SHARED, shm_fd, 0);

	/*lettura dal segmento di memoria condivisa */
	printf("%s\n",(char*) shm_ptr );

	/* rimozione del segmento di memoria condivisa */
	shm_unlink(nome);
	return 0;

}