
/* somma_cifre(C1,C2,R,S)*/
somma_cifre(0,0,0,0).
somma_cifre(1,0,R,S).
somma_cifre(2,0,R,S).
somma_cifre(3,0,R,S).
somma_cifre(4,0,R,S).
somma_cifre(5,0,R,S).
somma_cifre(6,0,R,S).
somma_cifre(7,0,R,S).
somma_cifre(8,0,R,S).
somma_cifre(9,0,R,S).
somma_cifre(0,1,R,S).
somma_cifre(1,1,R,S).
somma_cifre(2,1,R,S).
somma_cifre(3,1,R,S).
somma_cifre(4,1,R,S).
somma_cifre(5,1,R,S).
somma_cifre(6,1,R,S).
somma_cifre(7,1,R,S).
somma_cifre(8,1,R,S).
somma_cifre(9,1,R,S).


somma([X2,Y2],[X1,Y1],[Z3,X3,Y3]):-
	somma_cifre(Y2,Y1,R1,Y3),
	somma_cifre(X2,X1,R2,X3t),
	somma_cifre(X3t,R1,R3,X3),
	somma_cifre(R2,R3,_,Z3).