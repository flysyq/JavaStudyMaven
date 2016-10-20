/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.thrift.demo;

import org.apache.thrift.TException;

/**
 *
 * @author shiyq
 */
public class HelloWorldImpl implements HelloWorldService.Iface{

    public HelloWorldImpl(){
        
    }
    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome to my blog www.shiyq.com";
    }

    @Override
    public int add(int i) throws TException {
        return ++i;
    }
    
}
