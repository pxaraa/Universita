join: dopo la fork ricollega due processi in un processo
join(count):  ricollegare più di 2 processi

pid_t: cosa restituisce la fork : se>0 è il padre, se=0 è il figlio, se<0 errore
phtread_self(): restituisce il pid del thread
pthread_create(&tid, NULL, funzione, parametro da passare al padre);

pthread_t tid; //dichiaro il thread

sleep(  ): aspetta 100 secondi

phtread_join(tid,valore che il figlio passa al padre): aspetta che il thread finiscano

interrupt: interrompe il processo a livello hardware
phtread_mutex_t mutex variabile dell phtread_mutex
phtread_mutex_lock(&mutex) inizio regione critica
phtread_mutex_init(&mutex,NULL) inizializzo il mutex
phtread_mutex_destroy(&mutex) distrugge il mutex

sem_init(&sem1,0,0)
sem_wait(&sem1):blocca il thread
smm_post(&sem2)