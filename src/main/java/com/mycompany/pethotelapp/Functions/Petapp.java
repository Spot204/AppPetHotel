/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Functions;



import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class Petapp {
    private final static String url="jdbc:mysql://localhost:3306/apppethotel";
    private final static String use_name="root";
    private final static String password="";
    
    public void removePet(int id_pet) {
    home home = new home();
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(url, use_name, password);

        try (PreparedStatement disableFK = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0")) {
            disableFK.executeUpdate();
        }

        String queryRoom = "SELECT id_room FROM pet WHERE id_pet=?";
        try (PreparedStatement st = conn.prepareStatement(queryRoom)) {
            st.setInt(1, id_pet);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                home.setRoom(rs.getInt("id_room"), false);
            }
        }

        String queryService = "DELETE FROM service WHERE id_service IN (SELECT id_service FROM pet WHERE id_pet=?)";
        try (PreparedStatement st = conn.prepareStatement(queryService)) {
            st.setInt(1, id_pet);
            st.executeUpdate();
        }

        String queryPet = "DELETE FROM pet WHERE id_pet=?";
        try (PreparedStatement st = conn.prepareStatement(queryPet)) {
            st.setInt(1, id_pet);
            st.executeUpdate();
        }

        try (PreparedStatement enableFK = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 1")) {
            enableFK.executeUpdate();
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

    public void seleceOnePet(DefaultTableModel model,int id_pet){
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query = "SELECT pet.id_pet, pet.name_of_pet, customer.id_customer, customer.name_customer,room.roomnumber,pet.id_service "
                    + "FROM pet "
                    + "JOIN customer ON pet.id_customer = customer.id_customer "
                    + "JOIN room ON pet.id_room = room.id_room "
                    + "WHERE pet.id_pet = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_pet);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("id_pet"));
                v.add(rs.getString("name_of_pet"));
                v.add(rs.getInt("id_customer"));
                v.add(rs.getString("name_customer"));
                v.add(rs.getString("roomnumber"));
                v.add(rs.getInt("id_service"));
                model.addRow(v);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void selecePet(DefaultTableModel model){
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query = "SELECT pet.id_pet, pet.name_of_pet, customer.id_customer, customer.name_customer,room.roomnumber,pet.id_service "
                    + "FROM pet "
                    + "JOIN customer ON pet.id_customer = customer.id_customer "
                    + "JOIN room ON pet.id_room = room.id_room ";
                    
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("id_pet"));
                v.add(rs.getString("name_of_pet"));
                v.add(rs.getInt("id_customer"));
                v.add(rs.getString("name_customer"));
                v.add(rs.getString("roomnumber"));
                v.add(rs.getInt("id_service"));
                model.addRow(v);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    
}
