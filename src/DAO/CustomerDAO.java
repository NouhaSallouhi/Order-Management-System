/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DbConnection;

/**
 *
 * @author hp
 */
public class CustomerDAO implements Interface.IService<Customer>{
    Connection cnx;

    public CustomerDAO() {
        cnx = DbConnection.getInstance().getConnection();
    }
    
    @Override
    public void Add(Customer c) throws SQLException {
                Statement stm = cnx.createStatement();
        String query = "INSERT INTO `customer` (`customerCode`, `customerName`, `customerPhone`, `customerLocation`) VALUES ('" 
            + c.getCustomerCode() +"','" 
            + c.getFullName()+"', '" 
            + c.getPhone() + "','" 
            + c.getLocation() + "')";

        stm.executeUpdate(query);   
    }
    
    @Override
    public List<Customer> readALL() throws SQLException {
         Statement stm = cnx.createStatement();
        ArrayList<Customer> CustomerList = new ArrayList<>();
        ResultSet rs = stm.executeQuery("select * from customer");
        while (rs.next()) {
            Customer cust = new Customer();
            
            cust.setCustomerId(rs.getInt("customerId"));
            cust.setCustomerCode(rs.getString("customerCode"));
            cust.setFullName(rs.getString("customerName"));
            cust.setPhone(rs.getString("customerPhone"));
            cust.setLocation(rs.getString("customerLocation"));
            

            CustomerList.add(cust);
        }
        return CustomerList;       
    }

    @Override
        public void Update(Customer c) throws SQLException {
             Statement stm = cnx.createStatement();
        
        String requet = "UPDATE `customer` SET `customerCode`='" + c.getCustomerCode() + "',"
                + "`customerName`='" + c.getFullName()
                + "',`customerPhone`='" + c.getPhone() 
                + "',`customerLocation`='" + c.getLocation()   + "' WHERE customerId =" + c.getCustomerId();
        
        stm.executeUpdate(requet);
        }
        
        @Override
    public void delete(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "DELETE FROM `customer` WHERE customerId ='" + id + "' ";
        stm.executeUpdate(query);
    }
}
