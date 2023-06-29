package com.shipping.repository;

import com.dao.UserDao;
import com.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

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

    @Test
    public void testFindAll(){
        System.out.println("test start");
        //执行findAll方法，获取电影集合
        List<User> movies=dao.findAll();
        for(User movie:movies){
            System.out.println(movie.getPassword());
        }
    }
}

