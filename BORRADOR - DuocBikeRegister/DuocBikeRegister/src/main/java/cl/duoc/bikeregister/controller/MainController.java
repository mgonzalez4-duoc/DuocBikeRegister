package cl.duoc.bikeregister.controller;

import cl.duoc.bikeregister.model.RegistroBicicleta;
import cl.duoc.bikeregister.repository.RegistroRepository;
import cl.duoc.bikeregister.repository.SQLiteRegistroDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class MainController {
    @FXML private TextField txtRut, txtNombre, txtCarrera, txtTelefono;
    @FXML private TextField txtMarca, txtModelo, txtColor, txtNumeroSerie;
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TableView<RegistroBicicleta> tablaRegistros;
    @FXML private TableColumn<RegistroBicicleta, String> colRut, colNombre, colCarrera;
    @FXML private TableColumn<RegistroBicicleta, String> colMarca, colModelo, colColor, colTipo, colSerie;
    @FXML private Label lblMensaje;

    private RegistroRepository repository;

    @FXML
    public void initialize() {
        configurarTabla();
        cmbTipo.setItems(FXCollections.observableArrayList(
                "Urbana", "Montaña", "Ruta", "Eléctrica", "Plegable", "BMX", "Otra"));
        cmbTipo.getSelectionModel().selectFirst();
        try {
            repository = new RegistroRepository(new SQLiteRegistroDAO());
            cargarTabla();
            mostrarMensaje("Base de datos conectada. Registros cargados.", false);
        } catch (Exception e) {
            mostrarMensaje("No se pudo iniciar la base de datos: " + e.getMessage(), true);
        }
    }

    private void configurarTabla() {
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colSerie.setCellValueFactory(new PropertyValueFactory<>("numeroSerie"));
    }

    @FXML
    private void registrar() {
        if (repository == null) return;
        if (!camposValidos()) {
            mostrarMensaje("Completa todos los campos antes de registrar.", true);
            return;
        }
        RegistroBicicleta registro = new RegistroBicicleta(
                txtRut.getText().trim(), txtNombre.getText().trim(), txtCarrera.getText().trim(),
                txtTelefono.getText().trim(), txtMarca.getText().trim(), txtModelo.getText().trim(),
                txtColor.getText().trim(), cmbTipo.getValue(), txtNumeroSerie.getText().trim());
        try {
            repository.registrar(registro);
            cargarTabla();
            limpiar();
            mostrarMensaje("¡Bicicleta registrada correctamente!", false);
        } catch (SQLException e) {
            if (e.getMessage() != null && e.getMessage().toLowerCase().contains("unique")) {
                mostrarMensaje("Ese número de serie ya está registrado.", true);
            } else {
                mostrarMensaje("Error al guardar: " + e.getMessage(), true);
            }
        }
    }

    private boolean camposValidos() {
        return noVacio(txtRut) && noVacio(txtNombre) && noVacio(txtCarrera) && noVacio(txtTelefono)
                && noVacio(txtMarca) && noVacio(txtModelo) && noVacio(txtColor)
                && noVacio(txtNumeroSerie) && cmbTipo.getValue() != null;
    }

    private boolean noVacio(TextField campo) {
        return campo.getText() != null && !campo.getText().trim().isEmpty();
    }

    @FXML
    private void buscarPorRut() {
        if (repository == null) return;
        if (!noVacio(txtBuscarRut)) {
            mostrarMensaje("Ingresa un RUT en el campo de búsqueda.", true);
            return;
        }
        try {
            var resultados = repository.buscarRut(txtBuscarRut.getText());
            tablaRegistros.setItems(FXCollections.observableArrayList(resultados));
            mostrarMensaje(resultados.size() + " registro(s) encontrado(s).", false);
        } catch (SQLException e) {
            mostrarMensaje("Error en la búsqueda: " + e.getMessage(), true);
        }
    }

    @FXML private TextField txtBuscarRut;

    @FXML
    private void mostrarTodos() {
        cargarTabla();
        txtBuscarRut.clear();
        mostrarMensaje("Mostrando todos los registros.", false);
    }

    @FXML
    private void eliminarSeleccionado() {
        if (repository == null) return;
        RegistroBicicleta seleccionado = tablaRegistros.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarMensaje("Selecciona una bicicleta de la tabla para eliminarla.", true);
            return;
        }
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("¿Eliminar el registro seleccionado?");
        confirmacion.setContentText(seleccionado.getMarca() + " " + seleccionado.getModelo()
                + " - " + seleccionado.getNombre());
        if (confirmacion.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            try {
                repository.eliminar(seleccionado.getId());
                cargarTabla();
                mostrarMensaje("Registro eliminado.", false);
            } catch (SQLException e) {
                mostrarMensaje("No se pudo eliminar: " + e.getMessage(), true);
            }
        }
    }

    @FXML
    private void limpiar() {
        txtRut.clear(); txtNombre.clear(); txtCarrera.clear(); txtTelefono.clear();
        txtMarca.clear(); txtModelo.clear(); txtColor.clear(); txtNumeroSerie.clear();
        cmbTipo.getSelectionModel().selectFirst();
    }

    private void cargarTabla() {
        if (repository == null) return;
        try {
            tablaRegistros.setItems(FXCollections.observableArrayList(repository.obtenerTodos()));
        } catch (SQLException e) {
            mostrarMensaje("Error al cargar registros: " + e.getMessage(), true);
        }
    }

    private void mostrarMensaje(String mensaje, boolean error) {
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(error ? "-fx-text-fill: #b42318;" : "-fx-text-fill: #18794e;");
    }
}
