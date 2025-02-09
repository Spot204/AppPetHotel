/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Functions;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.text.SimpleDateFormat;

import com.mycompany.pethotelapp.Functions.Petapp;




/**
 *
 * @author ASUS
 */
public class Customerapp {
    private final static String url="jdbc:mysql://localhost:3306/apppethotel";
    private final static String use_name="root";
    private final static String password="";
    public void selectCustomer(DefaultTableModel model){  
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query="SELECT * FROM customer";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Vector v = new Vector();
                v.add(String.valueOf(rs.getInt("id_customer")));
                v.add(rs.getString("name_customer"));
                v.add(rs.getString("phonenumber"));
                v.add(rs.getString("address"));
                SimpleDateFormat fmcheckin = new SimpleDateFormat("dd/MM/yyyy");
                v.add(fmcheckin.format(rs.getDate("checkin")));
                SimpleDateFormat fmcheckout = new SimpleDateFormat("dd/MM/yyyy");
                v.add(fmcheckout.format(rs.getDate("checkout")));
                model.addRow(v);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void selectOneCustomer(DefaultTableModel model, String id){
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query = "SELECT * FROM customer WHERE id_customer = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(String.valueOf(rs.getInt("id_customer")));
                v.add(rs.getString("name_customer"));
                v.add(rs.getString("phonenumber"));
                v.add(rs.getString("address"));
                SimpleDateFormat fmcheckin = new SimpleDateFormat("dd/MM/yyyy");
                v.add(fmcheckin.format(rs.getDate("checkin")));
                SimpleDateFormat fmcheckout = new SimpleDateFormat("dd/MM/yyyy");
                v.add(fmcheckout.format(rs.getDate("checkout")));
                model.addRow(v);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    public void deleteCustomer(String id) {
    Connection conn = null;
    Petapp petapp = new Petapp();
    try {
        conn = DriverManager.getConnection(url, use_name, password);

        String queryPets = "SELECT id_pet FROM pet WHERE id_customer = ?";
        try (PreparedStatement st = conn.prepareStatement(queryPets)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_pet = rs.getInt("id_pet");
                
                petapp.removePet(id_pet);
            }
        }

       
        String queryCustomer = "DELETE FROM customer WHERE id_customer = ?";
        try (PreparedStatement st = conn.prepareStatement(queryCustomer)) {
            st.setString(1, id);
            st.executeUpdate();
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
} 
}
