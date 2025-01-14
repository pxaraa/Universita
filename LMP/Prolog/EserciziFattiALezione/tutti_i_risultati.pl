:- dynamic collezione/1.
b(a).
b(c).
b(d).

/*
all_bs(D)
D = [a,c,d]



all_bs([a,c,d]) -- true.
*/



collezione([]).

all_bs(_):-
	b(X),
	collezione(S),
	retract(collezione(S)),
	assert(collezione([X|S])),
	fail.
	
	
all_bs(L):-
	collezione(L),
	retract(collezione(L)),
	assert(collezione([])).
