package cl.duoc.BikeRegister;

import cl.duoc.BikeRegister.Repository.UsuarioDAO;
import cl.duoc.BikeRegister.model.Usuario;

public class PruebaUsuarioDAO {

    public static void main(String[] args) {

        Usuario usuario = new Usuario(
                "12345678",
                "9",
                "Juan",
                "Perez",
                "Ingenieria Informatica",
                "912345678",
                "juan@gmail.com"
        );

        UsuarioDAO dao = new UsuarioDAO();

        boolean resultado = dao.registrar(usuario);

        if (resultado) {
            System.out.println("Usuario registrado correctamente");
        } else {
            System.out.println("No se pudo registrar el usuario");
        }
    }
}
