/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.mongodb;

/**
 *
 * @author flysy
 */
public class InsertTest {
    public static void main(String[] args) throws InterruptedException {
        int num = 20;
        String code = "abc";
        String name = "石永强";
        String password = "cde";

        for (int i = 0; i < num; i++) {
            new BulkInsertThread(code,name,password).start();
        }
        
         long start = System.currentTimeMillis();
        long end;
        while(true){
            Thread.sleep(1000);
            end = System.currentTimeMillis();
            if((end-start)>100*1000){
                System.exit(0);
            }
        }
    }
}
