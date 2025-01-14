ordinata(L,LO):-
	ordinata(LO),
	permutazione(L,LO).
	

permutazione([],[]).

permutazione([X|RX],Y):-
	member_con_resto(X,Y,RY),
	permutazione(RX,RY).


member_con_resto(X,[X|R],R).
	
member_con_resto(X,[P|R],[P|RR]):-
	member_con_resto(X,R,RR).




mergesort([],[]).
mergesort([X],[X]).

mergesort(L,LO):-
	lenght(L,N),
	N1 is N // 2,  
	lenght(L1,N1),
	
	append(L1,L2,L),
	mergesort(L1,LO1),
	mergesort(L2,LO2),
	merge(LO1,LO2,LO).
	


quicksort([],[]).	
quicksort([K|L],LO):-
	partition([K|L],L1,L2,K),
	quicksort(L1,LO1),
	quicksort(L2,LO2),
	append(LO1,LO2,LO).


partition([],[],[],_).

partition([E|L],[E|L1],L2,K):-
	E =< K,
	partition(L,L1,L2,K).


partition([E|L],L1,[E|L2],K):-
	E > K,
	partition(L,L1,L2,K).
	
	


	

	
	


	
	
	