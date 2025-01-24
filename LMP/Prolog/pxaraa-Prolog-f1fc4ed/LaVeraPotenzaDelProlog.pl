%generare quando ci serve delle forme predicative al momento del bisogno:
%univ ----> =..
%Nel mondo procedurale il programma non può evolvere, cambia solo se si cambiano i dati.
%Procedurale     Dichiarativo
%DATI            FATTI
%A runtime attraverso -assert possiamo asserire fatti e regole o cancellarli con -retract, retractall per toglierli tutti.
:- dynamic person/2
%?- assert(person(mario,rossi)),
%?- assert(person(mario,rossi)),

%asserendo entriamo leggermente nella proceduralità in quanto è complice il fattore tempo. prima questo poi quest altro.
%write('text'),nl, scrivi e vai a capo
