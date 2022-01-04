/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/FXMLHomepage.fxml"));            
//        try {
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("Page Personnels");
//            primaryStage.show();
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/FXMLLogIn.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
//     Parent root = FXMLLoader.load(getClass().getResource("../GUI/FXMLLogIn.fxml"));
//     Scene scene = new Scene(root);
//     stage.setScene(scene);
//     stage.show();    
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}


