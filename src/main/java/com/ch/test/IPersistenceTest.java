package com.ch.test;

import com.ch.dao.IUserDao;
import com.ch.io.Resources;
import com.ch.pojo.User;
import com.ch.sqlSession.SqlSession;
import com.ch.sqlSession.SqlSessionFactory;
import com.ch.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public  void test() throws Exception {
        InputStream resourcesAsStream = Resources.getResourcesAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourcesAsStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
       /* User user2 = sqlSession.selectOne("user.selectOne", user);
        System.out.println("查询到的值"+user2);*/
      /*  List<User> users = sqlSession.selectLsit("user.selectList", user);

        for (int i = 0; i <users.size() ; i++) {
            System.out.println(users.get(i));
        }*/
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
       // userDao.findAll()
        User user2 = userDao.findByCondition(user);
        List<User> all = userDao.findAll();
        System.out.println("用户信息"+user2);
        System.out.println("用户信息全部"+all);

    }
}
