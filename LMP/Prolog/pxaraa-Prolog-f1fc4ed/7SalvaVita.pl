appartiene(X,[X|_]).
appartiene(X,[_|T]):-
    appartiene(X,T).

appiccicata([],L2,L2).
appiccicata([H|T],L2,[H|T1]):-
    appiccicata(T,L2,T1).

rivoltata([],[]).
rivoltata([H|T],R):-
    rivoltata(T,TR),
    appiccicata(TR,[H],R).

occorrenze(_,[],0).
occorrenze(X,[X|T],N):-
    !,
    occorrenze(X,T,M),
    N is M + 1.
occorrenze(X,[_|T],N):-
    occorrenze(X,T,N).

lunghezza([],0).
lunghezza([_|T],N):-
    lunghezza(T,M),
    N is M + 1.

sottratto(_,[],[]).
sottratto(X,[X|T],T).
sottratto(X,[A|T],[A|S]):-
    sottratto(X,T,S). 
  
permutazione([],[]).
permutazione([H|T],P):-
    length([H|T],L),
    length(P,L),
    permutazione(T,TP),
    appartiene(H,P),
    sottratto(H,P,TP).


    


    
    