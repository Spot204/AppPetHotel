/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Projects;

/**
 *
 * @author ASUS
 */
public class Service {
    private int id_service;
    private boolean defult_service;
    private boolean catmong_service;
    private boolean tialong_service;
    private boolean doancaocap_service;
    private boolean tamrualamsach_service;
    private boolean tamnang_service;
    
    public Service(int id_service, boolean defult_service, boolean catmong_service, boolean tialong_service, boolean doancaocap_service, boolean tamrualamsach_service, boolean tamnang_service){
        this.id_service=id_service;
        this.defult_service=defult_service;
        this.catmong_service=catmong_service;
        this.tialong_service=tialong_service;
        this.doancaocap_service=doancaocap_service;
        this.tamrualamsach_service=tamrualamsach_service;
        this.tamnang_service=tamnang_service;
    }
    
    public int getID_service(){
        return id_service;
    }
    
    public boolean getDefult_service(){
        return defult_service;
    }
    
    public boolean getCatmong_service(){
        return catmong_service;
    }
    
    public boolean getTialong_service(){
        return tialong_service;
    }
    
    public boolean getDoancaocap(){
        return doancaocap_service;
    }
    
    public boolean getTamrualamsach_service(){
        return tamrualamsach_service;
    }
    
    public boolean getTamnang_service(){
        return tamnang_service;
    }
}
