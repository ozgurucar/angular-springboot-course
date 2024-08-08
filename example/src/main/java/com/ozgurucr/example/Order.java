package com.ozgurucr.example;

public class Order {
    private String customerName;

    private String productName;

    private int quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInfo() {
        return this.customerName + " " + this.productName + " " + this.quantity;
    }
}
