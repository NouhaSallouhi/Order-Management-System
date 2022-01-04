/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author hp
 */
public class Customer {
    private int customerId;
    private String customerCode;
    private String fullName;
    private String phone;
    private String location;

    public Customer() {
    }

    
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerCode=" + customerCode + ", fullName=" + fullName + ", phone=" + phone + ", location=" + location + '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Customer(String customerCode, String fullName, String phone, String location) {
        this.customerCode = customerCode;
        this.fullName = fullName;
        this.phone = phone;
        this.location = location;
    }

    public Customer(int customerId, String customerCode, String fullName, String phone, String location) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.fullName = fullName;
        this.phone = phone;
        this.location = location;
    }
    
}
