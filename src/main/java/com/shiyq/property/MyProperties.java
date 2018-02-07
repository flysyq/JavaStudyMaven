/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.property;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flysy
 */
public class MyProperties {
    static Properties props = new Properties();
    static{
        try {
            props.load(MyProperties.class.getClassLoader().getResourceAsStream("./config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(MyProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String get(String key){
        return props.getProperty(key);
    }
    
     public static void main(String[] args) throws FileNotFoundException, IOException {
        
        System.out.println("postgresql.url="+get("postgresql.url"));
    }
}
