/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.mybatis;

import com.shiyq.mybatis.config.User;
import com.shiyq.mybatis.config.UserDao;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author shiyq
 */
public class MybatisMain {
    public static void main(String args[])throws Exception
    {
        String user_name = "shiyq"+String.valueOf(Math.random()*100000).substring(0,3);
        String resource = "com/shiyq/mybatis/mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        
        try (SqlSession session = factory.openSession()) {
            UserDao userDao = session.getMapper(UserDao.class);
            
            User user = new User();
            user.setUser_name(user_name);
            user.setPassword("stone123");
            user.setComment("备注");
            
            userDao.insert(user);
            System.out.println("记录条数："+userDao.countAll());
            
            List<User> users = userDao.selectAll();
            Iterator<User> iter = users.iterator();
            
            while(iter.hasNext()){
                User u = iter.next();
                System.out.println("用户名："+u.getUser_name()+", 密码："+u.getPassword());
            }
            
            user.setComment("comment");
            userDao.update(user);
            //User u = userDao.findByUserName(user_name);
            User u = session.selectOne("com.shiyq.mybatis.config.UserDao.findByUserName",user_name);
            System.out.println("comment is "+u.getComment());
            
            //userDao.delete(user_name);
            System.out.println("记录条数："+userDao.countAll());
            session.commit();
        }
    }
}
