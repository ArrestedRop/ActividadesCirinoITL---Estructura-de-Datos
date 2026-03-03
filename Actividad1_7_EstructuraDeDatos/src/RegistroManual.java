
import javax.swing.*;

public class RegistroManual {
    private int cuenta = 0;

    public Persona[] data() {
        cuenta = 0;
        Persona[] grupo = new Persona[25];
        String nom;

        nom = Misc.entryString("Proporcione el nom de la persona " +(cuenta+1)+
                               "o escriba \"fin\" para terminar");

        while (!nom.equalsIgnoreCase("fin")  && this.cuenta < grupo.length) {
            grupo[cuenta] = crearPersona(nom);
            this.cuenta++;
            JOptionPane.showMessageDialog(null,
                    "Persona registrada con exito");

                if (cuenta < grupo.length) {
                nom = Misc.entryString("Proporcione el nom de la persona " +(cuenta+1)+
                        "o escriba \"fin\" para terminar");
                }
            }
    return grupo;
    }
    public int getCuenta() {
        return this.cuenta;
    }
    private Persona crearPersona(String nom) {
        String num_con = Misc.entryString("De # de control: ");
        String fecha_nac = Misc.entryString("De Fecha de Nacimiento:");
        double peso = Misc.entryDouble("Peso de la persona:");
        double talla = Misc.entryDouble("Estatura de la persona:");
        return new Persona(nom, fecha_nac, talla, peso, num_con);
    }
}
