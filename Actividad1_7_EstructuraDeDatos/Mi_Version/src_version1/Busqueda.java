import javax.swing.*;

public class Busqueda {

    private int compara = 0;

    public int search(String nombre, Persona[] grupo, int cuenta) {
        this.compara = 0;
            for (int i = 0; i < cuenta; i++) {
                if (nombre.equalsIgnoreCase(grupo[i].getNombre())) {
                    JOptionPane.showMessageDialog(null,
                            "Persona encontrada con exito");
                    this.compara++;
                    return i;
                }
                JOptionPane.showMessageDialog(null,
                        "Dato no encontrado, intentar de nuevo");
            }
        return -1;
    }

    public int getCompara() {
        return this.compara;
    }
}

