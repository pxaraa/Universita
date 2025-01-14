reversed([],A,A).
reversed([H|T],Z,A):-
	reversed(T,[H|Z],A),
	write([H|Z]),nl.
reversed(F,LF):-
	reversed(F,[],LF).