/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uci.rest.model;

/**
 *
 * @author omkar
 */
public class Cart {
    private String id;
    private String sessionID;
    private String make;
    private String model;
    
    public void setID(String id) {
        this.id = id;
    }

    public String getid() {
        return id;
    }
    
    public void setsessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getsessionID() {
        return sessionID;
    }
    
    public void setmake(String make) {
       
        this.make =  make;
    }

    public String getmake() {
       
        return make;
    }
    
    public void setmodel(String model) {
        
        this.model = model;
    }

    public String getmodel() {
        
        return model;
    }
    
    
}
