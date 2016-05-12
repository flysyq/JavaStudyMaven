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
public class Body {
    private String color;
    private Integer height;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Body(String color, Integer height) {
        this.color = color;
        this.height = height;
    }
    
    public Body(){
        
    }
    
}
