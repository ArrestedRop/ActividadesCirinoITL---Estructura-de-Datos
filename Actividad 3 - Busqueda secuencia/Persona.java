public class Persona {
    private String nombre;
    private String fecha_de_nacimiento;
    private Double estatura;
    private Double peso;
    private Integer numero_de_control;


    public Persona(){}
    public Persona(String nombre, String fecha_de_nacimiento, Double estatura, Double peso, Integer numero_de_control) {
        this.nombre = nombre;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.estatura = estatura;
        this.peso = peso;
        this.numero_de_control = numero_de_control;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setNumero_de_control(Integer numero_de_control) {
        this.numero_de_control = numero_de_control;
    }


    public String getNombre() {
        return this.nombre;
    }

    public String getFecha_de_nacimiento() {
        return this.fecha_de_nacimiento;
    }

    public Double getEstatura() {
        return this.estatura;
    }

    public Double getPeso() {
        return this.peso;
    }

    public Integer getNumero_de_control() {
        return this.numero_de_control;
    }
}
