/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoiTuong;

/**
 *
 * @author ASUS
 */
public class Pet {
    private int id_pet;
    private int id_customer;
    private int id_room;
    private int id_service;
    private String name_pet;
    private String note;
    
    public Pet(int id_pet, int id_customer, int id_room, int id_service, String name_pet, String note){
        this.id_pet=id_pet;
        this.id_customer=id_customer;
        this.id_room=id_room;
        this.id_service=id_service;
        this.name_pet=name_pet;
        this.note=note;
    }
    
    public int getID_pet(){
        return id_pet;
    }
    
    public int getID_customer(){
        return id_customer;
    }
    
    public int getID_room(){
        return id_room;
    }
    
    public int getID_service(){
        return id_service;
    }
    
    public String getName_pet(){
        return name_pet;
    }
    
    public String getNote(){
        return note;
    }
}
