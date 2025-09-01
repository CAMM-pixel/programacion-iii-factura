package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.factura.Producto;

import java.util.ArrayList;
import java.util.List;

public class FormularioProductosController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCantidad;
    @FXML private TextField txtPrecio;
    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private TextArea txtDescripcion;

    private final List<Producto> listaProductos = new ArrayList<>();

    @FXML
    public void initialize() {
        btnGuardar.setOnAction(e -> guardarProducto());
        btnActualizar.setOnAction(e -> actualizarProducto());
    }

    @FXML
    private void handleOpcion1(ActionEvent event) {
        System.out.println("Opción 1 seleccionada");
    }

    @FXML
    private void handleOpcion2(ActionEvent event) {
        System.out.println("Opción 2 seleccionada");
    }

    public List<Producto> getProductosRegistrados() {
        return listaProductos;
    }

    private void guardarProducto() {
        try {
            Producto producto = new Producto(
                    txtId.getText(),
                    txtNombre.getText(),
                    Integer.parseInt(txtCantidad.getText()),
                    Double.parseDouble(txtPrecio.getText()),
                    txtDescripcion.getText()
            );
            listaProductos.add(producto);
            mostrarConfirmacion("Producto guardado:\n" + producto.getNombre() + " (" + producto.getId() + ")");
            limpiarCampos();
        } catch (NumberFormatException ex) {
            mostrarError("Cantidad y precio deben ser numéricos.");
        }
    }

    private void actualizarProducto() {
        String idBuscado = txtId.getText();
        for (Producto p : listaProductos) {
            if (p.getId().equals(idBuscado)) {
                try {
                    p.setNombre(txtNombre.getText());
                    p.setCantidad(Integer.parseInt(txtCantidad.getText()));
                    p.setPrecio(Double.parseDouble(txtPrecio.getText()));
                    p.setDescripcion(txtDescripcion.getText());
                    mostrarConfirmacion("Producto actualizado: " + p.getNombre());
                    limpiarCampos();
                    return;
                } catch (NumberFormatException ex) {
                    mostrarError("Cantidad y precio deben ser numéricos.");
                    return;
                }
            }
        }
        mostrarError("Producto con ID " + idBuscado + " no encontrado.");
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtCantidad.clear();
        txtPrecio.clear();
        txtDescripcion.clear();
    }

    private void mostrarConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operación exitosa");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
