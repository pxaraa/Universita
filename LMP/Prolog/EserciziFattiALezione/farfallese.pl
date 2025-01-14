/* caffe. --> cafaffefe */
/*
[c,a,f,f,e]
[c,a,f,a,f,f,e,f,e]
*/

traduci_in_farfallese:-
    leggi_stringa(R),
    !,
    in_farfallese(R,RF),
    write(RF),nl.

% Mondo procedurale

leggi_stringa(R):-
    leggi_stringa([],R).

leggi_stringa(R,RF):-
    get(A),
    controlla_e_appendi(A,R,RF).

controlla_e_appendi('.',R,R) :- !.

controlla_e_appendi(A,R,RF):-    
    append(R,[A],R1),
	leggi_stringa(R1,RF).

% Mondo dichiarativo
/* in_farfallese(M,FM) */
in_farfallese([],[]).
in_farfallese([A|R1],[A,f,A|R2]):-
    vocale(A),
    in_farfallese(R1,R2).

in_farfallese([A|R1],[A|R2]):-
    \+vocale(A),
    in_farfallese(R1,R2).

vocale(A):-
    member(A,[a,e,i,o,u]).

