/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.mybatis.config;

import java.util.List;

/**
 *
 * @author shiyq
 */
public interface UserDao {
    
    public int insert(User user);
    public int update(User user);
    public int delete(String user_name);
    public List<User> selectAll();
    public int countAll();
    public User findByUserName(String user_name);
}
