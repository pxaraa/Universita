/*count(X,L,NUM_VOLTE)*/


count(_,[],0).

count(X,[X|R],NUM_VOLTE):-
	count(X,R,NUM_VOLTE_1),
	NUM_VOLTE is NUM_VOLTE_1 + 1.
	
count(X,[_|R],NUM_VOLTE):-
	count(X,R,NUM_VOLTE).



count1(_,[],0).   

count1(X,[X|R],NUM_VOLTE):-             %count1(a,[a,B,a,C],2). X = a, R = [B,a,C], NUM_VOLTE = 2
	count1(X,R,NUM_VOLTE_1),
	NUM_VOLTE is NUM_VOLTE_1 + 1.
	
count1(X,[X1|R],NUM_VOLTE):-
	X \= X1,
	count1(X,R,NUM_VOLTE).


count2(_,[],0).

count2(X,[X|R],NUM_VOLTE):-
	!,count2(X,R,NUM_VOLTE_1),
	NUM_VOLTE is NUM_VOLTE_1 + 1.
	
count2(X,[_|R],NUM_VOLTE):-
	count2(X,R,NUM_VOLTE).
	
	
	
count3(_,[],0).

count3(X,[X1|R],NUM_VOLTE):-               % count3(D,[a,B,a,C],4). --> D = X = a, R = [B,a,C], NUM_VOLTE = 4
	nonvar(X),
	nonvar(X1),
	X = X1,
	%nonvar(R),   
	count3(X,R,NUM_VOLTE_1),
	NUM_VOLTE is NUM_VOLTE_1 + 1.
	
count3(X,[X1|R],NUM_VOLTE):-
	nonvar(X),
	nonvar(X1),
	X \= X1,
	count3(X,R,NUM_VOLTE).
	
count3(X,[X1|R],NUM_VOLTE):-
	nonvar(X),
	var(X1),
	%X \= X1,
	count3(X,R,NUM_VOLTE).
	

