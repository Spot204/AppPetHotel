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
public class Employee {
    private int id_employee;
    private String name_employee;
    private String phonenumber;
    private String address;
    private String email;
    private Date start;
    private Date date_of_birth;
    
    
    public Employee(int id_employee, String name_employee, String phonenumber, String address, String email, Date start, Date date_of_birth) {
        this.id_employee = id_employee;
        this.name_employee = name_employee;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.start=start;
        this.date_of_birth=date_of_birth;
    }
    
    public int getID_employee() {
        return id_employee;
    }
    
    public String getName_employee() {
        return name_employee;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Date getStart(){
        return start;
    }
    
    public Date getDate_of_birth(){
        return date_of_birth;
    }
}
