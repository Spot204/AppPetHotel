/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoiTuong;

/**
 *
 * @author ASUS
 */
public class Employee {
    private int id_employee;
    private String name_employee;
    private String phonenumber;
    private String address;
    private String cccd;
    
    public Employee(int id_employee, String name_employee, String phonenumber, String address, String cccd) {
        this.id_employee = id_employee;
        this.name_employee = name_employee;
        this.phonenumber = phonenumber;
        this.address = address;
        this.cccd = cccd;
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
    
    public String getCCCD() {
        return cccd;
    }
}
