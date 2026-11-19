package cl.duoc.BikeRegister.Repository;

import cl.duoc.BikeRegister.config.ConexionBD;
import cl.duoc.BikeRegister.model.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehiculoDAO {

    public boolean registrar(Vehiculo vehiculo) {

        String sql = "INSERT INTO vehiculos " +
                "(rut_usuario, tipo, marca, modelo, color, numero_serie) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, vehiculo.getRutUsuario());
            sentencia.setString(2, vehiculo.getTipo());
            sentencia.setString(3, vehiculo.getMarca());
            sentencia.setString(4, vehiculo.getModelo());
            sentencia.setString(5, vehiculo.getColor());
            sentencia.setString(6, vehiculo.getNumeroSerie());

            sentencia.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar vehículo");
            e.printStackTrace();
            return false;
        }
    }
}
