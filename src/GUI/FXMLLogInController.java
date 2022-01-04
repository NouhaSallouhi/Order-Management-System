/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.UserDAO;
import DTO.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.DbConnection;

/**
 * FXML Controller class
 *
 * @author Elife-Beja-138
 */
public class FXMLLogInController implements Initializable {

    @FXML
    private Button btnCancel;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField TF_pwd;
    
    @FXML
    private TextField TF_Login;
    
    ObservableList<User> userList = FXCollections.observableArrayList();
  Connection cnx;
   Statement  ste;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancel(ActionEvent event) {
        TF_Login.setText("");
        TF_pwd.setText("");
        TF_Login.requestFocus();
    }

    @FXML
    private void login(ActionEvent event) {
         try {
        cnx = DbConnection.getInstance().getConnection();     
      ste = cnx.createStatement();

        String query = "SELECT * FROM `users` WHERE `userName`='"+TF_Login.getText()+"' and `password`='"+TF_pwd.getText()+"' ";

//            ste.set(1, TF_Login.getText());
//            ste.(2, TF_pwd.getText());
            
           
             ResultSet rs = ste.executeQuery(query);
            if (rs.next()) {
            //    JOptionPane.showMessageDialog(null, txtf_nom_utilisateur.getText()+" a ete connecté avec succes");
               
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHomepage.fxml"));
                            FXMLHomepageController de = loader.getController();
                            Parent root = loader.load();
                            Stage window = (Stage) btnLogin.getScene().getWindow();
                            window.setTitle("Home page");
                            window.setScene(new Scene(root));
                            //de.recupererNomAdministrateur(TF_Login.getText());
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "page introuvable");
                        }
                    }
                 
             
            else {
                JOptionPane.showMessageDialog(null, "nom d'utilisateur ou mot de passe incorrecte");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        
        }
    }
        
//        try {
       //     userList.addAll(su.readALLusers());
//            
//            for (User obj :listuser){
//            
//            log=obj.getLogin();
//            pass=obj.getPwd();
//            cat=obj.getCategorie();
//            }
//            
//            System.out.println("login"+log);
//            System.out.println("password"+pass);
//            System.out.println("categorie"+cat);
//            
//            if (lg.getText().equals(log)&&(pswd.getText().equals(pass))){
//          try {
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAccueil.fxml"));
//                    Parent root = loader.load();
//                    FXMLAccueilController dc = loader.getController();
//                   dc.verifierUtilisateur(cat);
//                    Stage stage = (Stage) cnx.getScene().getWindow();
//                    stage.setScene(new Scene(root));
//                    stage.setTitle("Page Acueil");
//                } catch (IOException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }else
//                JOptionPane.showMessageDialog(null, "login ou password fauts");   
//        } catch (SQLException ex) {
////            System.out.println(ex.getMessage());
 //       }
    }
    
