 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Functions;

/**
 *
 * @author ASUS
 */
import java.sql.*;
import com.mycompany.pethotelapp.Projects.Customer;
import com.mycompany.pethotelapp.Projects.Pet;
import com.mycompany.pethotelapp.Projects.Room;
import com.mycompany.pethotelapp.Projects.Service;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;



public class home {
    private final static String url="jdbc:mysql://localhost:3306/apppethotel";
    private final static String use_name="root";
    private final static String password="";
    
    
    public int addCustomer(Customer customer){
        int newID=-1;
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query="INSERT INTO customer (name_customer, phonenumber, address,checkin, checkout) VALUES (?,?,?,?,?)";
            java.util.Date utilCheckout = customer.getCheckout();
            java.sql.Date checkout = new java.sql.Date(utilCheckout.getTime());
            java.util.Date utilCheckin = customer.getCheckin();
            java.sql.Date checkin = new java.sql.Date(utilCheckin.getTime());
            PreparedStatement st = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, customer.getName_customer());
            st.setString(2, customer.getPhonenumber());
            st.setString(3, customer.getAddress());
            st.setDate(4, checkin);
            st.setDate(5, checkout);
            
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                newID = rs.getInt(1);
            }
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return newID;
    }
        
    public int addService(Service service){
        int newID=-1;
        
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            
            String queryservice="INSERT INTO service (default_service, catmong_service, tialong_service, doancaocap_service, tamrualamsach_service, tamnang_service) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement stservice = conn.prepareStatement(queryservice,PreparedStatement.RETURN_GENERATED_KEYS);
            stservice.setBoolean(1, service.getDefult_service());
            stservice.setBoolean(2, service.getCatmong_service());
            stservice.setBoolean(3, service.getTialong_service());
            stservice.setBoolean(4, service.getDoancaocap());
            stservice.setBoolean(5, service.getTamrualamsach_service());
            stservice.setBoolean(6, service.getTamnang_service());
            stservice.executeUpdate();
            ResultSet rs = stservice.getGeneratedKeys();
            if(rs.next()){
                newID=rs.getInt(1);   
            }
            
            stservice.close();
        }catch(SQLException ex){
            ex.printStackTrace();    
        }
        return newID;
    }

    public Room showRoom(Room room, String rank_room){
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            
            String queryroom="SELECT id_room, status_room, rank_room, roomnumber FROM room WHERE rank_room = ? AND status_room = FALSE";
            
            PreparedStatement tsroom = conn.prepareStatement(queryroom);
            tsroom.setString(1, rank_room);
            ResultSet rsroom = tsroom.executeQuery();
            if(rsroom.next()){
                int id_room= rsroom.getInt("id_room");
                boolean status_room = rsroom.getBoolean("status_room");
                String rank_rooms = rsroom.getString("rank_room");
                String roomnumber = rsroom.getString("roomnumber");
                room = new Room(id_room, status_room, rank_rooms, roomnumber);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return room;
    }
    public void setRoom(int id_room, boolean status_room){
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
        
            String updateQuery="UPDATE room SET status_room = ? WHERE id_room = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            
            updateStmt.setBoolean(1, status_room);
            updateStmt.setInt(2, id_room);
            
            updateStmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public int addPet(Pet pet){
        int newID=-1;
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            
            String querypet="INSERT INTO pet (id_room, id_customer, id_service, generic, identification, name_of_pet) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement st = conn.prepareStatement(querypet,PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, pet.getID_room());
            st.setInt(2, pet.getID_customer());
            st.setInt(3, pet.getID_service());
            st.setString(4, pet.getGeneric());
            st.setString(5, pet.getIdentification());
            st.setString(6, pet.getName_pet());
            
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                newID=rs.getInt(1);   
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return newID;
    }
    public String selectCustomer(DefaultTableModel model, String id_customerselect){
        String newName="";
        try{
            Connection conn = DriverManager.getConnection(url, use_name, password);
            String query = "SELECT pet.id_pet, pet.name_of_pet, customer.name_customer, room.rank_room, "
             + "service.default_service, service.catmong_service, service.tialong_service, "
             + "service.doancaocap_service, service.tamrualamsach_service, service.tamnang_service "
             + "FROM pet "
             + "JOIN customer ON pet.id_customer = customer.id_customer "
             + "JOIN room ON pet.id_room = room.id_room "
             + "JOIN service ON pet.id_service = service.id_service "
             + "WHERE pet.id_customer = ?";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id_customerselect);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {  
                newName = rs.getString("name_customer");

                do {
                    float sum = 0;
                    if(rs.getBoolean("default_service")) {
                        sum += 100000;
                    }
                    if(rs.getBoolean("catmong_service")) {
                        sum += 50000;
                    }
                    if(rs.getBoolean("tialong_service")) {
                        sum += 50000;
                    }
                    if(rs.getBoolean("doancaocap_service")) {
                        sum += 50000;
                    }
                    if(rs.getBoolean("tamrualamsach_service")) {
                        sum += 100000;
                    }
                    if(rs.getBoolean("tamnang_service")) {
                        sum += 30000;
                    }
                    if("normal".equals(rs.getString("rank_room"))) {
                        sum += 30000;
                    } else {
                        sum += 60000;
                    }
                    Vector v = new Vector();
                    v.add(rs.getInt("id_pet"));
                    v.add(rs.getString("name_of_pet"));
                    v.add(sum);
                    model.addRow(v);
                } while (rs.next());
            }
            return newName;
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        return null;
        }   
}
