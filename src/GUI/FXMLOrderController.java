/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.OrderDAO;
import DTO.Order;
import DTO.Product;
import DTO.User;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elife-Beja-138
 */
public class FXMLOrderController implements Initializable {

    @FXML
    private JFXButton btnToHome;
    @FXML
    private JFXButton btnToCostumer1;
    @FXML
    private JFXButton btnToProduct;
    @FXML
    private JFXButton btnToOrder1;
    @FXML
    private TableView<Order> TVOrder;
    @FXML
    private TableColumn<Order, Integer> col_orderId;
    
    @FXML
    private TableColumn<Order, Integer> col_costumerId;
    @FXML
    private TableColumn<Product, Integer> col_prodID;
    @FXML
    private TableColumn<Product, Double> col_quantityO;
    @FXML
    private TableColumn<Product, String> col_prodName;
    @FXML
    private TableColumn<Product, String> col_brand;
    @FXML
    private TableColumn<User, String> col_employee;
    @FXML
    private TableColumn<User, String> col_soldBy;
    
        ObservableList<Order> OrderList = FXCollections.observableArrayList();
        ObservableList<Order> OrderdetailList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Order, Double> col_price;
    @FXML
    private TableView<Order> TVOrderDetail;
    @FXML
    private TableColumn<Order, Integer> col_orderID;
    @FXML
    private TableColumn<Order, Integer> col_cusID;
    @FXML
    private TableColumn<Order, Double> col_soldb;
    @FXML
    private TableColumn<Order, Double> col_cost;
    
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            updateTable();
            updateTable1();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(FXMLOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void toCostumer1(ActionEvent event) throws IOException {
        //loqding FXMLCustomer and get instance of controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCustomer.fxml"));
        //FXMLAdminHomeController de = loader.getController();

        // get controller of FXMLCustomer
        FXMLCustomerController custController = loader.getController();
        Parent root= loader.load();
        Stage stage =(Stage) btnToCostumer1.getScene().getWindow();

        stage.setTitle("add customer");
        stage.setScene(new Scene(root));
    }

    @FXML
    private void toProduct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLProduct.fxml"));
            // get controller of FXMLCustomer
            FXMLProductController prodController = loader.getController();
 
            Parent root= loader.load();
        
            Stage stage =(Stage) btnToProduct.getScene().getWindow(); 
            stage.setTitle("Product page");
            stage.setScene(new Scene(root)); 
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
    
    public void updateTable() throws SQLException {
        OrderList.clear();
          OrderDAO so = new OrderDAO();
          Order o = new Order();
          try {
            OrderList.addAll(so.readALL());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
           col_prodID.setCellValueFactory(new PropertyValueFactory<>("prodId"));
           col_quantityO.setCellValueFactory(new PropertyValueFactory<>("quantityOrder"));
           col_price.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
           col_orderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
           col_costumerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
           col_prodName.setCellValueFactory(new PropertyValueFactory<>("productName"));
           col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
           col_employee.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
           col_soldBy.setCellValueFactory(new PropertyValueFactory<>("soldBy"));
         
//            //4- fill the table view with observablelist content
           TVOrder.setItems(OrderList);
    }
    public void updateTable1() throws SQLException {
          OrderDAO so1 = new OrderDAO();
          Order o = new Order();
          try {
            OrderdetailList.addAll(so1.readALLdetail());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
          
         
//    private int customerId;
//    //private int userId;
//    private double quantityOrder,totalPrice, sellingPrice, totalCost;
//    private String date, productName, brand, employeeName, soldBy;


            col_orderID.setCellValueFactory(new PropertyValueFactory<>("orderId"));
            col_cusID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            col_soldb.setCellValueFactory(new PropertyValueFactory<>("soldBy"));
            col_cost.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
            
//            //4- fill the table view with observablelist content
           TVOrderDetail.setItems(OrderdetailList);
    }
    
}
