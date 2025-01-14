final(s3).

trans(s1, a, s1).
trans(s1, a, s2).
trans(s1, b, s1).
trans(s2, b, s3).
trans(s3, b, s2).
trans(s1, a, s4).

silent(s2, s4).
silent(s3, s1).

accepts(State, []):-
	final(State).
accepts(State, [X|Rest]):-
	trans(State, X, NextState),
	accepts(NextState, Rest).
accepts(State, Rest):-
	silent(State, NextState),
	accepts(NextState, Rest).
