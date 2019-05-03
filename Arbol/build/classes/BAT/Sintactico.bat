SET JAVA_HOME="C:\Program Files\Java\jdk1.7.0_17\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd E:\Jefferson\Universidad\Ciclo 8\Analizador_Sintactico\src\Analizadores
java -classpath C:\Fuentes\ java_cup.Main -parser sintactico -symbols simbolos Parser.cup
pause