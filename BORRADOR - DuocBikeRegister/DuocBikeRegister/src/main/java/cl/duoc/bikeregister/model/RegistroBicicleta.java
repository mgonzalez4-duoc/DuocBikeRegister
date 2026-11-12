package cl.duoc.bikeregister.model;

/** Representa a una persona y la bicicleta que registra en Duoc. */
public class RegistroBicicleta {
    private int id;
    private String rut;
    private String nombre;
    private String carrera;
    private String telefono;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private String numeroSerie;

    public RegistroBicicleta(int id, String rut, String nombre, String carrera, String telefono,
                             String marca, String modelo, String color, String tipo, String numeroSerie) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.carrera = carrera;
        this.telefono = telefono;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }

    public RegistroBicicleta(String rut, String nombre, String carrera, String telefono,
                             String marca, String modelo, String color, String tipo, String numeroSerie) {
        this(0, rut, nombre, carrera, telefono, marca, modelo, color, tipo, numeroSerie);
    }

    public int getId() { return id; }
    public String getRut() { return rut; }
    public String getNombre() { return nombre; }
    public String getCarrera() { return carrera; }
    public String getTelefono() { return telefono; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public String getTipo() { return tipo; }
    public String getNumeroSerie() { return numeroSerie; }

    public void setId(int id) { this.id = id; }
}
