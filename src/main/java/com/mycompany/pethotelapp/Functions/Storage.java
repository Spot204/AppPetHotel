/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Functions;

import com.mycompany.pethotelapp.Projects.Warehouse;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class Storage {
    

    private final static String url = "jdbc:mysql://localhost:3306/apppethotel";
    private final static String user_name = "root";
    private final static String password = "";

    public int addProduct(Warehouse warehouse) {
        int newID= -1;
        try (Connection conn = DriverManager.getConnection(url, user_name, password)) {
            String query = "INSERT INTO storage (name_product, date_of_entry, status_product) VALUES (?, ?, ?)";
            java.util.Date utilCheckout = warehouse.getDate_of_entry();
            java.sql.Date date_of_entry = new java.sql.Date(utilCheckout.getTime());
            PreparedStatement st = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, warehouse.getName_product());
            st.setDate(2, date_of_entry);
            st.setString(3, warehouse.getStatus());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();// lấy id của sản phẩm mới lưu
            if(rs.next()){
                newID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return newID;
    }
    public void deleteProduct(int id_product) {
        try (Connection conn = DriverManager.getConnection(url, user_name, password)) {
            String query = "DELETE FROM warehouse WHERE id_product = ?";

            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_product);

            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("No product found with ID: " + id_product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error while deleting product: " + ex.getMessage());
        }
    }
    
    public void selectAllStorage(DefaultTableModel model){
        try{
            Connection conn = DriverManager.getConnection(url, user_name, password);
            String query = "SELECT * FROM storage";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("id_product"));
                v.add(rs.getString("name_product"));
                v.add(rs.getString("status_product"));
                v.add(rs.getString("date_of_entry"));
                model.addRow(v);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void removeStorage(int id_product){
        try{
            Connection conn = DriverManager.getConnection(url, user_name, password);
            String query = "DELETE FROM storage WHERE id_product = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_product);
            st.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void selectOneProduct(DefaultTableModel model, int id_product){
        try{
            Connection conn = DriverManager.getConnection(url, user_name, password);
            String query="SELECT * FROM storage WHERE id_product = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_product);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("id_product"));
                v.add(rs.getString("name_product"));
                v.add(rs.getString("status_product"));
                v.add(rs.getString("date_of_entry"));
                model.addRow(v);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}