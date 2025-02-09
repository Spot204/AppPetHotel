/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Projects;

/**
 *
 * @author ASUS
 */
public class Room {
    private int id_room;
    private boolean status;
    private String rank_room;
    private String roomnumber;
    
    public Room(int id_room, boolean status, String rank_room, String roomnumber){
        this.id_room=id_room;
        this.status=status;
        this.rank_room=rank_room;
        this.roomnumber=roomnumber;
    }
//    public void setID_room(int id_room){
//        this.id_room=id_room;
//    }
//    
//    public void setStatus(boolean status){
//        this.status=status;
//    }
//    
//    public void setRank_room(String rank_room){
//        this.rank_room=rank_room;
//    }
//    
//    public void setRoomnumber(String roomnumber){
//        this.roomnumber=roomnumber;
//    }
    
    public String getRank_room(){
        return rank_room;
    }
    
    public String getRoomnumber(){
        return roomnumber;
    }
    
    public int getID_room(){
        return id_room;
    }
    
    public boolean getStatus(){
        return status;
    }
}
