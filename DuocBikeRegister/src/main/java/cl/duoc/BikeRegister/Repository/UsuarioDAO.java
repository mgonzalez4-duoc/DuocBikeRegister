package cl.duoc.BikeRegister.Repository;

import cl.duoc.BikeRegister.config.ConexionBD;
import cl.duoc.BikeRegister.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    // Método para registrar un usuario
    public boolean registrar(Usuario usuario) {

        String sql = "INSERT INTO usuarios " +
                "(rut, dv, nombre, apellido, carrera, telefono, correo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario.getRut());
            sentencia.setString(2, usuario.getDv());
            sentencia.setString(3, usuario.getNombre());
            sentencia.setString(4, usuario.getApellido());
            sentencia.setString(5, usuario.getCarrera());
            sentencia.setString(6, usuario.getTelefono());
            sentencia.setString(7, usuario.getCorreo());

            sentencia.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al registrar usuario");
            e.printStackTrace();

            return false;
        }
    }
}
