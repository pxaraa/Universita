%appartiene(3,[1,4,3]).
appartiene(X,[X|_]).
appartiene(X,[_|T]):-
	appartiene(X,T).

%concatenaTA([1,2],[1,4,3],C).
concatenata([],A,A).
concatenata([H|T], B, [H|L]):-
    concatenata(T,B,L).

%rivoltata([a,b,c],R).
rivoltata([],[]).
rivoltata([HX|TX],RX):-
    rivoltata(TX,RTX),
    concatenata(RTX,[HX],RX).
    

%lunghezza([],C).
%lunghezza([1,2,4],C).
lunghezza([],0).
lunghezza([_|T],A):-
    lunghezza(T,B),
    A is B+1.

%occorrenze(a,[1,a,3,a],N).
occorrenze(_,[],0).
occorrenze(X,[X|L],N):-
    !,
    occorrenze(X,L,M),
    N is M+1.
occorrenze(X,[_|L],N):-
    occorrenze(X,L,N).

permutazione([],[]).
permutazione([XH|XT],Y):-
    permutazione(XT,YmenoXH),
    lenght([XH|XT],N),
    lenght(Y,N),
