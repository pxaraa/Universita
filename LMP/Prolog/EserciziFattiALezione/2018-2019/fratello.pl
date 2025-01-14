
%Tizio è fratello di Caio se
%   Tizio ha mamma Caia e
%   Caio ha mamma Caia.
   
fratello(Tizio,Caio):- 
   mamma(Tizio,Caia),
   mamma(Caio,Caia).

fratello(Tizio,Caio):- 
   papa(Tizio,Caia),
   papa(Caio,Caia).
   
   
mamma(mario,pina).
mamma(dario,pina).
mamma(giovanni,rina).   

%mario ha mamma pina
%dario ha mamma pina
%giovanni ha mamma rina

%======
%? mario è fratello di dario?


%mario è fratello di dario se
%   mario ha mamma Caia e
%   dario ha mamma Caia.
