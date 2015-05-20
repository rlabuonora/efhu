global ruta "U:\graficos\proyectos\EFHU2015\"
use "$ruta\A1\EFHUModA1.dta", clear
*describe FL*

sysdir set PERSONAL "U:\graficos\proyectos\EFHU2015\stataJava\Stata\bin\"

** Test for the Question class that require STATA runtime
javacall StataInterface fillFlags, args("c:\\stata\\preguntasError2.csv" "c:\\stata\\saltos.csv")
