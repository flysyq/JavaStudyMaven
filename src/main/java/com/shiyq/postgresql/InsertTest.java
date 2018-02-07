/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.postgresql;


/**
 *
 * @author flysy
 */
public class InsertTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
        int num = 20;
        String sql = buildSQL(1000);
        for (int i = 0; i < num; i++) {
            new InsertThread(sql).start();
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
    
     public static String buildSQL(int i){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into s_user(code,name,password,create_date) values");
        int j = 0;
        while (j++ < i) {
            sqlBuilder.append("('abc','石永强','cde',now()),");
        }
        String sql = sqlBuilder.substring(0,sqlBuilder.lastIndexOf(","));
        return sql;
    }
}
