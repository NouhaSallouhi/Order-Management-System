/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class DbConnection {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    
    final static String URL = "jdbc:mysql://localhost:3306/ordermsdb";
    final static String LOGIN = "root";
    final static String PWD = "";
    static DbConnection instance = null;
    private Connection cnx;
    private DbConnection() {
        
        try {
            cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("--Connection established--");
        } catch (SQLException e) {
            System.out.println("--Connection failed--");
            System.out.println(e.getMessage());    
      

        }
    }

  public static DbConnection getInstance() {
        if (instance == null)
        {
            instance = new DbConnection();
        }
        return instance;
    }
    public  Connection getConnection(){
        return cnx;
    }
}





