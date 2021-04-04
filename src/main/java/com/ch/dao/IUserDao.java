package com.ch.dao;

import com.ch.pojo.User;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.util.List;

public interface IUserDao {

    //查询所有用户
    public List<User>findAll() throws Exception;
    //根据条件进行用户查询
    public User findByCondition(User user) throws Exception;
}
