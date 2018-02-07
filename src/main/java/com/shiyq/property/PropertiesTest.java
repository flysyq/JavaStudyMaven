/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author flysy
 */
public class PropertiesTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        System.out.println("postgresql.url="+MyProperties.get("postgresql.url"));
    }
}
