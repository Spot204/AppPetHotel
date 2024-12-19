/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoiTuong;

/**
 *
 * @author ASUS
 */
public class Customer {
    private int id_customer;
    private String name_customer;
    private String phonenumber;
    private String address;
    
    public Customer(int id_customer, String name_customer, String phonenumber, String address){
        this.id_customer=id_customer;
        this.name_customer=name_customer;
        this.phonenumber=phonenumber;
        this.address=address;
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
}


