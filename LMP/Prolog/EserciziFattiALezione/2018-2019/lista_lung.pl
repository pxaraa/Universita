
/*  lunghezza(Lista,LunghezzaDellaLista). */


lunghezza([],0).

lunghezza([H|T],N):-
	lunghezza(T,X),
	N is X+1.
