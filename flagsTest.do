
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
javacall StataInterface createQuestionTest, args("06" "a16" "Pagan algún alquiler por la parte de la vivienda que no pertenece al hogar?" )

* Create Flag
javacall StataInterface createFlagTest, args("06")
assert FL_06 == 0

* Set Flag
javacall StataInterface setFlagTest, args("2" "2050")
assert FL_06 == 2050 in 2


* Set Flag to Missing
javacall StataInterface setFlagToMissingTest, args("3")
assert FL_06 == . in 3
*/
* Get Response 
javacall StataInterface getResponseTest, args("9" "2")
javacall StataInterface getMissingResponseTest, args("10")
*/

* Next
javacall StataInterface nextTest, args("01" "1" "02")
