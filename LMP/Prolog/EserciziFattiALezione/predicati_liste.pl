
% lunghezza(L,N)

lunghezza([],0).

lunghezza([_|R],N):-
	lunghezza(R,N1),
	N1 is N - 1.


% somma(L,S)
% è vero se  L è una lista di numeri e S è la somma degli elemnti della lista