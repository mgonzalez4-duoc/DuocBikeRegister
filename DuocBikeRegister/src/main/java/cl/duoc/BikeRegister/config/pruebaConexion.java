package cl.duoc.BikeRegister.config;


import java.sql.Connection;

public class pruebaConexion {

    public static void main(String[] args) {

        Connection conexion = ConexionBD.conectar();

        if (conexion != null) {

            System.out.println("DuocBikeRegister conectado correctamente");

        } else {

            System.out.println("No se pudo conectar");

        }

    }
}