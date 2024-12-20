/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoiTuong;

/**
 *
 * @author ASUS
 */
public class Room {
    private int id_room;
    
    private boolean status;
    
    public Room(int id_room, boolean status){
        this.id_room=id_room;
        this.status=status;
    }
    
    public int getID_room(){
        return id_room;
    }
    
    public boolean getStatus(){
        return status;
    }
}
