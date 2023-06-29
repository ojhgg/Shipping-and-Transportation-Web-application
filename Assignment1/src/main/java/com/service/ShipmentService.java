package com.service;

import com.dao.UserDao;
import com.entity.Shipment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

@Service
public class ShipmentService {
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
    public ShipmentService(){
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
    public Shipment getShipmentDetails(String itemid) {
        // 根据 item ID 查询航运详情的逻辑
        // ...
        // 示例：创建一个 Shipment 对象并返回
        Shipment shipment ;
        shipment=dao.trackShipment(itemid);
        return shipment;
    }
    public void createShipmentOrder(String  returnto, String  shipfrom,String  shipto,String  servicetype,String  parcels,String updateat ){

        dao.insertShipment( returnto, shipfrom,shipto,servicetype,parcels,updateat );
    }
    public  int createBilling(String  id,String  accountnumber, String   type, String  paidby) {
        try {
            dao.insertBilling(id, accountnumber, type, paidby);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
}
