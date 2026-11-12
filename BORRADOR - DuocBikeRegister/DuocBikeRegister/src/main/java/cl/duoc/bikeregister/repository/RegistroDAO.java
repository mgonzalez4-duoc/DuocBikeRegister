package cl.duoc.bikeregister.repository;

import cl.duoc.bikeregister.model.RegistroBicicleta;
import java.sql.SQLException;
import java.util.List;

public interface RegistroDAO {
    void guardar(RegistroBicicleta registro) throws SQLException;
    List<RegistroBicicleta> listarTodos() throws SQLException;
    List<RegistroBicicleta> buscarPorRut(String rut) throws SQLException;
    void eliminar(int id) throws SQLException;
}
