sottoalbero_rad(t(A,_),t(A,[])).

sottoalbero_rad(t(A,LF),t(A,LFF)):-
    	\+ LF == [],
    	sottoalberi_rad(LF,LFF).
	
sottoalberi_rad([],[]).
sottoalberi_rad([A|LF],[SA|LFF]):-
    sottoalbero_rad(A,SA),
    sottoalberi_rad(LF,LFF).
%PUNTO PER IL CONTROLLO DELL ORDINE NELLA GENERAZIONE DELLE SOLUZIONI DEI SOTTOALBERI
sottoalbero(t(_,FS),TS):-
    member(T,FS),
    sottoalbero_rad(T,TS).
sottoalbero(T,TS):-
    sottoalbero_rad(T,TS).

sottoalberi(T,TSS):-
    setof(TS,sottoalbero(T,TS),TSS).

    