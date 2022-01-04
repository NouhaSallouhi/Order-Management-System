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
public class Order {

    private int orderId, prodId;
    private int customerId;
    //private int userId;
    private double quantityOrder,totalPrice, sellingPrice, totalCost;
    private String date, productName, brand, employeeName, soldBy;

    public Order(int prodId, int customerId, double quantityOrder, double totalPrice, double sellingPrice, double totalCost, String date, String productName, String brand, String employeeName, String soldBy) {
        this.prodId = prodId;
        this.customerId = customerId;
        this.quantityOrder = quantityOrder;
        this.totalPrice = totalPrice;
        this.sellingPrice = sellingPrice;
        this.totalCost = totalCost;
        this.date = date;
        this.productName = productName;
        this.brand = brand;
        this.employeeName = employeeName;
        this.soldBy = soldBy;
    }

    public Order() {
    }

    public Order(int orderId, int prodId, int customerId, double quantityOrder, double totalPrice, double sellingPrice, double totalCost, String date, String productName, String brand, String employeeName, String soldBy) {
        this.orderId = orderId;
        this.prodId = prodId;
        this.customerId = customerId;
        this.quantityOrder = quantityOrder;
        this.totalPrice = totalPrice;
        this.sellingPrice = sellingPrice;
        this.totalCost = totalCost;
        this.date = date;
        this.productName = productName;
        this.brand = brand;
        this.employeeName = employeeName;
        this.soldBy = soldBy;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    

    

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(double quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", prodId=" + prodId + ", customerId=" + customerId + ", quantityOrder=" + quantityOrder + ", date=" + date + ", productName=" + productName + ", brand=" + brand + ", employeeName=" + employeeName + ", soldBy=" + soldBy + '}';
    }

}
