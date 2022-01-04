/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLHomepageController implements Initializable {

    @FXML
    private Button btnToOrder;
    @FXML
    private Button btnToProduct;
    @FXML
    private Button btnToCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void toOrder(ActionEvent event) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLOrder.fxml"));
        //FXMLAdminHomeController de = loader.getController();
        
        // get controller of FXMLCustomer
        FXMLCustomerController orderController = loader.getController();
        Parent root= loader.load();
        Stage stage =(Stage) btnToOrder.getScene().getWindow();
       
        stage.setTitle("Order page");
        stage.setScene(new Scene(root));
    }  

    
    @FXML
    private void toProduct(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLProduct.fxml"));
        
            FXMLProductController prodController = loader.getController();
            Parent root= loader.load();
            Stage stage =(Stage) btnToProduct.getScene().getWindow();

            stage.setTitle("add product");
            stage.setScene(new Scene(root));
        }catch(IOException x){
            System.out.println(x);
        }
        
    }

    @FXML
    private void toCustomer(ActionEvent event) throws Exception {
        //loqding FXMLCustomer and get instance of controller 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCustomer.fxml"));
        //FXMLAdminHomeController de = loader.getController();
        
        // get controller of FXMLCustomer
        FXMLCustomerController custController = loader.getController();
        Parent root= loader.load();
        Stage stage =(Stage) btnToCustomer.getScene().getWindow();
       
        stage.setTitle("add customer");
        stage.setScene(new Scene(root));
        //stage.show();
        //window.setTitle("gestion des administrateurs");
        //window.setScene(new Scene(roott));
    }
    
    
}
