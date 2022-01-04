/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CustomerDAO;
import DTO.Customer;
import com.jfoenix.controls.JFXButton;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLCustomerController implements Initializable {

    @FXML
    private AnchorPane TA_CustomerLocation;
    @FXML
    private Button btnAddCustomer;
    @FXML
    private Button btnUpdateCustomer;
    @FXML
    private Button btnDeleteCustomer;
    @FXML
    private TextField TF_CustomerCode;
    @FXML
    private TextField TF_CustomerPhone;
    @FXML
    private TextField TF_CustomerName;
    @FXML
    private TextArea TA_Customer;
    @FXML
    private TableView<Customer> TVCustomer;
    @FXML
    private TableColumn<Customer, String> col_CustomerCode;
    @FXML
    private TableColumn<Customer, String> col_CustomerName;
    @FXML
    private TableColumn<Customer, String> col_CustomerPhone;
    @FXML
    private TableColumn<Customer, String> col_CustomerLocation;
    
    //a list that allows listener to track changes that occurs
    ObservableList<Customer> ListCustomers = FXCollections.observableArrayList();
    @FXML
    private TextField TF_CustomerId;
    @FXML
    private JFXButton btnToOrder1;
    @FXML
    private JFXButton btnToHome;
    @FXML
    private JFXButton jfxbtn_tocustomer;
    @FXML
    private JFXButton btnToProduct1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        updateTable();
        GetTableRowToTextField();
    }    

    @FXML
    private void addCustomer(ActionEvent event) {
        if (TF_CustomerName.getText().equals("") || TF_CustomerPhone.getText().equals("") || TA_Customer.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        }else {
        
            ListCustomers.clear();
            CustomerDAO sc = new CustomerDAO();
            Customer c = new Customer();

            c.setCustomerCode(TF_CustomerCode.getText());
            c.setFullName(TF_CustomerName.getText());
            c.setPhone(TF_CustomerPhone.getText());
            c.setLocation(TA_Customer.getText());
            
            TF_CustomerCode.setText("");
            TF_CustomerName.setText("");
            TF_CustomerPhone.setText("");
            TA_Customer.setText("");
            TF_CustomerCode.requestFocus();

            try {
                sc.Add(c);
                updateTable();
                JOptionPane.showMessageDialog(null, " Customer added");
            } catch (SQLException ex) {
                System.out.println("the error is");
                System.out.println(ex.getMessage());
            }
            
        }
    }

    @FXML
    private void UpdateCustomer(ActionEvent event) {
        if (TF_CustomerId.getText().equals("") || TF_CustomerCode.getText().equals("") || TF_CustomerName.getText().equals("") || TF_CustomerPhone.getText().equals("") || TA_Customer.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        }else {
            ListCustomers.clear();
            CustomerDAO sc = new CustomerDAO();
            Customer c = new Customer();


            c.setCustomerId(Integer.parseInt(TF_CustomerId.getText()));
            c.setCustomerCode(TF_CustomerCode.getText());
            c.setFullName(TF_CustomerName.getText());
            c.setPhone(TF_CustomerPhone.getText());
            c.setLocation(TA_Customer.getText());


            try {
                sc.Update(c);
                updateTable();
                JOptionPane.showMessageDialog(null, " Customer modified");
            } catch (SQLException ex) {
                System.out.println("the error is");
                System.out.println(ex.getMessage());
            }
        
        }
    }
    
    
    public void updateTable() {
 
        CustomerDAO sc = new CustomerDAO();
        Customer c = new Customer();
        try {
            //            ListPers.addAll(sp.getPersonnles());
           ListCustomers.addAll(sc.readALL()); //2- add all the content of the previous list in the observable list
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //3- define for each table view cell which content of the observablelist will take as value
        col_CustomerCode.setCellValueFactory(new PropertyValueFactory<>("customerCode"));
        col_CustomerName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        col_CustomerPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_CustomerLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        //4- fill the table view with observablelist content
        TVCustomer.setItems(ListCustomers);  
    }
    
    @FXML
    private void DeleteCustomer(ActionEvent event) {
        ListCustomers.clear();
        CustomerDAO sc = new CustomerDAO();
        Customer c = new Customer();
        
        c.setCustomerId(Integer.parseInt(TF_CustomerId.getText()));
        c.setCustomerCode(TF_CustomerCode.getText());
        c.setFullName(TF_CustomerName.getText());
        c.setPhone(TF_CustomerPhone.getText());
        c.setLocation(TA_Customer.getText());
        
        try {
            sc.delete(c.getCustomerId());
            updateTable();
            JOptionPane.showMessageDialog(null, "customer deleted");
        } catch (SQLException ex) {
            System.out.println("the errror is in the delete controller");
            System.out.println(ex.getMessage());
        }
    }
     
    private void GetTableRowToTextField() {
          TVCustomer.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){
              @Override
              public void handle(javafx.scene.input.MouseEvent event) {
                Customer c = TVCustomer.getItems().get(TVCustomer.getSelectionModel().getSelectedIndex());
                TF_CustomerId.setText(String.valueOf(c.getCustomerId()));
                TF_CustomerCode.setText(c.getCustomerCode());
                
                TF_CustomerName.setText(c.getFullName());
                TF_CustomerPhone.setText(c.getPhone());
                TA_Customer.setText(c.getLocation()); 
                
                
                  
              }
          });
    }
    
    private void Clear(ActionEvent event) {
        TF_CustomerCode.setText("");
        TF_CustomerName.setText("");
        TF_CustomerPhone.setText("");
        TA_Customer.setText("");
        TF_CustomerCode.requestFocus();
    }


    @FXML
    private void toOrder1(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLOrder.fxml"));
        //FXMLAdminHomeController de = loader.getController();
        
        // get controller of FXMLCustomer
        FXMLCustomerController orderController = loader.getController();
        Parent root= loader.load();
        Stage stage =(Stage) btnToOrder1.getScene().getWindow();
       
        stage.setTitle("Order page");
        stage.setScene(new Scene(root));
    }

    @FXML
    private void toHome(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHomepage.fxml"));
            // get controller of FXMLCustomer
            FXMLCustomerController custController = loader.getController();
 
            Parent root= loader.load();
        
            Stage stage =(Stage) btnToHome.getScene().getWindow(); 
            stage.setTitle("Home page");
            stage.setScene(new Scene(root));   
    }

    @FXML
    private void tocutomer(ActionEvent event) throws Exception{

        //loqding FXMLCustomer and get instance of controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCustomer.fxml"));
        //FXMLAdminHomeController de = loader.getController();

        // get controller of FXMLCustomer
        FXMLCustomerController custController = loader.getController();
        Parent root= loader.load();
        Stage stage =(Stage) jfxbtn_tocustomer.getScene().getWindow();

        stage.setTitle("add customer");
        stage.setScene(new Scene(root));
    }

    @FXML
    private void btnToProduct1(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLProduct.fxml"));
            // get controller of FXMLCustomer
            FXMLProductController prodController = loader.getController();
 
            Parent root= loader.load();
        
            Stage stage =(Stage) btnToProduct1.getScene().getWindow(); 
            stage.setTitle("Product page");
            stage.setScene(new Scene(root)); 
    }
                       
}

