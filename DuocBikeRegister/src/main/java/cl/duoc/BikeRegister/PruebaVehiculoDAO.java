package cl.duoc.BikeRegister;

import cl.duoc.BikeRegister.Repository.VehiculoDAO;
import cl.duoc.BikeRegister.model.Bicicleta;

public class PruebaVehiculoDAO {

    public static void main(String[] args) {

        Bicicleta bicicleta = new Bicicleta();

        bicicleta.setRutUsuario("12345678");
        bicicleta.setTipo("Bicicleta");
        bicicleta.setMarca("Trek");
        bicicleta.setModelo("Marlin 5");
        bicicleta.setColor("Negro");
        bicicleta.setNumeroSerie("BIKE-001");

        VehiculoDAO dao = new VehiculoDAO();

        boolean resultado = dao.registrar(bicicleta);

        if (resultado) {
            System.out.println("Vehiculo registrado correctamente");
        } else {
            System.out.println("No se pudo registrar el vehiculo");
        }
    }

}