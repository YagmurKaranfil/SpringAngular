package com.Project.SpringAngular.entity;

import jakarta.persistence.*;

@Entity
@Table(name="customer") // bir varlık sınıfının hangi veritabanı tablosuna karşılık geldiğini belirtiriz.
public class Customer {

    @Id
    @Column(name="customer_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)//bu anotasyon, bir varlığın veritabanına kaydedilirken kullanılan bir kimlik sütununun otomatik olarak oluşturulmasını belirtir.
    private int customerId;

    @Column(name="customer_name", length = 50)
    private String customerName;

    @Column(name="customer_address", length = 60)
    private String customerAddress;

    @Column(name="mobile", length = 12)
    private int mobile;

    public Customer(String customerName, String customerAddress, int mobile) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.mobile = mobile;
    }

    public Customer(int customerId, String customerName, String customerAddress, int mobile) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.mobile = mobile;
    }


    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
