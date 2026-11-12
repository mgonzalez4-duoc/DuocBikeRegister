package cl.duoc.bikeregister.repository;

import cl.duoc.bikeregister.model.RegistroBicicleta;
import java.sql.SQLException;
import java.util.List;

/** Capa intermedia entre el controlador y el DAO. */
public class RegistroRepository {
    private final RegistroDAO dao;

    public RegistroRepository(RegistroDAO dao) { this.dao = dao; }
    public void registrar(RegistroBicicleta registro) throws SQLException { dao.guardar(registro); }
    public List<RegistroBicicleta> obtenerTodos() throws SQLException { return dao.listarTodos(); }
    public List<RegistroBicicleta> buscarRut(String rut) throws SQLException { return dao.buscarPorRut(rut); }
    public void eliminar(int id) throws SQLException { dao.eliminar(id); }
}
