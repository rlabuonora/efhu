
global ruta "U:\graficos\proyectos\EFHU2015\"
use "$ruta\A1\EFHUModA1.dta", clear
sysdir set PERSONAL "U:\graficos\proyectos\EFHU2015\stataJava\Stata\bin\"

* Fill Flags
* javacall StataInterfaceTest fillFlagsTest, args("c:\\stata\\preguntas.csv" "c:\\stata\\saltosError.csv")

* javacall StataInterfaceTest fillFlagsTest, args("c:\\stata\\preguntas.csv" "c:\\stata\\saltos.csv")
javacall StataInterfaceTest fillFlagsTest, args("c:\\stata\\preguntasError3.csv" "c:\\stata\\saltos.csv")




