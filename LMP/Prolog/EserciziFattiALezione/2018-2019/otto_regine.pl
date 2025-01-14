/*posizione_otto_regine([1/2,  ....,  ])*/


posizione_otto_regine(L):-


	no_attack(L).
	
	
no_attack([]).
no_attack([H|T]):-
	no_attack_1(H,L),
	no_attack(T).
	

no_attack_1(_,[]).
	
no_attack_1(A/B,[C/D|T]):-
	A =/= C,



	no_attack_1(A/B,T).
	
