/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class JacksonTest {
    public static void main(String[] args) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        Head head = new Head("shiyq","123456","0001");
        Body body = new Body("red",180);
        
        All all = new All(head,body);
        
        String allString = mapper.writeValueAsString(all);
        System.out.println(allString);
        
        allString = allString.replace("123456", "654321");
        allString = allString.replace("red", "blue");
        
        System.out.println(allString);
        
        Head head1 =  mapper.readValue(mapper.writeValueAsString(head), Head.class);
        
        System.out.println(head1.getUserPassword());
        System.out.println(head1.getUserCode());
        
        All all1 = mapper.readValue(allString, All.class);
        
        System.out.println(all1.getBody().getColor());
        System.out.println(all1.getHead().getUserPassword());
        
        
    }
}
