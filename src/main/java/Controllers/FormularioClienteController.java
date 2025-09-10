package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.factura.Cliente;
import org.example.factura.DatosCompartidos;

import java.util.ArrayList;
import java.util.List;

public class FormularioClienteController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtEmail;
    @FXML private Button btnIngresar;
    @FXML private Button btnActualizar;

    private final List<Cliente> listaClientes = new ArrayList<>();

    @FXML
    public void initialize() {
        btnIngresar.setOnAction(e -> registrarCliente());
        btnActualizar.setOnAction(e -> actualizarCliente());
    }

    private void registrarCliente() {
        Cliente cliente = new Cliente(
                txtNombre.getText(),
                txtId.getText(),
                txtDireccion.getText(),
                txtEmail.getText()
        );
        listaClientes.add(cliente);
        DatosCompartidos.setClienteActual(cliente); // ← Aquí
        mostrarConfirmacion("Cliente registrado:\n" + cliente.getNombre() + " (" + cliente.getId() + ")");
        limpiarCampos();
    }


    private void actualizarCliente() {
        String idBuscado = txtId.getText();
        for (Cliente c : listaClientes) {
            if (c.getId().equals(idBuscado)) {
                c.setNombre(txtNombre.getText());
                c.setDireccion(txtDireccion.getText());
                c.setEmail(txtEmail.getText());
                mostrarConfirmacion("Cliente actualizado: " + c.getNombre());
                limpiarCampos();
                return;
            }
        }
        mostrarError("Cliente con ID " + idBuscado + " no encontrado.");
    }


    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtDireccion.clear();
        txtEmail.clear();
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
