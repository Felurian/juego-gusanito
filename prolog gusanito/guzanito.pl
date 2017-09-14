jugar():-
	t(TableroInicial),
	write("Tablero inicial: "),
	nl,
	write("        "),
	write(TableroInicial),
	nl,
	write("Resolviendo tablero:"),
	nl,
	write("        "),
	ganador(TableroInicial,TableroFinal),
	write(TableroFinal). /* sigue imprimiendo todos los tableros ganadores que encuentra */
	
transpose([[]|_], []).
transpose(M, [X|T]) :- row(M, X, M1),
                       transpose(M1, T).
row([], [], []).
row([[X|Xs]|Ys], [X|R], [Xs|Z]) :- row(Ys, R, Z).

t([[1,1,1,1],
   [0,1,1,1],
   [1,1,1,1],
   [1,1,1,1]]).

ganador(X,R):-
    winner(X),
    R = X
    ;
    movimientos(X,M),
    ganador(M,R).
movimientos(X,R):-
    moverH(X,R)
    ;
    moverV(X,R).
moverH([H|T],R):-
    movH(H,H2),
    R = [H2|T]
    ;
    moverH(T,R2),
    R = [H|R2].
moverV(T,R):-
    transpose(T,T2),
    moverH(T2,R2),
    transpose(R2,R).
movH([A,0,1,1],[A,1,0,0]). /* izq */
movH([0,1,1,A],[1,0,0,A]). /* izq */
movH([1,1,0,A],[0,0,1,A]). /* der */
movH([A,1,1,0],[A,0,0,1]). /* der */
sumTablero(X,R):- deepSum(X,2,R).
winner(X):- sumTablero(X,1).
deepSum(R,0,R).
deepSum([A|T],D,R):-
    D > 0,
    D2 is D-1,
    deepSum(A,D2,R2),
    (  T = [],
       R3 is 0
       ;
       T \= [],
       deepSum(T,D,R3)
    ),
    R is R2+R3.
/*
contarUnos([],0).
contarUnos([H|T],R):-
    sumarLista(H,R2),
    contarUnos(T,R3),
    R is R2 + R3.

sumarLista([],0).
sumarLista([H|T],R):-
    sumarLista(T,R2),
    R is H+R2.
threeD([
    [[1,1],
     [1,1]
    ],
    [[1,1],
     [1,1]
    ]
]).

tablero2([1,0,1,1]).

w([[1,0,0,0],
   [0,0,0,0],
   [0,0,0,0],
   [0,0,0,0]]).


*/




