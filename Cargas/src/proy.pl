:-dynamic aprobadas/1,materias/1,semestre/1,carga/1,rc/1,esp/1,guar/1,credit/1.
%semestre 1
materia(5,calDif).
materia(5,funProg).
materia(4,tallerEtic).
materia(5,mateDis).
materia(4,tallerAdmin).
%semestre 2
materia(5,calInt).
materia(5,poo).
materia(4,cont).
materia(4,quimica).
materia(5,algebraLin).
%semestre 3
materia(5,calVec).
materia(5,estrucDat).
materia(4,culturaEmp).
materia(4,io).
materia(5,desSus).
%semestre 4
materia(5,ecDif).
materia(4,metNum).
materia(5,tap).
materia(5,funDB).
materia(5,sim).
%semestre 5
materia(5,graf).
materia(4,funTele).
materia(4,sistOp).
materia(4,tallerDB).
materia(4,funIng).
%semestre 6
materia(5,lenAut).
materia(5,redesComp).
materia(4,tallerSis).
materia(5,dba).
materia(5,ingSoft).
%semestre 7
materia(5,lenAutII).
materia(5,conmutacion).
materia(4,tallerInv).
materia(6,gestionSoft).
materia(10,residencias).

seriadas(calDif,calInt).
seriadas(calInt,calVec).
seriadas(calVec,ecDif).
seriadas(funProg,poo).
seriadas(poo,estrucDat).
seriadas(estrucDat,metNum).
seriadas(estrucDat,tap).
seriadas(funDB,tallerDB).
seriadas(tallerDB,dba).
seriadas(funIng,ingSoft).
seriadas(ingSoft,gestionSoft).
seriadas(sistOp,tallerSis).
seriadas(lenAut,lenAutII).
seriadas(funTele,redesComp).
seriadas(redesComp,conmutacion).

materias([calDif,funProg,tallerEtic,mateDis,tallerAdmin,calInt,poo,cont,quimica,algebraLin,calVec,estrucDat,culturaEmp,io,desSus,ecDif,metNum,tap,funDB,sim,graf,funTele,sistOp,tallerDB,funIng,lenAut,redesComp,tallerSis,dba,ingSoft,lenAutII,conmutacion,tallerInv,gestionSoft,residencias]).


materiaDif(2,calDif).
materiaDif(2,funProg).
materiaDif(2,tallerEtic).
materiaDif(2,mateDis).
materiaDif(2,tallerAdmin).

materiaDif(3,calInt).
materiaDif(2,poo).
materiaDif(2,cont).
materiaDif(2,quimica).
materiaDif(3,algebraLin).

materiaDif(3,calVec).
materiaDif(3,estrucDat).
materiaDif(2,culturaEmp).
materiaDif(2,io).
materiaDif(2,desSus).

materiaDif(3,ecDif).
materiaDif(2,metNum).
materiaDif(2,tap).
materiaDif(2,funDB).
materiaDif(2,sim).

materiaDif(2,graf).
materiaDif(2,funTele).
materiaDif(2,sistOp).
materiaDif(2,tallerDB).
materiaDif(1,funIng).

materiaDif(2,lenAut).
materiaDif(2,redesComp).
materiaDif(2,tallerSis).
materiaDif(2,dba).
materiaDif(2,ingSoft).

materiaDif(3,lenAutII).
materiaDif(2,conmutacion).
materiaDif(2,tallerInv).
materiaDif(3,gestionSoft).
materiaDif(0,residencias).


%inicializa las variables globales
ini:-retractall(credit(_)),retractall(aprobadas(_)),assert(aprobadas([])),retractall(materias(_)),assert(materias([calDif,funProg,tallerEtic,mateDis,tallerAdmin,calInt,poo,cont,quimica,algebraLin,calVec,estrucDat,culturaEmp,io,desSus,ecDif,metNum,tap,funDB,sim,graf,funTele,sistOp,tallerDB,funIng,lenAut,redesComp,tallerSis,dba,ingSoft,lenAutII,conmutacion,tallerInv,gestionSoft,residencias])),retractall(guar(_)),retractall(carga(_)),retractall(semestre(_)),retractall(rc(_)), retractall(esp(_)),assert(rc([])),assert(esp([])),assert(carga([])),assert(semestre(1)),assert(guar([])).

%concatena dos cadenas
concatena([],L,L).
concatena([X|L1],L2,[X|L3]):- concatena(L1,L2,L3).

fin:-retractall(materias(_)).

%reinicia carga
rcarga:- retractall(carga(_)),assert(carga([])).

%guarda en R un 1 si el alumno aprobo la materia M y un 0 si no
reprobA(M,R):- random(1,10,N),materiaDif(E,M),N>E,R is 1.
reprobA(_,R):- R is 0.

%guarda en guar el elemento L
fun(L):- guar(X),concatena(X,[L],R),retractall(guar(_)), assert(guar(R)).

% recibe una lista de materias y regresa una lista de las
% aprobadas y otra de las reprobadas
azar([]).
azar([X|L1]):-reprobA(X,R),(R == 1, fun(X),azar(L1)); azar(L1).
elimrep([],R):-retractall(guar(_)),assert(guar(R)).
elimrep([L|L1],R):- eliminar(L,R,N),elimrep(L1,N).
rand(L,A,R):-azar(L),guar(A),elimrep(A,L),guar(R),retractall(guar(_)),assert(guar([])).

%elemina X de la lista
eliminar(X, [X|Xs], Xs).
eliminar(X, [Y|Ys], [Y|Zs]):- eliminar(X, Ys, Zs).

%calcular el numero de creditos en la carga
cuentaC([],R):-R is 0.
cuentaC([L|L1],R):- materia(S,L),cuentaC(L1,R1),R is R1+S.
creditos(R):- carga(X),cuentaC(X,R).

%guarda un elemento en carga
gCarga(L):-carga(X),concatena(X,[L],R),retractall(carga(_)), assert(carga(R)).

%guarda un elemento en aprobadas
gAp(L):-aprobadas(X),concatena(X,[L],R),retractall(aprobadas(_)), assert(aprobadas(R)).

%guarda un elemento en credit
gCredit(L):-retractall(credit(_)), assert(credit(L)).

%une en una lista los creditos y las materias
imprimir(C,L,[C,L]).

%regresa true si la lista contiene el elemento X
contiene(_,[],R):- R is 0.
contiene(X,[L|L1],R):- (X==L,R is 1);(contiene(X,L1,R)).
verifica(X,L):- contiene(X,L,R), R == 1.

%revisa si esta seriada
seriada(M):- ( not(seriadas(S,M)),S==S,M==M ) ;  (seriadas(S,M),aprobadas(X),verifica(S,X)).

%elimina el elemento X de rc
eRc(X):- rc(L),eliminar(X,L,R),retractall(rc(_)),assert(rc(R)).

%elimina el elemento X de esp
eEsp(X):- esp(L),eliminar(X,L,R),retractall(esp(_)),assert(esp(R)).

%elimina de rc o esp una materia si ya la paso y las guarda en aprobadas
pasar([]).
pasar([M|M1]):-gAp(M),rc(X),esp(Y), ((verifica(M,X),eRc(M));(verifica(M,Y),eEsp(M));(1==1)),pasar(M1).

%guarda un elemento en rc
gRc(L):-rc(X),concatena(X,[L],R),retractall(rc(_)), assert(rc(R)).
%guarda un elemento en esp
gesp(L):- esp(X),concatena(X,[L],R),retractall(esp(_)), assert(esp(R)).

%verifica si L esta en rc o especial y lo guarda donde corresponde
reprob(L):-rc(X),esp(Y),((verifica(L,X),gesp(L),eRc(L));(verifica(L,Y),nl,write("!Has reprobado un especial!"),nl,fin);(gRc(L))).

%guarda las materias reprobadas
materiasRep([]).
materiasRep([L|L1]):- reprob(L),( materiasRep(L1)).


%elimina de materias las materias que se guardaron en carga
eMat(M):- materias(X),eliminar(M,X,R),retractall(materias(_)),assert(materias(R)).
eMat(_).
%guarda en carga las materias de la lista tomando en cuenta los creditos
gcar([L|L1]):-credit(C),materia(C2,L),creditos(X),Sum is X+C2,(C >= Sum,seriada(L),gCarga(L),eMat(L),cargar(L1));cargar(L1).
%regresa true si la lista esta vacia
isnull([]).

cargar(L):- not(isnull(L)),gcar(L).
cargar(_).

%carga las materias reprobadas
cargarep():-esp(E), cargar(E),rc(R),cargar(R).
cargarep().


simular(S):-S =< 12,cargarep(),materias(M),cargar(M),carga(C),not(isnull(C)),creditos(D),imprimir(D,C,I),rcarga,write(S),write(I),rand(C,A,R),pasar(A),materiasRep(R),nl,Q is S+1,simular(Q).
simular(_).

recorrer([]).
recorrer([L|L1]):- eMat(L), recorrer(L1).
rec([]).
rec([L|L1]):- gAp(L), rec(L1).

guardar(A,R):-recorrer(A),recorrer(R),rec(A),pasar(A),materiasRep(R).


old(S,C):-S >= C, write('Escribe las materias aprobadas en en semestre '),write(C),nl,read(A),write('Escribe las materias reprobadas en en semestre '),write(C),nl,read(R),guardar(A,R),N is C+1,old(S,N).
old(S,_):-R is S+1,assert(credit(19)),simular(R).


inicio3():- write('¿Cuantos semestres has cursado?'),read(S),old(S,1).
inicio4():- write('¿trabajas?(si/no)'),read(X),  ((X == 'no',gCredit(24),simular(1));(X == 'si',gCredit(19),simular(1)));inicio4().
inicio:- ini,write("¿Eres de nuevo ingreso?(si/no)"),nl,read(X),((X == 'no',inicio3());(X == 'si',inicio4());(inicio)).
















