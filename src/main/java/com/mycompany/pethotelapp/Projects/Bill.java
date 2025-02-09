/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Projects;

/**
 *
 * @author ASUS
 */
public class Bill {
    private int id_bill;
    private int id_customer;
    private String name_customer;
    private String email_customer;
    private String description;

    public Bill(int id_bill, int id_customer, String name_customer, String email_customer, String description) {
        this.id_bill = id_bill;
        this.id_customer = id_customer;
        this.name_customer = name_customer;
        this.email_customer = email_customer;
        this.description = description;
    }

    
    public void setDescription(String description){
        this.description=description;
    }
    public int getID_Bill(){
        return id_bill;
    }
    public int getID_Customer(){
        return id_customer;
    }
    public String getName_Customer(){
        return name_customer;
    }         
    public String getEmail_customer(){
        return email_customer;
    }
    public String getDescription(){
        return description;
    }
}
