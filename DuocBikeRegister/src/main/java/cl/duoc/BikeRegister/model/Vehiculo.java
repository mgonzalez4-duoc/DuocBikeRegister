package cl.duoc.BikeRegister.model;

public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private String color;
    private String rutUsuario;
    private String tipo;
    private String numeroSerie;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String color,
                    String rutUsuario, String tipo, String numeroSerie) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.rutUsuario = rutUsuario;
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

}
