SET JAVA_HOME="C:\Program Files\Java\jdk1.7.0_17\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
SET JFLEX_HOME= C:\Fuentes\jflex-1.4.3
cd E:\Jefferson\Universidad\Ciclo 8\Analizador_Sintactico\src\Analizadores
java -jar %JFLEX_HOME%\lib\JFlex.jar Lexico.jflex
pause