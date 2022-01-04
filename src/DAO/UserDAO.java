/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DbConnection;

/**
 *
 * @author Elife-Beja-138
 */
public class UserDAO implements Interface.UserInteface<User>{
    Connection cnx;

    public UserDAO() {
        cnx = DbConnection.getInstance().getConnection();
    }

    @Override
    public void AddUser(User u) throws SQLException {
           Statement stm = cnx.createStatement();
        String query = "INSERT INTO `users`(`userId`, `userName`, `password`)"
                + " VALUES ( '"+ u.getUsername()+"' ,'"+ u.getPassword()+"')";  
        
        stm.executeUpdate(query);
    }

    @Override
    public List<User> readALLusers(User u) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "SELECT `userName`, `password` FROM `users` WHERE userName='"+u.getUsername()+"'and password='"+u.getPassword()+ "' ";
        ResultSet rs = stm.executeQuery(query);
        
        ObservableList <User> usersList = FXCollections.observableArrayList();
        
        while(rs.next()){
        User usr = new User();
        
        usersList.add(new User(rs.getString("userName"), rs.getString("password")));
        }
        for (User obj : usersList )
        {
            System.out.println("userName"+obj.getUsername());
            System.out.println("pwd"+obj.getPassword());
        }
        return usersList;
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "DELETE FROM `users` WHERE userId ='" + id + "' ";
        stm.executeUpdate(query);
    }

   
    
}
