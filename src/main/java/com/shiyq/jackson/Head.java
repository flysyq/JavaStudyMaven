/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.jackson;

/**
 *
 * @author admin
 */
public class Head {
    public String userCode;
    public String userPassword;
    public String parkId;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public Head(String userCode, String userPassword, String parkId) {
        this.userCode = userCode;
        this.userPassword = userPassword;
        this.parkId = parkId;
    }
    
    public Head(){
        
    }
    
}
