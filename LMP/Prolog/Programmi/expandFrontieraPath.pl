reachable_paths([H|T], PATHS):-
    setof([X, H|T], (e(H, X), X \= a), PATHS).

expanded_frontier([], []).

expanded_frontier([P|RP], PATHS):-
    reachable_paths(P, P_PATHS),
    expanded_frontier(RP, R_PATHS),
    append(P_PATHS, R_PATHS, PATHS).

ex_pth_fr(P1, P2):-
    expanded_frontier(P1, P2).

ex_pth_fr(P1, P2):-
    expanded_frontier(P1, P3),
    ex_pth_fr(P3, P2).

e(a, g).
e(b, a).
e(g, c).
e(g, f).
e(c, b).
e(c, d).
e(f, e).
e(d, e).