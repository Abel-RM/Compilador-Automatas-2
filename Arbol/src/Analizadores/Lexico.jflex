/* ---==: COdigo de usuario :==---*/
package Analizadores;

import Analizadores.simbolos;
import java_cup.runtime.Symbol;
%%
/* ---==: Opciones y declaraciones :==---*/

%cupsym simbolos
%caseless
%ignorecase
%class Scanner
%cup
%public
%line
%column

/* Simbolos */
SUM = "+"
MUL = "*"
MIN = "-"
DIV = "/"
IGL = "="
PA = "("
PC = ")"

/* Extras*/
Numero =[0-9]+
letra =[a-zA-ZñÑ]+


/*Comentarios*/

simple = [/][/][^\n]*

%{

/*Codigo de Usuario*/   

%}

%%
/*---==:Reglas léxicas:==--- */

/* Simbolos */
{SUM}            {return new Symbol(simbolos.SUM, yycolumn+1,yyline+1,new String(yytext()));}
{MUL}            {return new Symbol(simbolos.MUL, yycolumn+1,yyline+1,new String(yytext()));}
{MIN}            {return new Symbol(simbolos.MIN, yycolumn+1,yyline+1,new String(yytext()));}
{DIV}            {return new Symbol(simbolos.DIV, yycolumn+1,yyline+1,new String(yytext()));}
{IGL}            {return new Symbol(simbolos.IGL, yycolumn+1,yyline+1,new String(yytext()));}
{PA}            {return new Symbol(simbolos.PA, yycolumn+1,yyline+1,new String(yytext()));}
{PC}            {return new Symbol(simbolos.PC, yycolumn+1,yyline+1,new String(yytext()));}

/* Extras*/
{Numero}         {return new Symbol(simbolos.Numero, yycolumn+1,yyline+1,new String(yytext()));}


/* BLANCOS */
[ \t\r\f\n]+        { /* Se ignoran */}


/* Cualquier Otro */
.                    { System.out.println("Error Lexico -> Simbolo: \""+yytext()+"\" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1) );}