package com.service;

import com.pojo.Shipperaccount;
import com.vo.R;
import com.vo.param.*;

    public interface OrderService {

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



}
