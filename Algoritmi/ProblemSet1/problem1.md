# Parentesi k-bilanciate


## Idea

Interpretiamo le parentesi come incrementi e decrementi di un contatore:
- `(` incrementa il bilancio di 1.
- `)` decrementa il bilancio di 1.

Definiamo:
- `balance(i)` come il bilancio dopo aver letto i primi i simboli.
- `balance(n)` come il bilancio alla fine della sequenza.

### Osservazioni

1. Se `balance(n) ≠ 0`, allora non sarà possibile bilanciare la sequenza aggiungendo lo stesso numero di `(` e `)` (poiché l’aggiunta di pari quantità di entrambe non modifica lo sbilanciamento totale). In questo caso, il risultato è \( +\infty \).

2. Se `balance(n) = 0`, la sequenza contiene lo stesso numero di `(` e `)`. Potrebbe però essere "sottobilanciata" in certi punti, cioè potrebbe andare in negativo durante la scansione.

   Consideriamo `min_balance` = il valore minimo raggiunto da `balance(i)` durante la scansione.  
   - Se `min_balance ≥ 0`, la sequenza non ha mai avuto deficit di parentesi aperte: è già 0-bilanciata.
   - Se `min_balance < 0`, per evitare che la sequenza "scenda sotto zero", dobbiamo aggiungere almeno `-min_balance` parentesi aperte all’inizio (e di conseguenza `-min_balance` parentesi chiuse alla fine). Quindi `k = -min_balance`.

## Algoritmo

1. Inizializza due variabili:
   - `par_aperte = 0`
   - `par_chiuse = 0`
   - `counter = 0`
   
2. Scansiona la sequenza di parentesi nella stringa \(S\): 
   - Per ogni simbolo \(x\) in \(S\):
     - Se \(x\) è `(`, `par_aperte++`.
     - Se \(x\) è `)`, `par_chiuse++`.
    - if `par_chiuse != par_aperte ` then:
        - **return** \( +\infty \).
    - else:
        - Per ogni simbolo \(x\) in \(S\):
           - se `x = (` then  `counter++`
           - else if `x = )` and `counter != 0`:
            `counter--` 

3. Alla fine della scansione:
    - **return** \( counter\).

--- 
## Complessità

- La complessità tempotale risulta \(O(n)\) per scansionare la sequenza e \(O(n)\) per eseguire le operazioni di addizione e sottrazione sul counter per un totale di \(O(2n)\)
> Costo temporale complessivo \(O(2n)\) ~ \(O(n)\) 
- La complessità spaziale risulta \(O(1)\) in quanto l'algoritmo utilizza memoria ausiliaria costante dipendente dal numero costante di variabili utilizzate
> Costo spaziale complessivo \(O(1)\)

---

## Correttezza

La correttezza dell'algoritmo è conseguenza della corretta gestione di qualsivoglia input.
Entrando più nello specifico, le problematiche gestite riguardano principalmente due casi:
   1.   \(|par_{aperte}|\ \neq |par_{chiuse}|\)
   \[\emph{ oppure }\]
   2. \(S\) risulta \(k\)-bilanciabile

###### 1) Numero delle partentesi aperte risulta diverso dal numero delle parentesi chiuse 
Dopo il primo ciclo for (in cui vengono contate le parentesi chiuse e aperte), nel caso in cui  \(|par_{aperte}|\ \neq |par_{chiuse}|\) l'algoritmo restituisce \( +\infty \) in quanto
\[ \nexists k \in \mathbb{N} \text{ tale che } {S} \text{ è una sequenza } k \emph v{-bilanciabile} \]  Un esempio banale può essere la seguente stringa: **( - ( - ( - ( -  <span style="color:red">)</span> - <span style="color:red">)</span>**

