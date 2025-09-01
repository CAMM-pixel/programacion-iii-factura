package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;

public class VistaPrincipalController {
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tabCliente;

    @FXML
    private Tab tabProducto;

    @FXML
    private Tab tabFactura;

    @FXML
    public void initialize() {
        System.out.println("VistaPrincipalController inicializado");
        try {
            Parent formularioCliente = FXMLLoader.load(
                    getClass().getResource("/FormularioCliente.fxml")
            );
            tabCliente.setContent(formularioCliente);


            Parent formularioProductos = FXMLLoader.load(
                    getClass().getResource("/FormularioProductos.fxml")
            );
            tabProducto.setContent(formularioProductos);


            Parent vistaFactura = FXMLLoader.load(
                    getClass().getResource("/VistaFactura.fxml")
            );
            tabFactura.setContent(vistaFactura);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void irATabFactura() {
        tabPane.getSelectionModel().select(tabFactura);
    }

    public void irATabProducto() {
        tabPane.getSelectionModel().select(tabProducto);
    }
}

