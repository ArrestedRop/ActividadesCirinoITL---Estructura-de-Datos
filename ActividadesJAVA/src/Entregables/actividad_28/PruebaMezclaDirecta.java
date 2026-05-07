/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 28
Fecha: 20/4/2026
*/

package Entregables.actividad_28;
import java.io.*;


public class PruebaMezclaDirecta {
    final int N = 716;
    final int TOPE = 999;

    public void goal() {   // META
        StringBuilder msg = new StringBuilder();

        msg.append("Script simple que busca poner a prueba\n");
        msg.append("la mezcla directa");
        System.out.println(msg);
    }

    //PROCESOS
    void mezclaDirecta(File f) throws IOException
    {
        int longSec;
        int numReg;
        File f1 = new File("ArchivoAux1");
        File f2 = new File("ArchivoAux2");

        numReg = (int)f.length()/4;
        longSec = 1;
        while (longSec < numReg)
        {
            distribute(f, f1, f2, longSec, numReg);
            mix(f1, f2, f, longSec, numReg);
            longSec *= 2;
        }
    }

  void distribute(File f, File f1, File f2,
                    int longSec, int numReg) throws IOException
    {
        int numSec, resto, i;
        DataInputStream flujo = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f)));
        DataOutputStream flujo1 = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f1)));
        DataOutputStream flujo2 = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f2)));
        numSec = numReg /(2*longSec);
        resto = numReg %(2*longSec);
        for (i = 1; i <= numSec; i++)
        {
            subSecuencia(flujo, flujo1, longSec);
            subSecuencia(flujo, flujo2, longSec);
        }

        if (resto > longSec)
            resto -= longSec;
        else
        {
            longSec = resto;
            resto = 0;
        }
        subSecuencia(flujo, flujo1, longSec);
        subSecuencia(flujo, flujo2, resto);
        flujo.close();
        flujo1.close();
        flujo2.close();
    }
    void subSecuencia(DataInput f, DataOutput t,
                      int longSec) throws IOException
    {
        int clave;
        for (int j = 1; j <= longSec; j++)
        {
            clave = f.readInt();
            t.writeInt(clave);
        }
    }

    void mix(File f1, File f2, File f,
            int lonSec, int numReg) throws IOException {
        int numSec, resto, i, j, k;
        int clave1 = 0, clave2 = 0;
        numSec = numReg / (2 * lonSec);
        resto = numReg % (2 * lonSec);
        DataOutputStream flujo = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f)));
        DataInputStream flujo1 = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f1)));
        DataInputStream flujo2 = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f2)));

        clave1 = flujo1.readInt();
        clave2 = flujo2.readInt();

        for (int s = 1; s <= numSec + 1; s++) {
            int n1, n2;
            n1 = n2 = lonSec;
            if (s == numSec + 1) {
                if (resto > lonSec)
                    n2 = resto - lonSec;
                else {
                    n1 = resto;
                    n2 = 0;
                }
            }
            i = j = 1;
            while (i <= n1 && j <= n2) {
                int clave;
                if (clave1 < clave2) {

                    clave = clave1;
                    try {
                        clave1 = flujo1.readInt();}
                    catch(EOFException e){;}
                    i++;
                }
                else
                {
                    clave = clave2;
                    try {
                        clave2 = flujo2.readInt();}
                    catch(EOFException e){;}
                    j++;
                }
                flujo.writeInt(clave);
            }
            for (k = i; k <= n1; k++)
            {
                flujo.writeInt(clave1);
                try {
                    clave1 = flujo1.readInt();}
                catch(EOFException e){;}
            }
            for (k = j; k <= n2; k++)
            {
                flujo.writeInt(clave2);
                try {
                    clave2 = flujo2.readInt();}
                catch(EOFException e){;}
            }
        }
        flujo.close();
        flujo1.close();
        flujo2.close();
    }

    //RESULTADOS
    void escribir(File f)
    {
        int clave, k;
        boolean mas = true;
        DataInputStream flujo = null;
        try {
            flujo = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(f)));
            k = 0;
            System.out.println("ARCHIVO DE CLAVES TIPO INT");
            while (mas)
            {
                k++;
                System.out.print(flujo.readInt() + " ");
                if (k % 11 == 0) System.out.println();
            }
        }
        catch (EOFException eof)
        {
            System.out.println("\n *** Fin del archivo ***\n");
            try
            {
                flujo.close();
            }
            catch (IOException er)
            {
                er.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //PRUEBA
    public static void main(String[] args) {
        PruebaMezclaDirecta p = new PruebaMezclaDirecta();
        File f = new File("ArchivoOrigen");
        DataOutputStream flujo = null;

        try {
            flujo = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(f)));
            for (int j = 1; j <= p.N; j++)
                flujo.writeInt((int)(1+p.TOPE*Math.random()));
            flujo.close();
            p.mezclaDirecta(f);
        }
        catch (IOException e) {
        System.out.println("Nigger");
        }
        p.escribir(f);
    }
}
