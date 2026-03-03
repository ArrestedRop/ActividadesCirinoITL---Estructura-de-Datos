public class ImpresionIndividual {

    public void outs(int pos, int compara, Persona[] grupo, String nombre) {
        String num_con = grupo[pos].getNum_con();
        String fecha_nac = grupo[pos].getFecha_nac();
        double peso =  grupo[pos].getPeso();
        double talla = grupo[pos].getTalla();

        System.out.println("El nombre solicitado: " + nombre);
        if (pos!=-1) {
            System.out.println("\nEsta en la posicion:\n" + pos);
            System.out.println("\nSu numero de control es:\n" + num_con);
            System.out.println("\nNacio el:\n" + fecha_nac );
            System.out.println("\nSu peso es:\n"+ peso);
            System.out.println("\nSu talla es:\n"+ talla);
        }
        else {
            System.out.println("No fue encontrado en el grupo");
        }
        System.out.println("Se realizaron "+ compara
                            + " preguntas para la busqueda");
    }
}
