global ruta "U:\graficos\proyectos\EFHU2015\"
use "$ruta\A1\EFHUModA1.dta", clear
sysdir set PERSONAL "U:\graficos\proyectos\EFHU2015\stataJava\Stata\bin\"

* Fill Flags Throw Error (variable missing in dataset line 16 a199))
javacall StataInterfaceTest fillFlagsTest, args("c:\\stata\\testCSV\\preguntasError3.csv" "c:\\stata\\testCSV\\saltos.csv")


