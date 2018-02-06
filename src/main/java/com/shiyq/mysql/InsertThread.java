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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flysy
 */
public class InsertThread extends Thread{
    
    private String sql;

    public InsertThread(String sql) {
        this.sql = sql;
    }

    @Override
    public void run() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
               try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/study?userSSL=false&"
                    + "user=root&password=123456");
            stmt = conn.createStatement();
            int i = 0;
            while (true) {
                stmt.executeUpdate(sql);
                i++;
                if (i % 10000 == 0) {
                    System.out.println(new Date());
                }
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(InsertThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }

    }
    
    
}
