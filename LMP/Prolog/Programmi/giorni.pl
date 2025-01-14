%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Programma per la traduzione del nome dei giorni della
% settimana dall'italiano all'inglese e viceversa
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 
%%% giorno(G,D): vero se G e' il nome di un giorno in italiano
%%% e D e' il nome del giorno corrispondente in inglese

giorno('lunedi''', 'Monday').
giorno('martedi''', 'Tuesday').
giorno('mercoledi''', 'Wednesday').
giorno('giovedi''', 'Thursday').
giorno('venerdi''', 'Friday').
giorno('sabato', 'Saturday').
giorno('domenica', 'Sunday').


%%% Interfaccia utente

% Inizio programma

start :- write('Programma di traduzione giorni della settimana'), 
         nl, 
         write('Scegliere la lingua (inglese./italiano.)'), nl,
         read(Lingua),
         traduci(Lingua), 
         nl,
         write('Arrivederci!').

% traduci(L): se L e' il nome 'italiano' ('inglese') legge il 
% nome di un giorno in italiano (inglese) e stampa il 
% corrispondente nome della settimana in inglese (italiano)

traduci(italiano) :- write('Dai il nome del giorno'),nl,
                     read(Nome_giorno),
                     giorno(Nome_giorno,X),
                     write(X), nl.

traduci(inglese) :-  write('Insert the name of the day'),nl,
                     read(Nome_giorno),
                     giorno(X,Nome_giorno),
                     write(X), nl.

