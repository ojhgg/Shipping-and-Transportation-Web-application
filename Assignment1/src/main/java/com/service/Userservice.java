package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
@Service
public class Userservice {
    private InputStream in;
    SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao dao;
    @Before
    public void init() throws IOException {
//        读取配置文件
        in= Resources.getResourceAsStream("MybatisConfig.xml");
//        获取工厂对象
        factory=new SqlSessionFactoryBuilder().build(in);
//        利用工厂获取sqlSession对象
        sqlSession=factory.openSession();
//        最后利用SqlSession对象获取dao对象
        dao=sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }
    public Userservice(){
        //        读取配置文件
        try {
            this.in= Resources.getResourceAsStream("MybatisConfig.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        获取工厂对象
        this.factory=new SqlSessionFactoryBuilder().build(in);
//        利用工厂获取sqlSession对象
        this.sqlSession=factory.openSession();
//        最后利用SqlSession对象获取dao对象
        this.dao=sqlSession.getMapper(UserDao.class);

    }
    @Test
    public User findByUsernameAndPassword(String username, String password)
    {
        User user=dao.findByUsernameAndPassword(username,password);
        return  user;
    }

    public void  registerUser(String username,  String password, String email) {
        dao.registerUser(username,password,email);
    }
}
