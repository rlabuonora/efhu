
/* 
** FlagsTest.do
*
*  A script for testing Java class to interact with Stata
*
*  Usage:
*
*  "C:\Archivos de programa\Stata13\stataMP" /e do "u:\graficos\proyectos\EFHU2015\stataJava\flagsTest.do"
*
*/
global ruta "U:\graficos\proyectos\EFHU2015\"
use "$ruta\A1\EFHUModA1.dta", clear
describe a11

sysdir set PERSONAL "U:\graficos\proyectos\EFHU2015\stataJava\Stata\bin\"

** Test for the Question class that require STATA runtime

* create Question 6
javacall StataInterfaceTest initializeQuestion, args("06" "a16" "Pagan algún alquiler por la parte de la vivienda que no pertenece al hogar?" )


* initialize Interface
javacall StataInterfaceTest initializeInterface, args("c:\\stata\\preguntas.csv" "c:\\stata\\saltos.csv")

* Create Flag
javacall StataInterfaceTest createFlagTest, args("06")
assert FL_06 == 0

* Set Flag
javacall StataInterfaceTest setFlagTest, args("2" "2050")
assert FL_06 == 2050 in 2


* Set Flag to Missing
javacall StataInterfaceTest setFlagToMissingTest, args("3")
assert FL_06 == . in 3
*/
* Get Response 
javacall StataInterfaceTest getResponseTest, args("9" "2")
javacall StataInterfaceTest getMissingResponseTest, args("10")
*/

* Next using EFHU dataset => args: pregunta, observación, siguiente pregunta
* Ejemplo: Observación 1 pasa de 01 a 02:
javacall StataInterfaceTest nextTest, args("01" "1" "02")


javacall StataInterfaceTest nextTest, args("03" "1" "45")
javacall StataInterfaceTest nextTest, args("03" "6" "48")
javacall StataInterfaceTest nextTest, args("03" "2" "04")

* Observación 2 pasa de 17 a 51:
javacall StataInterfaceTest nextTest, args("17" "2" "51")


