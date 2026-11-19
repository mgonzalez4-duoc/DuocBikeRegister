package cl.duoc.BikeRegister.model;

public class Usuario {
    // Atributos
    private String rut;
    private String dv;
    private String nombre;
    private String apellido;
    private String carrera;
    private String telefono;
    private String correo;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor completo
    public Usuario(String rut, String dv, String nombre,
                   String apellido, String carrera,
                   String telefono, String correo) {

        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters y Setters

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
