/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.edu.uni.fcys.programacion2.tableviewfx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import uni.edu.uni.fcys.programacion2.tableviewfx.pojo.Producto;

/**
 * FXML Controller class
 *
 * @author Sistemas-12
 */
public class ProductosFXMLController implements Initializable {

    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtDescipcion;
    @FXML
    public Spinner<Integer> spnCantidad;
    @FXML
    public TextField txtPrecio;
    @FXML
    public TextField txtImagen;
    @FXML
    public Button btnBuscar;
    @FXML
    public Button btnAgregar;
    @FXML
    public Button btnRemover;
    @FXML
    public TableView<Producto> tblvProductos;
    @FXML
    public TableColumn tblcNombre;
    @FXML
    public TableColumn  tblcDescipcion;
    @FXML
    public TableColumn  tblCantidad;
    @FXML
    public TableColumn  tblcPrecio;
    private ObservableList<Producto> productos;
    @FXML
    public Button btnActualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        productos = FXCollections.observableArrayList();
//        productos.add(new Producto(1,"Coca Cola", "Bebida", 2, 25, "ImagePath"));
        spnCantidad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1));
        tblcNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        tblcDescipcion.setCellValueFactory(new PropertyValueFactory("Descipcion"));
        tblCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        tblcPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        tblvProductos.setItems(productos);
    }    

    @FXML
    public void btnBuscarAction(ActionEvent event) {
    }

    @FXML
    public void btnAgregarAction(ActionEvent event) {
        String nombre,descripcion,imagen;
        int cantidad;
        float precio;
        
        nombre = txtNombre.getText();
        descripcion=txtDescipcion.getText();
        cantidad= Integer.parseInt(spnCantidad.getValue().toString());
        precio= Float.parseFloat(txtPrecio.getText().toString());
        
        productos.add(new Producto(cantidad, nombre, descripcion, cantidad, precio, null));
        
    }

    @FXML
    public void btnRemoverAction(ActionEvent event) {
        Producto p = this.tblvProductos.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            // La elimino de la lista
            this.productos.remove(p);
            // Refresco la lista
            this.tblvProductos.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Producto eliminado");
            alert.showAndWait();

        }
    }

    @FXML
    public void btnActualizarAction(ActionEvent event) {
          // Obtengo el producto seleccionada
        Producto p = this.tblvProductos.getSelectionModel().getSelectedItem();

        // Si el producto es null, lanzo error
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            try {
                // Obtengo los datos del formulario
                String nombre = this.txtNombre.getText();
                String descripcion = this.txtDescipcion.getText();
                int cantidad = Integer.parseInt(spnCantidad.getValue().toString());
                float precio=Float.parseFloat(txtPrecio.getText().toString());

                // Creo un producto
                Producto aux = new Producto(cantidad, nombre, descripcion, cantidad, precio, null);

                // Compruebo si el producto esta en el lista
                if (!this.productos.contains(aux)) {

                    // Modifico el objeto
                    p.setNombre(aux.getNombre());
                    p.setDescipcion(aux.getDescipcion());
                    p.setCantidad(aux.getCantidad());
                    p.setPrecio(aux.getPrecio());
                    p.setNombre(aux.getImage());

                    // Refresco la tabla
                    this.tblvProductos.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Persona modificada");
                    alert.showAndWait();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("La persona existe");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }

        }
    }

    @FXML
    public void selecionar(MouseEvent event) {
        
        Producto p = this.tblvProductos.getSelectionModel().getSelectedItem();

        // Sino es nula seteo los campos
        if (p != null) {
            this.txtNombre.setText(p.getNombre());
            this.txtDescipcion.setText(p.getDescipcion());
            this.txtPrecio.setText(p.getPrecio()+ "");
    }
        
            
        } 
}
