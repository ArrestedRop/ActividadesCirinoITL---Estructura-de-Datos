public class Busqueda {

    private int compara = 0;

    public int search(String nombre, Persona[] grupo, int cuenta) {
        this.compara = 0;
        boolean encontrado = false;

        for (int i = 0; i < cuenta; i++) {
            if (nombre.equalsIgnoreCase(grupo[i].getNombre())) {
                encontrado = true;
                return i;
            }
            this.compara++;
        }
        return -1;
    }

    public int getCompara() {
        return this.compara;
    }
}

