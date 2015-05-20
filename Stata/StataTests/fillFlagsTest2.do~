global ruta "U:\graficos\proyectos\EFHU2015\"
use "$ruta\A1\EFHUModA1.dta", clear
sysdir set PERSONAL "U:\graficos\proyectos\EFHU2015\stataJava\Stata\bin\"

* Fill Flags Should Work Correctly (Happy Path)
javacall StataInterfaceTest fillFlagsTest, args("c:\\stata\\preguntas.csv" "c:\\stata\\saltos.csv")


* Asserts

assert(FL_01) == .
assert(FL_02) == .
assert(FL_03) == .

assert(FL_04) == . if a13 == 1 | a13 == 2 | a13 == 3
assert(FL_04) == 0 if a13 == 4 | a13 == 5 | a13 == 6 | a13 == 97 | a13 == 98 | a13 == 99