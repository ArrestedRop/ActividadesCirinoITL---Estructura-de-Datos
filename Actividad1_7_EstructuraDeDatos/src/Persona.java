public class Persona {
    private String nombre;
    private String fecha_nac;
    private Double talla;
    private Double peso;
    private String num_con;

    public Persona(){}
    public Persona(String nombre, String fecha_nac, Double talla,
                   Double peso, String num_con) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.talla = talla;
        this.peso = peso;
        this.num_con = num_con;
    }

    public boolean setNombre(String nombre) {
        if (this.nombre == null)
            return false;
        else {
            this.nombre = nombre;
            return true;
        }
    }

    public boolean setfecha_nac(String fecha_nac ){
        this.fecha_nac = fecha_nac;
        return true;
    }

    public boolean setEstatura(Double estatura) {
        this.talla = estatura;
        return true;
    }

    public boolean setPeso(Double peso) {
        this.peso = peso;
        return true;
    }

    public boolean setNum_con(String num_con) {
        this.num_con = num_con;
        return true;
    }


    public String getNombre() {
        return this.nombre;
    }

    public String getFecha_nac() {
        return this.fecha_nac;
    }

    public Double getTalla() {
        return this.talla;
    }

    public Double getPeso() {
        return this.peso;
    }

    public String getNum_con() {
        return this.num_con;
    }
}
