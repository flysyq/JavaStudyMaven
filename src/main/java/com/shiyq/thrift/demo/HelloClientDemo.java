-/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.thrift.demo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author shiyq
 */
public class HelloClientDemo {

    //public static final String SERVER_IP = "192.168.0.112";
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8090;
    public static final int TIMEOUT = 1000;

    public void startClient(String userName) {
        TTransport transport = null;

        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            //transport = new TFramedTransport(new TSocket(SERVER_IP,SERVER_PORT, TIMEOUT));
            TProtocol protocol = new TBinaryProtocol(transport);
            //TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();
            String result = client.sayHello(userName);
            System.out.println("Thrify client result =: " + result);
            int i=10;
            System.out.println("i++="+client.add(i));
        } catch (TTransportException ex) {
            Logger.getLogger(HelloClientDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TException ex) {
            Logger.getLogger(HelloClientDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HelloClientDemo client = new HelloClientDemo();
        final long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Thread.sleep(1);
            client.startClient("石永强" + i);
            System.out.println("i=" + i);
        }
        final long endTime = System.nanoTime();
        System.out.println("method 1 : " + (endTime - startTime));
    }
}
