public class Impresion {
    public void outs(int pos, int compara, Persona[] grupo, String nombre) {

        System.out.println("El nombre solicitado: " + nombre);
        if (pos!=-1) {
            System.out.println("\nEsta en la posicion: " + pos);
            System.out.println("\nSu numero de control es:" + grupo[pos].getNumero_de_control());
            System.out.println("\nNacio el :" + grupo[pos].getFecha_de_nacimiento());
            System.out.println("\nSu peso es: "+ grupo[pos].getPeso());
            System.out.println("\nSu talla es: "+ grupo[pos].getEstatura());
        }
        else {
            System.out.println("No fue encontrado en el grupo");
        }
        System.out.println("Se realizaron "+ compara + " preguntas para la busqueda");
    }
}
