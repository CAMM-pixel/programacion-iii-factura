package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.factura.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VistaFacturaController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private Button btnBuscar;
    @FXML private Button btnCrear;

    @FXML private TableView<LineaFactura> tab;
    @FXML private TableColumn<LineaFactura, String> colId;
    @FXML private TableColumn<LineaFactura, String> colNombre;
    @FXML private TableColumn<LineaFactura, Integer> colCantidad;
    @FXML private TableColumn<LineaFactura, Double> colPrecio;
    @FXML private TableColumn<LineaFactura, Double> colTotal;

    @FXML private Label lblSubTotal;
    @FXML private Label lblIVA;
    @FXML private Label lblTotal;

    private Cliente clienteActual;
    private final List<Producto> productosSimulados = new ArrayList<>();

    @FXML
    public void initialize() {
        configurarTabla();
        btnBuscar.setOnAction(e -> buscarCliente());
        btnCrear.setOnAction(e -> crearFactura());
    }

    private void configurarTabla() {
        colId.setCellValueFactory(data -> data.getValue().getProducto().idProperty());
        colNombre.setCellValueFactory(data -> data.getValue().getProducto().nombreProperty());
        colCantidad.setCellValueFactory(data -> data.getValue().cantidadProperty().asObject());
        colPrecio.setCellValueFactory(data -> data.getValue().getProducto().precioProperty().asObject());
        colTotal.setCellValueFactory(data -> data.getValue().subtotalProperty().asObject());
    }



    private void buscarCliente() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        if (id.isEmpty() || nombre.isEmpty()) {
            mostrarError("Debes ingresar ID y nombre del cliente.");
            return;
        }
        clienteActual = new Cliente(nombre, id, "", "");
        mostrarConfirmacion("Cliente cargado: " + clienteActual.getNombre());
    }

    private void crearFactura() {
        if (clienteActual == null) {
            mostrarError("Primero debes buscar o crear un cliente.");
            return;
        }

        List<LineaFactura> lineas = new ArrayList<>();
        for (Producto p : productosSimulados) {
            lineas.add(new LineaFactura(p, p.getCantidad()));
        }

        Factura factura = new Factura("F001", LocalDate.now(), clienteActual, lineas, new IVA());

        tab.getItems().setAll(lineas);
        lblSubTotal.setText("SubTotal : $" + factura.calcularSubtotal());
        lblIVA.setText("IVA       : $" + factura.getImpuesto().calcular(factura.calcularSubtotal()));
        lblTotal.setText("Total     : $" + factura.calcularTotal());

        mostrarConfirmacion("Factura generada correctamente.");
    }

    private void mostrarConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
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
