global ruta "U:\graficos\proyectos\EFHU2015\"
use "$ruta\A1\EFHUModA1.dta", clear
sysdir set PERSONAL "U:\graficos\proyectos\EFHU2015\stataJava\Stata\bin\"

* Fill Flags Throw Error (first line has wrong number of fields
javacall StataInterfaceTest fillFlagsTest, args("c:\\stata\\testCSV\\preguntasError.csv" "c:\\stata\\testCSV\\saltos.csv")

