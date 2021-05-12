/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.edu.uni.fcys.programacion2.tableviewfx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import uni.edu.uni.fcys.programacion2.tableviewfx.App;

/**
 * FXML Controller class
 *
 * @author Sistemas-12
 */
public class MainFXMLController implements Initializable {

    @FXML
    public Button btnProductos;
    @FXML
    public VBox VboxCenter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void btnProductosAction(ActionEvent event) {
        try {
            Parent node= App.loadFXML("ProductosFXML");
            VboxCenter.getChildren().clear();
            VboxCenter.getChildren().add(node);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
