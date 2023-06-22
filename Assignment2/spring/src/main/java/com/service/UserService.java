package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pojo.Shipperaccount;
import com.vo.R;
import com.vo.param.*;

    public interface UserService {
    /**
     * 1.登陆
     *
     * @param loginParam（token,用户名,密码）
     * @return
     */
    R login(LoginParam loginParam);

    /**
     * 2.注册
     * @param registerParam(用户名,密码）
     * @return
     */
    R register(RegisterParam registerParam);
    /**
     * 3.改密码
     * @get getInformation(旧密码，新密码，token)
     * @return
     */
    R Billing(Param2 accountnumber);


        /**
     * 4.主页信息获取
     * @get getInformation(token)
     * @return
     */
    R tracking(Param itemid);
    /**
     * 5.修改个人信息
     * @get getInformation(手机号，所属中转，token)
     * @return
     */
    R createOrder(CreateOrderParam createOrderParam, String id);
   Shipperaccount findUserById(String username);



}
