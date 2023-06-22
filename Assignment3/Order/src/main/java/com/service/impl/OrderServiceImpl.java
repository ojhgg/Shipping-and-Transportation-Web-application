package com.service.impl;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.*;
import com.pojo.*;
import com.pojo.Billing;
import com.pojo.Shipment;
import com.vo.R;
import com.vo.param.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.service.*;
import java.time.LocalDate;
import java.util.Date;


/**
 * FileName:  OrderServiceImpl
 * Date: 2023/04/13
 */
@Service
@AllArgsConstructor
public  class OrderServiceImpl implements OrderService {
  ;
    @Autowired
    private final ShipmentMapper shipmentMapper;
    @Autowired
    private final BillingMapper billingMapper;
    @Autowired
    private final ParcelMapper parcelMapper;

    @Override
    public R Billing(Param2 accountnumber) {
        R r = new R();
        r.data("status_code", false);
        QueryWrapper<Billing> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accountnumber", accountnumber.getAccountnumber());
        try {
            Billing billing = billingMapper.selectOne(queryWrapper);
            r.data("billing", billing);
            r.data("status_code", true);
            return r;
        } catch (Exception e) {
            r.setMessage(e.toString());
        }
        return r;
    }
    //修改密码


    @Override
    public R tracking(Param itemid) {
        R r = new R();
        r.data("status_code", false);
        QueryWrapper<Shipment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parcels", itemid.getItemid());
        Shipment shipment = shipmentMapper.selectOne(queryWrapper);
        if (shipment != null) {
            if (shipment.getReturnTo() != null) {
                r.data("address", shipment.getReturnTo());
                r.data("time",shipment.getUpdateat());
                r.data("status_code", true);
                return r;
            }
        }
        r.setMessage("记录不存在");
        return r;
    }

    public String getToken(LoginParam user) {
        String token;
        token = JWT.create().withAudience(user.getUsername())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    // 主页请求用户信息


    @Override
    public R createOrder(CreateOrderParam createOrderParam, String id) {
        R r = new R();
        int i = 0, j = 0, k = 0;
        QueryWrapper<Parcel> queryWrapper = new QueryWrapper<Parcel>();
        queryWrapper.eq("parcelsid", createOrderParam.getParcels().getParcelsid());
        boolean A = parcelMapper.exists(queryWrapper);
        if (A) {
            r.data("status_code", false);
            r.setMessage("包裹已存在");
            return r;//创建订单}
        }
        else{

                Billing billing = new Billing();
                Shipment shipment = new Shipment();
                Parcel parcels = new Parcel();
                Parcels p = createOrderParam.getParcels();
                shipment.setParcels(p.getParcelsid());
                parcels.setParcelsid(p.getParcelsid());
                parcels.setDescription(p.getDescription());
                parcels.setWeight(p.getWeight());
                parcels.setQuantity(p.getQuantity());
                parcels.setBoxtype(parcels.getBoxtype());
                shipment.setReturnTo(createOrderParam.getReturnto());
                shipment.setShipfrom(createOrderParam.getShipfrom());
                shipment.setShipto(createOrderParam.getShipto());
                shipment.setServicetype(createOrderParam.getType());
                shipment.setUpdateat(LocalDate.now().toString());
                billing.setAccountNumber(id);
                billing.setType(createOrderParam.getType());
                billing.setPaidBy(id);
                i = shipmentMapper.insert(shipment);
                j = billingMapper.insert(billing);
                k = parcelMapper.insert(parcels);

                if (i == 1 && j == 1 && k == 1) r.data("status_code", true);
                return r;//创建订单
            }
        }
    }
