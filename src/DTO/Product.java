/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Elife-Beja-138
 */
public class Product {
    private int productId;
    private int productCode;
    private String productName;
    private double quantityInStock;
    private double quantityOrdered;
    private double costPrice;
    private double sellingPrice;
    private String brand;    

    public Product(int productCode, String productName, double quantityInStock, double quantityOrdered, double costPrice, double sellingPrice, String brand) {
        this.productCode = productCode;
        this.productName = productName;
        this.quantityInStock = quantityInStock;
        this.quantityOrdered = quantityOrdered;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.brand = brand;
    }

    public Product(int productId, int productCode, String productName, double quantityInStock, double quantityOrdered, double costPrice, double sellingPrice, String brand) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.quantityInStock = quantityInStock;
        this.quantityOrdered = quantityOrdered;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.brand = brand;
    }

    public Product() {
    }

    public double getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(double quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(double quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

   
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

   
}
