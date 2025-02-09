/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Projects;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Customer {
    private int id_customer;
    private String name_customer;
    private String phonenumber;
    private String address;
    private Date checkin;
    private Date checkout;
    
    public Customer(int id_customer, String name_customer, String phonenumber, String address, Date checkin, Date checkout){
        this.id_customer=id_customer;
        this.name_customer=name_customer;
        this.phonenumber=phonenumber;
        this.address=address; 
        this.checkin=checkin;
        this.checkout=checkout;   
    }
    
    public int getID(){
        return id_customer;
    }
    
    public String getName_customer(){
        return name_customer;
    }
    
    public String getPhonenumber(){
        return phonenumber;
    }
    public String getAddress(){
        return address;
    }
    public Date getCheckin(){
        return checkin;
    }
    public Date getCheckout(){
        return checkout;
    }
}


