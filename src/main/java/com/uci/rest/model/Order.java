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
public class Order {
    
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
    private String orderinfo;
    private String shippingaddress;
    private String city;
    private String state;
    private String zipcode;
    private String shippingmethod;
    private String ccnumber;
    
    
    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }
    
    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getfirstname() {
        return firstname;
    }
    
    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getlastname() {
        return lastname;
    }
    
    public void setemail(String email) {
        this.email = email;
    }

    public String getemail() {
        return email;
    }
    
    public void setphonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getphonenumber() {
        return phonenumber;
    }
    
    public void setorderinfo(String orderinfo) {
        this.orderinfo = orderinfo;
    }

    public String getorderinfo() {
        return orderinfo;
    }
    
    public void setshippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    public String getshippingaddress() {
        return shippingaddress;
    }
    
    public void setcity(String city) {
        this.city = city;
    }

    public String getcity() {
        return city;
    }
    
    public void setstate(String state) {
        this.state = state;
    }

    public String getstate() {
        return state;
    }
    
    public void setzipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getzipcode() {
        return zipcode;
    }
    
    public void setshippingmethod(String shippingmethod) {
        this.shippingmethod = shippingmethod;
    }

    public String getshippingmethod() {
        return shippingmethod;
    }
    
    public void setccnumber(String ccnumber) {
        this.ccnumber = ccnumber;
    }

    public String getccnumber() {
        return ccnumber;
    }
}
