:- dynamic fib/2.
fib(0,0).
fib(1,1).

fib(N,M):-
    N > 1,
    Nmeno1 is N - 1,
    Nmeno2 is N - 2,
    fib(Nmeno1,M1),
    fib(Nmeno2,M2),
    M is M1 + M2,
	assert(fib(N,M):-a(N,M))),
	listing(fib).
    