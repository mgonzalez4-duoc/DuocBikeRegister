package cl.duoc.BikeRegister.model;

public class Scooter extends Vehiculo {

    private boolean es_electrico;

    public Scooter() {
        super();
    }

    public boolean isEs_electrico() {
        return es_electrico;
    }

    public void setEs_electrico(boolean es_electrico) {
        this.es_electrico = es_electrico;
    }

}