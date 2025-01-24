/* torre di hanoi */
% non so a che minchia serve
hanoi([],_,_).

%hanoi(stato iniziale,stato arrivo)
hanoi(h([X|A],B,C),h(A,[X|B],C)):-
    ordinata([X|A]),!,
    ordinata([X|B]),!,
    ordinata(C).
hanoi(h([X|A],B,C),h(A,B,[X|C])):-
    ordinata([X|A]),!,
    ordinata([X|C]),!,
    ordinata(B).
hanoi(h(A,[X|B],C),h([X|A],B,C)):-
    ordinata([X|B]),!,
    ordinata([X|A]),!,
    ordinata(C).
hanoi(h(A,[X|B],C),h(A,B,[X|C])):-
    ordinata([X|B]),!,
    ordinata([X|A]),!,
    ordinata(C).
hanoi(h(A,B,[X|C]),h(A,[X|B],C)):-
    ordinata([X|C]),!,
    ordinata([X|B]),!,
    ordinata(A).
hanoi(h(A,B,[X|C]),h([X|A],B,C)):-
    ordinata([X|C]),!,
    ordinata([X|A]),!,
    ordinata(B).

ordinata([]).
ordinata([_]).
ordinata([H1,H2|T]):-
    H1 > H2,
    ordinata([H2|T]),!.