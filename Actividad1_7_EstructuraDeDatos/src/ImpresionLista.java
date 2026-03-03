public class ImpresionLista {

    public void list(Persona[] grupo ) {

        for(int i = 0; i < grupo.length; i++){
            String nom = grupo[i].getNombre();
            String fecha_nac = grupo[i].getFecha_nac();
            String num_con = grupo[i].getNum_con();
            double peso = grupo[i].getPeso();
            double talla = grupo[i].getTalla();

            System.out.println((i+1) + ".- | " + nom +
                                         " | " + fecha_nac +
                                         " | " + num_con +
                                         " | " + peso +
                                         " | " + talla);
        }
    }
}
