
a(1).
b(2).
b(1).
c(2).


d(X) :- 
	b(X), !, a(X).


esploratore(N):-
	b(N),
%	write(N),nl,
	fail.


not(P):-
P,fail.

not(P):-
        true.
		