/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Functions;

/**
 *
 * @author ASUS
 */
import com.mycompany.pethotelapp.Projects.Bill;

import java.sql.*;

public class Payment {
    private final static String url="jdbc:mysql://localhost:3306/apppethotel";
    private final static String use_name="root";
    private final static String password="";
    
    public void PaymentCustomer(Bill bill){
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query = "INSERT INTO bill (id_customer,name_customer,email_customer,description) VALUES (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, bill.getID_Customer());
            st.setString(2, bill.getName_Customer());
            st.setString(3, bill.getEmail_customer());
            st.setString(4, bill.getDescription());
            st.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
