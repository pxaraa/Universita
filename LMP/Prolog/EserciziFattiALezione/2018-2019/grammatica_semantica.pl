s(s(X,Y,Z)) --> sub(X), verb(Y), obj(Z).

verb(verb(eats)) --> [eats].
verb(verb(likes)) --> [likes].
verb(verb(swallows)) --> [swallows].
verb(verb(drinks)) --> [drinks].

obj(obj(apple)) --> [apple].
obj(obj(pie)) --> [pie].
obj(obj(lemon)) --> [lemon].

sub --> ['Mary'].
sub --> ['John'].
sub --> ['Anthony'].


['Mary', drinks, apple] --> 

Synt == s(sub('Mary'), verb(drinks), obj(apple)). 
						
						
						s
						
				sub    verb    obj
				 |       |      |
              'Mary'   drinks  apple				
						
Sem == drinks('Mary',apple).


interpretazione_semantica(Synt,Sem)



						
						
						
						
						
						
						


