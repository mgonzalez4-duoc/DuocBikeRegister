package cl.duoc.bikeregister.repository;

import cl.duoc.bikeregister.model.RegistroBicicleta;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Implementación DAO: guarda los registros en una base de datos SQLite local. */
public class SQLiteRegistroDAO implements RegistroDAO {
    private static final String URL = "jdbc:sqlite:data/duoc_bikes.db";

    public SQLiteRegistroDAO() throws SQLException, IOException {
        Files.createDirectories(Path.of("data"));
        crearTabla();
    }

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    private void crearTabla() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS registros_bicicletas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    rut TEXT NOT NULL,
                    nombre TEXT NOT NULL,
                    carrera TEXT NOT NULL,
                    telefono TEXT NOT NULL,
                    marca TEXT NOT NULL,
                    modelo TEXT NOT NULL,
                    color TEXT NOT NULL,
                    tipo TEXT NOT NULL,
                    numero_serie TEXT NOT NULL UNIQUE
                )
                """;
        try (Connection cn = conectar(); Statement st = cn.createStatement()) {
            st.execute(sql);
        }
    }

    @Override
    public void guardar(RegistroBicicleta r) throws SQLException {
        String sql = "INSERT INTO registros_bicicletas " +
                "(rut,nombre,carrera,telefono,marca,modelo,color,tipo,numero_serie) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection cn = conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, r.getRut());
            ps.setString(2, r.getNombre());
            ps.setString(3, r.getCarrera());
            ps.setString(4, r.getTelefono());
            ps.setString(5, r.getMarca());
            ps.setString(6, r.getModelo());
            ps.setString(7, r.getColor());
            ps.setString(8, r.getTipo());
            ps.setString(9, r.getNumeroSerie());
            ps.executeUpdate();
        }
    }

    @Override
    public List<RegistroBicicleta> listarTodos() throws SQLException {
        String sql = "SELECT * FROM registros_bicicletas ORDER BY id DESC";
        List<RegistroBicicleta> lista = new ArrayList<>();
        try (Connection cn = conectar(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }

    @Override
    public List<RegistroBicicleta> buscarPorRut(String rut) throws SQLException {
        String sql = "SELECT * FROM registros_bicicletas WHERE UPPER(rut) LIKE UPPER(?) ORDER BY id DESC";
        List<RegistroBicicleta> lista = new ArrayList<>();
        try (Connection cn = conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, "%" + rut.trim() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) lista.add(mapear(rs));
            }
        }
        return lista;
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try (Connection cn = conectar(); PreparedStatement ps = cn.prepareStatement(
                "DELETE FROM registros_bicicletas WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private RegistroBicicleta mapear(ResultSet rs) throws SQLException {
        return new RegistroBicicleta(rs.getInt("id"), rs.getString("rut"), rs.getString("nombre"),
                rs.getString("carrera"), rs.getString("telefono"), rs.getString("marca"),
                rs.getString("modelo"), rs.getString("color"), rs.getString("tipo"),
                rs.getString("numero_serie"));
    }
}
