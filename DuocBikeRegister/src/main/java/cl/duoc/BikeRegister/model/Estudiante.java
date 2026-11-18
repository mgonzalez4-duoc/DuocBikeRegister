package cl.duoc.BikeRegister.model;

public class Estudiante implements Exportable {

    private String nombres;
    private String apellidos;
    private int rut;
    private String dv;
    private String Carrera;
    private int telefono;
    private String correo;

    public Estudiante() {
    }

    public Estudiante(String nombres, String apellidos, int rut, String dv, String carrera, int telefono, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rut = rut;
        this.dv = dv;
        Carrera = carrera;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", rut=" + rut +
                ", dv='" + dv + '\'' +
                ", Carrera='" + Carrera + '\'' +
                ", telefono=" + telefono +
                ", correo='" + correo + '\'' +
                '}';
    }
}
