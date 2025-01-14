

a(b).
a(a).

c(a).
c(d).


b(Z):-
	a(Z),
	write(Z),nl,
	fail.
b(_).



k(Z):-
	Z.
	
	
/*
b(Z):-
	a(Z),!,
	c(Z).
*/	


lista_aumentata(X,L,L):-
		member(X,L),!.

lista_aumentata(X,L,[X|L]).


		
