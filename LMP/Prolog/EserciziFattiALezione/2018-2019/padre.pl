padre(gino,pino).
padre(gino,rino).
padre(gino,dino).
padre(dino,tino).
padre(dino,lino).


duplicates([],[]).
duplicates([X|ListWithDup],ListWithoutDup):-
	member(X,ListWithDup),
	duplicates(ListWithDup,ListWithoutDup).
duplicates([X|ListWithDup],[X|ListWithoutDup]):-
	\+ member(X,ListWithDup),
	duplicates(ListWithDup,ListWithoutDup).
	



