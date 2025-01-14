/*raggiungibileConUnArcoDa(NuovaFrontiera,VecchiaFrontiera)*/

path(A,B,PATH):-
	raggiungibile(F,[A]),
	member(B,F).

raggiungibile(NuovaFrontiera,VecchiaFrontiera):-
	raggiungibileConUnArcoDa(NuovaFrontiera, VecchiaFrontiera).

raggiungibile(NuovaFrontiera,VecchiaFrontiera):-
	raggiungibileConUnArcoDa(NuovaFrontieraI, VecchiaFrontiera),
	raggiungibile(NuovaFrontiera, NuovaFrontieraI).

raggiungibileConUnArcoDa([],[]).
raggiungibileConUnArcoDa(NuovaFrontiera,[A|R]):-
	raggiungibileConUnArcoDaUnNodo(NuovaFrontieraDaA,A),
	raggiungibileConUnArcoDa(NuovaFrontieraDaR,R),
	append(NuovaFrontieraDaA, NuovaFrontieraDaR, NuovaFrontiera).

raggiungibileConUnArcoDaUnNodo(NuovaFrontiera,N):-
	setof(Z,edge(N,Z),NuovaFrontiera),!.

raggiungibileConUnArcoDaUnNodo([],_).
	
	
edge(a,b).
edge(b,c).
edge(a,e).
edge(c,d).
edge(d,e).
edge(f,e).
edge(a,k).
edge(k,v).
edge(v,c).



