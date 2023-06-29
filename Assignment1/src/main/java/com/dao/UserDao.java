package com.dao;

import com.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserDao {

    @Select("select * from user")
    public List<User> findAll();
    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    @Insert("INSERT INTO user (username, password, email) VALUES (#{username}, #{password}, #{email})")
    public void registerUser(@Param("username") String username, @Param("password") String password, @Param("email") String email);
    @Select("select * from shipment where parcels = #{itemid}")
    public Shipment trackShipment(@Param("itemid") String itemid);

    @Insert("INSERT INTO shipment (returnto, shipfrom, shipto, servicetype, parcels, updateat) " +
            "VALUES (#{returnto}, #{shipfrom}, #{shipto}, #{servicetype}, #{parcels}, #{updateat})")
    public int  insertShipment(@Param("returnto")String  returnto, @Param("shipfrom")String  shipfrom,@Param("shipto")String  shipto,@Param("servicetype")String  servicetype,@Param("parcels")String  parcels,@Param("updateat")String updateat );
    @Insert("INSERT INTO billing (id, accountnumber, type, paidby) VALUES (#{id}, #{accountnumber}, #{type}, #{paidby})")
    public void insertBilling(@Param("id")String  id, @Param("accountnumber")String  accountnumber,@Param("type")String   type,@Param("paidby")String  paidby);

}
