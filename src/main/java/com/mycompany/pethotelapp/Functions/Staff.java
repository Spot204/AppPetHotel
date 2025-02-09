/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Functions;
import com.mycompany.pethotelapp.Projects.Employee;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class Staff {
    private final static String url="jdbc:mysql://localhost:3306/apppethotel";
    private final static String use_name="root";
    private final static String password="";
    
    public int addStaff(Employee employee){
        int newID=-1;
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query="INSERT INTO employee (name_employee, phonenumber, address, date_of_birth, email, start_date) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement st = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);//lấy id của nhân viên đầu tiên khi lưu
            
            java.util.Date utildate_of_birth=employee.getDate_of_birth();
            java.sql.Date date_of_birth=new java.sql.Date(utildate_of_birth.getTime());
            java.util.Date utilstart_date=employee.getStart();
            java.sql.Date start_date=new java.sql.Date(utilstart_date.getTime());
            st.setString(1, employee.getName_employee());
            st.setString(2, employee.getPhonenumber());
            st.setString(3, employee.getAddress());
            st.setDate(4, date_of_birth);
            st.setString(5, employee.getEmail());
            st.setDate(6, start_date);
            st.executeUpdate();
            
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                newID = rs.getInt(1);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            }
        return newID;
        }

    public void deleteStaff(int id_employee) {
        try {
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query = "DELETE FROM employee WHERE id_employee = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_employee);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void selectAllStaff(DefaultTableModel model) {
        try {
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query = "SELECT * FROM employee";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id_employee"),
                    rs.getString("name_employee"),
                    rs.getString("phonenumber"),
                    rs.getString("address"),
                    rs.getDate("date_of_birth"),
                    rs.getString("email"),
                    rs.getDate("start_date")
                };
                model.addRow(row);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStaff(DefaultTableModel model, String text) {
        try {
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query = "SELECT * FROM employee WHERE name_employee LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, text);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id_employee"),
                    rs.getString("name_employee"),
                    rs.getString("phonenumber"),
                    rs.getString("address"),
                    rs.getDate("date_of_birth"),
                    rs.getString("email"),
                    rs.getDate("start_date")
                };
                model.addRow(row);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

