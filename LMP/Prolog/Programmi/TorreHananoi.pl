%(T1, T2, T3) Rappresentazione dello stato

tr(s([A|T1], T2, T3), 
    s(T1, [A|T2], T3)).

tr(s(T1, [A|T2], T3),
    s([A|T1], T2, T3)).

tr(s(T1, [A|T2], T3),
    s(T1, T2, [A|T3])).

tr(s(T1, T2, [A|T3]),
    s(T1, [A|T2], T3)).

tr(s(T1, [A|T2], T3),
    s(T1, T2, [A|T3])).

tr(s(T1, T2, [A|T3]),
    s(T1, [A|T2], T3)).

tr(s(T1, T2, [A|T3]),
    s([A|T1], T2, T3)).

tr(s([A|T1], T2, T3),
    s(T1, T2, [A|T3])).


path(A, B, [A,B]) :-
    tr(A, B), !.

path(A, B, [A|PATH]) :-
    tr(A, C),
   	write(C), nl,
	path(C, B, PATH).
