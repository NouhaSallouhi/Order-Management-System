/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Customer;
import DTO.Order;
import DTO.Product;
import DTO.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DbConnection;

/**
 *
 * @author Elife-Beja-138
 */
public class OrderDAO implements Interface.OrderInterface<Order>{
    Connection cnx;

    public OrderDAO() {
        cnx = DbConnection.getInstance().getConnection();
    }
    
    @Override
    public List<Order> readALL() throws SQLException {
        Statement stm = cnx.createStatement();
        ArrayList<Order> OrderList = new ArrayList<>();
        ResultSet rs = stm.executeQuery("SELECT prodId, quantityOrder, sellingPrice, quantityOrder*sellingPrice AS totalPrice , oderId ,custId , productName,brand , employeeName,soldBy FROM orderdetails JOIN orders as o ON o.orderId =`orderId` JOIN product as p ON p.productId =`prodId`JOIN users ORDER BY oderId");
        while (rs.next()) {
            Order ord =new Order();
            
            ord.setProdId(rs.getInt("prodId"));
            ord.setQuantityOrder(rs.getInt("quantityOrder"));
            ord.setTotalPrice(rs.getInt("totalPrice"));
            ord.setOrderId(rs.getInt("oderId"));
            ord.setCustomerId(rs.getInt("custId"));
            ord.setProductName(rs.getString("productName"));
            ord.setBrand(rs.getString("brand"));
            ord.setEmployeeName(rs.getString("employeeName"));
            ord.setSoldBy(rs.getString("soldBy"));
            
            OrderList.add(ord);
        }
        return OrderList;    
    }
    
    

    @Override
    public List<Order> readALLdetail() throws SQLException {
        Statement stm = cnx.createStatement();
        ArrayList<Order> OrderDetailList = new ArrayList<>();
        ResultSet rs = stm.executeQuery("SELECT oderId, custId, soldby, SUM(quantityOrder*sellingPrice) as cost FROM orderdetails INNER JOIN orders as o ON o.custId =`custId` INNER JOIN product as p ON p.productId =prodId GROUP BY oderId");
        while (rs.next()) {
            Order ord =new Order();
            
            ord.setOrderId(rs.getInt("oderId"));
            ord.setCustomerId(rs.getInt("custId"));
            ord.setSoldBy(rs.getString("soldBy"));
            ord.setTotalCost(rs.getInt("cost"));
            
            OrderDetailList.add(ord);
        }
        return OrderDetailList;    
    }


   
}
