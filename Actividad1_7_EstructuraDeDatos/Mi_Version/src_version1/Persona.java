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
        if (nombre == null||nombre.isEmpty())
            return false;
        else {
            this.nombre = nombre;
            return true;
        }
    }

    public boolean setfecha_nac(String fecha_nac ){
        if (fecha_nac == null && !fecha_nac.matches("\\d{2}/\\d{2}/\\d{4}")) {
            this.fecha_nac = fecha_nac;
            return true;
        }
        return true;
    }

    public boolean setEstatura(Double talla) {
        if (talla == null||talla < 0.40 || talla > 2.40) {
            return false;
        }
        else {
            this.talla = talla;
            return true;
        }
    }

    public boolean setPeso(Double peso) {
        if(peso == null||peso < 20||peso > 635) {
            return false;
        }
        else {
            this.peso = peso;
            return true;
        }
    }

    public boolean setNum_con(String num_con) {

        if(num_con == null||num_con.isEmpty()||num_con.length() != 5) {
            return false;
        }
        else {
            this.num_con = num_con;
            return true;
        }
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
