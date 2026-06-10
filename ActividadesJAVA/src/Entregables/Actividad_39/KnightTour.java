package Entregables.Actividad_39;

/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 39
Fecha: 25/5/2026
 */

// Java program for Knight Tour problem
class KnightTour { 
    int N = 8; 
    int sol[][] = new int[N][N];
    int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
    int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
  
    /* A utility to check if i,j are valid indexes for N*N chessboard */
    boolean isSafe(int x, int y) { 
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1); 
    } 
  
    /* A utility function to print solution matrix sol[N][N] */
    void printSolution() { 
        for (int x = 0; x < N; x++) { 
            for (int y = 0; y < N; y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println(); 
        } 
    } 
  
    void inicio() {
       System.out.println("This program solves the Knight Tour problem"); 
       System.out.println("using Backtracking.  This  function mainly"); 
       System.out.println("uses solveKTUtil() to solve the problem. It"); 
       System.out.println("returns false if no complete tour is possible,"); 
       System.out.println("otherwise return true and prints the tour."); 
       System.out.println("Please note that there may be more than one"); 
       System.out.println("solutions, this function prints one of the ");
       System.out.println("feasible solutions.  ");
    }

    boolean solveKT() {  
        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++) 
            for (int y = 0; y < N; y++) 
                sol[x][y] = -1;   
       /* xMove[] and yMove[] define next move of Knight. 
          xMove[] is for next value of x coordinate 
          yMove[] is for next value of y coordinate */
        // Since the Knight is initially at the first block 
        sol[0][0] = 0;   
        /* Start from 0,0 and explore all tours using 
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1)) { 
            System.out.println("Solution does not exist"); 
            return false; 
        } else printSolution();   
        return true; 
    } 
  
    /* A recursive utility function to solve Knight 
       Tour problem */
    boolean solveKTUtil(int x, int y, int movei) { 
        int k, next_x, next_y; 

        if (movei == N * N) return true;   
        /* Try all next moves from the current coordinate x, y */
        for (k = 0; k < N; k++) { 
            next_x = x + xMove[k]; 
            next_y = y + yMove[k]; 
            if (isSafe(next_x, next_y)) { 
                sol[next_x][next_y] = movei; 
                if (solveKTUtil(next_x, next_y, movei + 1)) 
                    return true; 
                else sol[next_x][next_y] = -1;// backtracking 
            } 
        } 
        return false; 
    } 
  
    /* Driver program to test above functions */
    public static void main(String args[]) { 
       KnightTour kt = new KnightTour();

       kt.inicio(); 
       kt.solveKT(); 
    } 
} 
// This code is contributed by Abhishek Shankhadhar 

