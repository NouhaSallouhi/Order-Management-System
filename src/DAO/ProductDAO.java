/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DbConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author Elife-Beja-138
 */
public class ProductDAO implements Interface.IService<Product>{
    Connection cnx;

    public ProductDAO() {
        cnx = DbConnection.getInstance().getConnection();
    }
    

    @Override
    public void Add(Product p) throws SQLException {
        Statement stm = cnx.createStatement();

//INSERT INTO `product`(`productId`, `productCode`, `productName`, `brand`, `costPrice`, `sellingPrice`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])

        String query = "INSERT INTO `product`(`productId`, `productCode`, `productName`, `costPrice`, `sellingPrice`, `brand`) VALUES  ('" 
            + p.getProductId() +"','" 
            + p.getProductCode()+"', '" 
            + p.getProductName() + "','"
            + p.getCostPrice()  + "','" 
            + p.getSellingPrice() + "','"
            + p.getBrand() + "')";

        stm.executeUpdate(query);   
    }

    @Override
    public List<Product> readALL() throws SQLException {
         Statement stm = cnx.createStatement();
        ArrayList<Product> ProductList = new ArrayList<>();
        ResultSet rs = stm.executeQuery("select * from product");
        while(rs.next()){
            Product pro = new Product();
            
            pro.setProductId(rs.getInt("productId"));
            pro.setProductCode(rs.getInt("productCode"));
            pro.setProductName(rs.getString("productName"));
           
            pro.setCostPrice(rs.getDouble("costPrice"));
            pro.setSellingPrice(rs.getDouble("sellingPrice"));
            pro.setBrand(rs.getString("brand"));
            
            ProductList.add(pro);
        }
        
        return ProductList;       
    }

    @Override
    public void Update(Product p) throws SQLException {
         Statement stm = cnx.createStatement();
        
//         UPDATE `product` SET `productId`=[value-1],`productCode`=[value-2],`productName`=[value-3],`costPrice`=[value-4],`sellingPrice`=[value-5],`brand`=[value-6] WHERE 1
        String requet = "UPDATE `product` SET `productCode`='" + p.getProductCode() + "',"
                + "`productName`='" + p.getProductName()
                + "',`costPrice`='" + p.getCostPrice()
                + "',`sellingPrice`='" + p.getSellingPrice()
                + "',`brand`='" + p.getBrand()  + "' WHERE productId =" + p.getProductId();
        
        stm.executeUpdate(requet);
    }

    @Override
    public void delete(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "DELETE FROM `product` WHERE productId ='" + id + "' ";
        stm.executeUpdate(query);
    }

}
