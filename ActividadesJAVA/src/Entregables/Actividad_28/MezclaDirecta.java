package Entregables.Actividad_28;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MezclaDirecta {
    public static void sort(File F) {
        int reng;
        int longSec;
        File Fleft = new File("ArchivoAuxiliarIzquierdo");
        File Fright = new File("ArchivoAuxiliarDerecho");

        reng = (int)F.length()/4;
        longSec = 1;
        while(longSec < reng) {
        }
    }

    static
    void distribucion(File f, File Fleft, File Fright,
                    int longSec, int reng)
            
    {
        int numSec, resto, i;
        DataInputStream flujo = new DataInputStream(
                new BufferedInputStream((new FileInputStream(f))));


    }
}
