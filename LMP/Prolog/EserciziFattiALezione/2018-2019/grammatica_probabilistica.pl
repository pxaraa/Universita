

a(X) --> b(X),c(X).

c(X) --> ['aho'], {random(0,4,X)}.
c(X) --> ['ehi'], {random(0,4,X)}.
c(X) --> ['ola'], {random(0,4,X)}.
c(X) --> ['uhm'], {random(0,4,X)}.

b(X) --> ['ciao'], {random(0,4,X)}.
b(X) --> ['buongiorno'], {random(0,4,X)}.
b(X) --> ['buonasera'], {random(0,4,X)}.
b(X) --> ['buonanotte'], {random(0,4,X)}.


vero_con_probabilita(X):-
	vero_nel_range(0,X).

vero_nel_range(X,Y):-
	random(Z),
	Z >= X,
	Z < Y.
