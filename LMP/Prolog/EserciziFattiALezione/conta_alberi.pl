:-dynamic star/2.


k(T1,T2,N):-
	t(T1,ST1),
	t(T2,ST2),
	intersect(ST1,ST2,I),
	length(I,N).

t(T,ST):-
    bagof(STA,sta(T,STA),ST).

sta(T,ST):-
    star(T,ST).
 

sta(tree(_,LF),ST):-
    member(TT,LF),
    sta(TT,ST).


star(tree(R,[]),tree(R,[])).
star(tree(R,[_|_]),tree(R,[])).
star(tree(R,[A|RS]),tree(R,LFA)):-
    star_figli([A|RS],LFA),
	write('-'),
	asserta(star(tree(R,[A|RS]),tree(R,LFA))).


star_figli([],[]).  
star_figli([T|RS],[STAR|RS_STAR]):- 
  star(T,STAR),
  star_figli(RS,RS_STAR).
  
  
/*intersect(A,B,AIB)*/
