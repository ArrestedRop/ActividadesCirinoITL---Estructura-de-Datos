#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include "stack.h"

Stack stack;
bool empty;
bool full;

//1 META
    void goal()
    {   
        char* msg = "Programa basico que busca poner a prueba las funciones\n"
                    "de la pila implementada en stack.c y stack.h";
        printf("%s\n", msg);
    }
    
//2 DATOS
    void data(int selection) {
        
        switch(selection) {
            case 1:
                printf("Añadiendo objetos al stack...\n");
                pushData(selection);
                break;
            case 2:
                printf("Eliminando objetos del stack...\n");
                pop(&stack);
                break;
            case 3:
                printf("Viendo el tope del stack...\n");
                top(&stack);
                break;
            case 4:
                printf("Verificando si el stack esta vacio...\n");
                empty = isEmpty(&stack);
                break;
            case 5:
                printf("Verificando si el stack esta lleno...\n");
                full = isFull(&stack);
                break;
        }
    }

    void pushData(int selection) {
        if (selection == 1) {
            char objects[10][50];
            int i = 0;
            char input[50];

            printf("Escriba el objeto que desea guardar o fin para terminar: \n");
            while (1) {
                printf("> ");
                scanf("%49s", input);
                if (strcmp(input, "fin") == 0) {
                    printf("Terminando...\n");
                    break;
                }
                if (i >= 10) {
                    printf("Limite de objetos alcanzado. No se pueden agregar mas.\n");
                    break;
                }

                strcpy(objects[i], input);
                push(&stack, objects[i]);
                i++;
            }
        }
    }
//3 PROCESOS
    // NO EXISTEN PROCESOS, SOLO SE EMPUJAN DATOS AL STACK, 
    // SE ELIMINAN, SE VERIFICA EL TOPE Y SE VERIFICA 
    // SI ESTA VACIO O LLENO
//4 SALIDAS
    void output(int selection) {
        switch (selection)
    }
//5 NAVEGACION
    int principalMenu() 
    {
        int choice = 0;
        int c;
        do {
            printf("Seleccione una opcion:\n");
            printf("1. Añadir objetos al stack\n");
            printf("2. Eliminar objetos del stack\n");
            printf("3. Ver el tope del stack\n");
            printf("4. Verificar si el stack esta vacio\n");
            printf("5. Verificar si el stack esta lleno\n");
            printf("6. Salir\n");
            printf("> ");

            if (scanf("%d", &choice) != 1) 
            {
                printf("\n[!] ERROR: Entrada invalida. Por favor, ingresa un numero.\n");
            
                while ((c = getchar()) != '\n' && c != EOF);
                choice = 0; 
                continue;
            }

        if (choice < 1 || choice > 6) 
            printf("\n[!] ERROR: Opcion fuera de rango. Elige un numero del 1 al 6.\n");
        else if (choice != 6) {printf("\nElegiste la opcion %d...\n", choice);}

        } while (choice != 6);
        return choice;
    }

    int main()
    {
        initialize(&stack);
        goal();
        int selection;
        do {
            selection = principalMenu();
            if (selection != 6) {
                data(selection);
            }
        } while (selection != 6);

        printf("Saliendo del programa. ¡Hasta luego!\n");
        return 0;
    }

