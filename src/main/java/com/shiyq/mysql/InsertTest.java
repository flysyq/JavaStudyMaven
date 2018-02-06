/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author flysy
 */
public class InsertTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int num = 20;
        String sql = "insert into s_user(code,name,password,create_date) values('abc','石永强','cde',now())";

        for (int i = 0; i < num; i++) {
            new InsertThread(sql).start();
        }
    }
}
