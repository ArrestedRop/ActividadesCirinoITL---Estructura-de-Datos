/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 11
Fecha: 6/3/2026
*/

#include <stdio.h>
#include <limits.h>
#include <float.h>
void goal();
void results();

int main() {
    goal();
    printf("LIMITES DE LOS TIPOS PRIMITIVOS DE DATOS EN C\n");
    printf("---------------------------------------------\n");
    results();

    return 0;
}

void goal() {
    printf("El objetivo de este programa es mostrar loslímites de los tipos primitivos de datos en C.\n\n");
}
void results() {
    printf("%-12s | %-20s | %-21s\n" , "Tipo", "Mínimo", "Máximo");  
    
    printf("%-12s | %-20d | %-20d\n",
         "char:", SCHAR_MIN, SCHAR_MAX);
    printf("%-12s | %-20d | %-20d\n",
         "int:", INT_MIN, INT_MAX);
    printf("%-12s | %-20e | %-20e\n",
         "float:", FLT_MIN, FLT_MAX);
    printf("%-12s | %-20ld | %-20ld\n",
         "long:", LONG_MIN, LONG_MAX);
}


