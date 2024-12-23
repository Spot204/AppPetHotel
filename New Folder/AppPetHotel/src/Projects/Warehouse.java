/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

import java.sql.Date;
/**
 *
 * @author ASUS
 */
public class Warehouse {
    private int id_product;
    private String name_product;
    private Date date_of_entry;
    private Boolean status;
    
    public Warehouse(int id_product, String name_product, Date date_of_entry, boolean status){
        this.id_product=id_product;
        this.name_product=name_product;
        this.date_of_entry=date_of_entry;
        this.status=status;
    }
    
    public int getID_product(){
        return id_product;
    }
    
    public String getName_product(){
        return name_product;
    }
    
    public Date getDate_of_entry(){
        return date_of_entry;
    }
    
    public Boolean getStatus(){
        return status;
    }
}
