/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ProductDAO;
import DTO.Product;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Elife-Beja-138
 */
public class FXMLProductController implements Initializable {

    @FXML
    private TableColumn<Product, Integer> col_productId;
    @FXML
    private TableColumn<Product, Integer> col_productCode;
    @FXML
    private TableColumn<Product, String> col_productName;
    @FXML
    private TableColumn<Product, Double> col_productCostPrice;
    @FXML
    private TableColumn<Product, Double> col_productSellingPrice;
    @FXML
    private TableColumn<Product, String> col_productBrand;
    @FXML
    private Button btnAddProduct;
    @FXML
    private Button btnUpdateProduct;
    @FXML
    private Button btnDeleteProduct;
    @FXML
    private JFXButton btnToCostumer1;
    @FXML
    private JFXButton btnToOrder1;
    @FXML
    private TableView<Product> TVProduct;
    @FXML
    private TextField TF_ProductId;
    @FXML
    private TextField TF_ProductSell;
    @FXML
    private TextField TF_ProductCost;
    @FXML
    private TextField TF_ProductName;
    @FXML
    private TextField TF_ProductCode;
    @FXML
    private TextField TF_ProductBrand;
    
    ObservableList<Product> Listproduct = FXCollections.observableArrayList();
    
    @FXML
    private JFXButton btnToHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTable();
        GetTableRowToTextField();
    }    

    @FXML
    private void addProduct(ActionEvent event) {
        Listproduct.clear();
        if ( TF_ProductName.getText().equals("") || TF_ProductCost.getText().equals("") || TF_ProductSell.getText().equals("")|| TF_ProductBrand.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        }else {
            
            ProductDAO sp = new ProductDAO();
            Product p = new Product();

            //p.setProductId(Integer.parseInt(TF_ProductId.getText()));
            p.setProductCode(Integer.parseInt(TF_ProductCode.getText()));
            p.setProductName(TF_ProductName.getText());
            p.setCostPrice(Double.parseDouble(TF_ProductCost.getText()));
            p.setSellingPrice(Double.parseDouble(TF_ProductSell.getText()));
            p.setBrand(TF_ProductBrand.getText());
            
            TF_ProductId.setText("");
            TF_ProductCode.setText("");
            TF_ProductName.setText("");
            TF_ProductCost.setText("");
            TF_ProductSell.setText("");
            TF_ProductBrand.setText("");
            TF_ProductId.requestFocus();

            try {
                sp.Add(p);
                updateTable();
                JOptionPane.showMessageDialog(null, " product added");
            } catch (SQLException ex) {
               System.out.println("the error is in add fxml");
                System.out.println(ex.getMessage());
            }

           
        }

    }

    @FXML
    private void UpdateProduct(ActionEvent event) {
        Listproduct.clear();
        if (TF_ProductCode.getText().equals("") || TF_ProductName.getText().equals("") || TF_ProductCost.getText().equals("") || TF_ProductSell.getText().equals("")|| TF_ProductBrand.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        }else {
            ProductDAO sp = new ProductDAO();
            Product p = new Product();

            p.setProductId(Integer.parseInt(TF_ProductId.getText()));
            p.setProductCode(Integer.parseInt(TF_ProductCode.getText()));
            p.setProductName(TF_ProductName.getText());
            p.setCostPrice(Double.parseDouble(TF_ProductCost.getText()));
            p.setSellingPrice(Double.parseDouble(TF_ProductSell.getText()));
            p.setBrand(TF_ProductBrand.getText());


            try {
                sp.Update(p);
                updateTable();
                JOptionPane.showMessageDialog(null, " product modified");
            } catch (SQLException ex) {
                System.out.println("the error is in update fxml");
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    private void DeleteProduct(ActionEvent event) {
        Listproduct.clear();
        ProductDAO sp = new ProductDAO();
        Product p = new Product();

        p.setProductId(Integer.parseInt(TF_ProductId.getText()));
        p.setProductCode(Integer.parseInt(TF_ProductCode.getText()));
        p.setProductName(TF_ProductName.getText());
        p.setCostPrice(Double.parseDouble(TF_ProductCost.getText()));
        p.setSellingPrice(Double.parseDouble(TF_ProductSell.getText()));
        p.setBrand(TF_ProductBrand.getText());
        
        
        try {
            sp.delete(p.getProductId());
            updateTable();
            JOptionPane.showMessageDialog(null, " product deleted");
        } catch (SQLException ex) {
            System.out.println("the error is in update fxml");
            System.out.println(ex.getMessage());
        }
    }

    
    
    public void updateTable() {

        ProductDAO sp = new ProductDAO();
        Product p = new Product();
        
        try {
            Listproduct.addAll(sp.readALL());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
           col_productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
           col_productCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));
           col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
           col_productCostPrice.setCellValueFactory(new PropertyValueFactory<>("costPrice"));
           col_productSellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
           col_productBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
           
            //4- fill the table view with observablelist content
           TVProduct.setItems(Listproduct);

    }
    
    private void GetTableRowToTextField() {
        TVProduct.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
               Product prd = TVProduct.getItems().get(TVProduct.getSelectionModel().getSelectedIndex());
               TF_ProductId.setText(String.valueOf(prd.getProductId()));
               TF_ProductCode.setText(String.valueOf(prd.getProductCode()));
               TF_ProductName.setText(prd.getProductName());
               TF_ProductCost.setText(String.valueOf(prd.getCostPrice()));
               TF_ProductSell.setText(String.valueOf(prd.getSellingPrice()));
               TF_ProductBrand.setText(prd.getBrand());
            }
            
        });

    }
    
    private void Clear(ActionEvent event) {
        TF_ProductId.setText("");
        TF_ProductCode.setText("");
        TF_ProductName.setText("");
        TF_ProductCost.setText("");
        TF_ProductSell.setText("");
        TF_ProductBrand.setText("");
        TF_ProductId.requestFocus();
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
    private void toCostumer1(ActionEvent event)  throws Exception{
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/FXMLCustomer.fxml"));
            // get controller of FXMLCustomer
            FXMLCustomerController custController = loader.getController();
 
            Parent root= loader.load();
        
            Stage stage =(Stage) btnToCostumer1.getScene().getWindow(); 
            stage.setTitle("add customer");
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
}
