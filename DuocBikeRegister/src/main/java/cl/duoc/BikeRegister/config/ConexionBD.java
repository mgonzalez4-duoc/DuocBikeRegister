package cl.duoc.BikeRegister.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/duoc_bike_register";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection conectar() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexion exitosa a MySQL");

        } catch (SQLException e) {

            System.out.println("Error al conectar con MySQL");
            e.printStackTrace();

        }

        return conexion;
    }
}
